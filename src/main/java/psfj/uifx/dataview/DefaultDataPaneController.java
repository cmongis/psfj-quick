/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import mongis.utils.task.ProgressHandler;

/**
 *
 * @author cyril
 */
public class DefaultDataPaneController<T extends Object> implements DataPaneController<T>{
    
    
    private DataViewFactory<T> dataViewFactory = new SimpleDataViewFactory<>();
    
    private List<DataView<T>> viewList = new ArrayList<>();
    
    private List<T> itemList = new ArrayList<>();

    private Pane pane;
    
    private DataPaneUpdater<T> updater = new SimpleDataViewUpdater<>();
    
    public DefaultDataPaneController<T> setDataViewFactory(DataViewFactory<T> dataViewFactory) {
        this.dataViewFactory = dataViewFactory;
        return this;
    }

    public DefaultDataPaneController<T> setUpdater(DataPaneUpdater<T> updater) {
        this.updater = updater;
        return this;
    }

    @Override
    public DataPaneController<T> setPane(Pane pane) {
        this.pane = pane;
        return this;
    }

    @Override
    public DataPaneController<T> setData(List<T> data) {
        this.itemList = data;
        
        return this;
    }

    @Override
    public DataPaneController<T> setDataViewFacoty(DataViewFactory<T> factory) {
       
        this.dataViewFactory = factory;
        return this;
        
    }

    @Override
    public void update(ProgressHandler handler) {
        
        if(dataViewFactory == null) {
            throw new IllegalArgumentException("The DataView Factory was not set");
        }
        
        
        handler = ProgressHandler.check(handler);
        this.updater.update(handler, dataViewFactory, viewList, pane.getChildren(),itemList);
    }
}
