/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 *
 * @author cyril
 */
public abstract class AbstractFXMLDataView<T extends Object> extends AbstractDataView<T>{
    
    protected Node root;
    
    protected void init(String fxml) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource(fxml));
        loader.setController(this);
        loader.load();
        
        root = loader.getRoot();    
    }
        
    public Node getNode() {
        return root;
    }

}
