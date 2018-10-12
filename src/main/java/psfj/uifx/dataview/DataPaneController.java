/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.util.List;
import javafx.scene.layout.Pane;
import mongis.utils.task.ProgressHandler;

/**
 *
 * @author cyril
 */
public interface DataPaneController<T> {
    
    
    DataPaneController<T> setPane(Pane pane);
    
    DataPaneController<T> setUpdater(DataPaneUpdater<T> updater);
    
    DataPaneController<T> setData(List<T> data);
    
    DataPaneController<T> setDataViewFacoty(DataViewFactory<T> factory);
    
    void update(ProgressHandler handler);
    
}
