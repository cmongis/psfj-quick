/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.util.List;
import javafx.scene.Node;
import mongis.utils.task.ProgressHandler;

/**
 *
 * @author cyril
 */
@FunctionalInterface
public interface DataPaneUpdater<T> {

    public void update(ProgressHandler handler, DataViewFactory<T> factory, List<DataView<T>> viewList, List<Node> nodeList, List<T> items);
    
}
