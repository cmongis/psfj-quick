/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import mongis.utils.FXUtilities;
import mongis.utils.task.ProgressHandler;
import org.scijava.Context;
import org.scijava.Initializable;
import org.scijava.event.EventHandler;
import org.scijava.plugin.Parameter;
import psfj.uifx.service.UiModelService;
import org.scijava.plugin.PostInject;
import psfj.uifx.dataview.ContextInjectorFactory;
import psfj.uifx.dataview.DataPaneController;
import psfj.uifx.dataview.DefaultDataPaneController;
import psfj.uifx.event.ImagesLoadedEvent;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;
import psfj.uifx.widgets.MultichannelImageDataView;
import psfj.uifx.widgets.MultichannelImageGroupDataView;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class ImageListPageController extends BorderPane implements Initializable {

    @FXML
    private VBox groupListVBox;

    DataPaneController groupListCtrl;

    @FXML
    private VBox imageListVBox;

    DataPaneController imageListCtrl;

    @FXML
    private CheckBox multifieldModeCheckBox;

    @Parameter
    UiModelService uiModelService;

    @Parameter
    Context context;
    
    public ImageListPageController() throws Exception {
        super();

        FXUtilities.injectFXML(this, "/fxml/ImageListPageController.fxml");

    }

    @PostInject
    public void init() {

        imageListCtrl = new DefaultDataPaneController<MultichannelImage>()
                .bind(uiModelService.getUiModel().imageListProperty())
                .setPane(imageListVBox)
                .setDataViewFactory(new ContextInjectorFactory<>(context,MultichannelImageDataView.class));

        groupListCtrl = new DefaultDataPaneController<MultichannelImageGroup>()
                .bind(uiModelService.getUiModel().groupListProperty())
                .setPane(groupListVBox)
                .setDataViewFactory(new ContextInjectorFactory<>(context,MultichannelImageGroupDataView.class));

        //imageListView.setItems(uiModelService.getUiModel().imageListProperty());
        uiModelService.getUiModel().multifieldModeProperty().addListener(this::onMultifieldModeChanged);

        multifieldModeCheckBox.selectedProperty().bindBidirectional(uiModelService.getUiModel().multifieldModeProperty());

        onMultifieldModeChanged(null, Boolean.FALSE, uiModelService.getUiModel().isMultifieldMode());
    }

    private void onMultifieldModeChanged(Observable obs, Boolean oldValue, Boolean newValue) {

        System.out.println("Change !");
        imageListVBox.setVisible(!newValue);
        groupListVBox.setVisible(newValue);
    }
    
    @EventHandler
    public void handle(ImagesLoadedEvent event) {
        imageListCtrl.update(ProgressHandler.NONE);
        groupListCtrl.update(ProgressHandler.NONE);
    }

}
