/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.widgets;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import mongis.utils.FXUtilities;
import mongis.utils.listcell.EasyCellFactory;
import mongis.utils.listcell.ListCellController;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class MultichannelImageGroupCellCtrl extends BorderPane implements ListCellController<MultichannelImageGroup>  {

    
    
    
    @FXML
    Label label;
    
    @FXML
    ListView<MultichannelImage> listView;
    
    MultichannelImageGroup group;
    
    public MultichannelImageGroupCellCtrl() {
        try {
            FXUtilities.injectFXML(this, "/fxml/widgets/MultichannelImageGroupCellCtrl.fxml");
        } catch (IOException ex) {
            Logger.getLogger(MultichannelImageGroupCellCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        listView.setCellFactory(new EasyCellFactory<>(MultichannelImageCellCtrl.class));
        
    }
    
    
    @Override
    public void setItem(MultichannelImageGroup t) {
        this.group = t;
        listView.setItems(FXCollections.observableArrayList(group.getImageList()));
    }

    @Override
    public MultichannelImageGroup getItem() {
        return group;
    }
    
}
