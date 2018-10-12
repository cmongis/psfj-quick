/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import javafx.scene.Node;

/**
 *
 * @author cyril
 */
public interface DataView<T extends Object> {
    
    T getItem();
    
    void setItem(T t);
    
    Node getNode();
    
    void update();
    
    default void clear() {
        
    }
    
    int getLastItemHash();
    
}
