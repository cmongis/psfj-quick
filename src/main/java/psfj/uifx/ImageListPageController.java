/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import mongis.utils.FXUtilities;
import mongis.utils.listcell.EasyCellFactory;
import org.scijava.Initializable;
import org.scijava.plugin.Parameter;
import psfj.uifx.model.MultichannelImageGroup;
import psfj.uifx.service.UiModelService;
import org.scijava.plugin.PostInject;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.widgets.MultichannelImageCellCtrl;
import psfj.uifx.widgets.MultichannelImageGroupCellCtrl;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */

public class ImageListPageController extends BorderPane implements Initializable {

    @FXML
    private ListView<MultichannelImageGroup> groupListView;

    @FXML
    private ListView<MultichannelImage> imageListView;
    
    
    @FXML
    private CheckBox multifieldModeCheckBox;
    
    
    @Parameter
    UiModelService uiModelService;

    public ImageListPageController() throws Exception {
        super();

        FXUtilities.injectFXML(this, "/fxml/ImageListPageController.fxml");

        EasyCellFactory<MultichannelImageGroup, MultichannelImageGroupCellCtrl> easyFactory
                = new EasyCellFactory<>(MultichannelImageGroupCellCtrl.class);

        groupListView.setCellFactory(easyFactory);
        
        imageListView.setCellFactory(new EasyCellFactory<>(MultichannelImageCellCtrl.class));
        
        
        
    }

    @PostInject
    public void init() {

        groupListView.setItems(uiModelService.getUiModel().groupListProperty());

        imageListView.setItems(uiModelService.getUiModel().imageListProperty());
        
        uiModelService.getUiModel().multifieldModeProperty().addListener(this::onMultifieldModeChanged);
        
        multifieldModeCheckBox.selectedProperty().bindBidirectional(uiModelService.getUiModel().multifieldModeProperty());
        
        onMultifieldModeChanged(null,Boolean.FALSE, uiModelService.getUiModel().isMultifieldMode());
    }

    private void onMultifieldModeChanged(Observable obs, Boolean oldValue, Boolean newValue) {
        
      System.out.println("Change !");
       imageListView.setVisible(!newValue);
       groupListView.setVisible(newValue);
    }
    
}
