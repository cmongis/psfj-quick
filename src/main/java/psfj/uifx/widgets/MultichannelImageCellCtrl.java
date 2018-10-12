/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.widgets;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import mongis.utils.FXUtilities;
import mongis.utils.listcell.ListCellController;
import psfj.uifx.model.MultichannelImage;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class MultichannelImageCellCtrl extends BorderPane implements ListCellController<MultichannelImage> {

    MultichannelImage item;

    @FXML
    private HBox channelHBox;

    @FXML
    private Label imageNameLabel;

    public MultichannelImageCellCtrl() throws Exception {

        FXUtilities.injectFXML(this, "/fxml/widgets/MultichannelImageCellCtrl.fxml");

    }

    public void setItem(MultichannelImage item) {
        this.item = item;

        if (item != null) {
            updateLabel();
            updateChannels();
        }

    }

    public MultichannelImage getItem() {
        return item;
    }

    private void updateLabel() {
        imageNameLabel.setText(item.getName());
    }

    private void updateChannels() {
        channelHBox.getChildren().clear();
        
        
        for(int i = 0;item.hasChannel(i);i++) {
            
            channelHBox.getChildren().add(new TextField(item.getMicroscope(i).getWaveLengthAsString()));
            
           
        }
        
    }

}
