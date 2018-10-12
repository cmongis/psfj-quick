/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.scene.Node;
import mongis.utils.task.ProgressHandler;

/**
 *
 * @author cyril
 */
public class SimpleDataViewUpdater<T> implements DataPaneUpdater<T>{

    
   
    
    @Override
    public void update(ProgressHandler handler, DataViewFactory<T> factory, List<DataView<T>> viewList, List<Node> nodeList, List<T> items) {
       
        int difference = items.size() - nodeList.size() ;
        
        
        // if there is more items than node
        if(difference > 0) {
            List<DataView<T>> created = IntStream
                    .of(difference)
                    .mapToObj(i->factory.create())
                    .collect(Collectors.toList());
                    
            
            viewList.addAll(created);
            
            nodeList.addAll(created
                    .stream()
                    .map(dataview->dataview.getNode())
                    .collect(Collectors.toList())
            );
        }
        else {
            if(difference < 0) {
                
                List<DataView<T>> toDelete = viewList.subList(items.size(),viewList.size());
                
                viewList.removeAll(toDelete);
                
                nodeList.removeAll(toDelete.stream().map(dataView->dataView.getNode()).collect(Collectors.toList()));
                
                
            }
        }
        for(int i = 0; i!= items.size();i++) {  
            DataView<T> view = viewList.get(i);
            T item = items.get(i);
            
            if(view.getItem() != item) {
                view.setItem(item);
            }
            else if(item.hashCode() != view.getLastItemHash()) {
                view.update();
            }
        } 
    }
}
