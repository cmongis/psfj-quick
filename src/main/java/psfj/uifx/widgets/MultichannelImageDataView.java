/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.widgets;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import psfj.uifx.dataview.AbstractFXMLDataView;
import psfj.uifx.actions.AddChannelToImageAction;
import psfj.uifx.actions.AddFileAsChannelToImageAction;
import psfj.uifx.event.RemoveImageAction;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.service.UiModelService;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class MultichannelImageDataView extends AbstractFXMLDataView<MultichannelImage> {

  

    @FXML
    private HBox channelHBox;

    @FXML
    private Label imageNameLabel;

    @Parameter
    private EventService eventService;
   
    @Parameter
    private UiModelService uiModelService;
    
    public MultichannelImageDataView() throws Exception {

       init("/fxml/widgets/MultichannelImageDataView.fxml");

    }
    
    @Override
    public void update() {
        updateLabel();
        updateChannels();
    }

    private void updateLabel() {
        imageNameLabel.setText(getItem().getName());
    }
    private void updateChannels() {
        channelHBox.getChildren().clear();
        for(int i = 0;getItem().hasChannel(i);i++) {
            
            channelHBox.getChildren().add(new TextField(getItem().getMicroscope(i).getWaveLengthAsString()));
        }
    }
    
    
    @FXML
    public void addChannel() {
        eventService.publish(new AddFileAsChannelToImageAction(getItem()));
    }
    
    @FXML
    public void delete() {
        eventService.publish(new RemoveImageAction(getItem()));
    }

}
