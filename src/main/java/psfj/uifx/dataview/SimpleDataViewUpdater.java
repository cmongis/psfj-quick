/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.scene.Node;
import mongis.utils.task.ProgressHandler;

/**
 *
 * @author cyril
 */
public class SimpleDataViewUpdater<T> implements DataPaneUpdater<T> {

    @Override
    public void update(ProgressHandler handler, DataViewFactory<T> factory, List<DataView<T>> viewList, List<Node> nodeList, List<T> items) {

        int difference = items.size() - nodeList.size();

        // if there is more items than node
        if (difference > 0) {
            List<DataView<T>> created = create(factory, difference);

            viewList.addAll(created);

            nodeList.addAll(created
                    .stream()
                    .map(dataview -> dataview.getNode())
                    .collect(Collectors.toList())
            );
        } else {
            if (difference < 0) {

                List<DataView<T>> toDelete = viewList.subList(items.size(), viewList.size());
                final List<Node> nodesToRemove = toDelete.stream().map(dataView -> dataView.getNode()).collect(Collectors.toList());
                viewList.removeAll(toDelete);

                Platform.runLater(()->nodeList.removeAll(nodesToRemove));

            }
        }
        for (int i = 0; i != items.size(); i++) {
            DataView<T> view = viewList.get(i);
            T item = items.get(i);

            if (view.getItem() != item) {
                view.setItem(item);
                view.update();
            } else if (item.hashCode() != view.getLastItemHash()) {
                view.update();
            }
        }
    }

    public List<DataView<T>> create(DataViewFactory<T> factory, int number) {

        List<DataView<T>> newDataView = new ArrayList<>();
        
        if(factory == null) {
            throw new IllegalStateException("No factory were specified");
        }
        
        
        for (int i = 0; i != number; i++) {

            try {
                newDataView.add(factory.create());
            } catch (Exception e) {
                throw new IllegalStateException("Factory fails to initiate objects "+factory.getClass().getSimpleName(), e);
                
            }

        }

        return newDataView;
    }

}
