/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 *
 * @author cyril
 */
public class SimpleDataView<T extends Object> implements DataView<T>{

    
    T item;

    Label label = new Label();
    
    int lastHash = 0;
    
    public void setItem(T item) {
        this.item = item;
        
        if(item != null) {
            lastHash = item.hashCode();
        }
        
    }

    public T getItem() {
        return item;
    }
    
   

    @Override
    public Node getNode() {
        return label;
    }

    @Override
    public void update() {
        
        label.setText(item == null ? "null" : item.toString());
        
    }

    @Override
    public int getLastItemHash() {
        return lastHash;
    }
    
}
