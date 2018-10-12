/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.util.stream.Collectors;
import javafx.application.Platform;
import org.scijava.event.EventHandler;
import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;
import psfj.uifx.event.ImagesLoadedEvent;
import psfj.uifx.event.LoadingImageEvent;
import psfj.uifx.event.OpenFileAction;

/**
 * The role of this service is to intercept data related event and update the
 * UiModel
 *
 * @author Cyril MONGIS ( http://www.cyrilmongis.net )
 */
@Plugin(type = Service.class)
public class DefaultUiModelService extends AbstractService implements UiModelService {

    private final DefaultUiModel uiModel = new DefaultUiModel();

    @Override
    public UiModel getUiModel() {
        return uiModel;
    }

    @EventHandler
    public void onOpenFileAction(OpenFileAction event) {
        uiModel.showLoadingProperty().setValue(true);
    }

    @EventHandler
    public void onLoadingTask(LoadingImageEvent event) {
        Platform.runLater(()->uiModel.taskListProperty().submitTask(event.getData()));
    }

    @EventHandler
    public void onImageLoadedEvent(ImagesLoadedEvent event) {
        
        
        uiModel.groupListProperty().addAll(event.getData());
        uiModel
                .imageListProperty()
                .addAll(event
                        .getData()
                        .stream()
                        .filter(group->group != null)
                        .flatMap(group->group.getImageList().stream())
                        .filter(image->image != null)
                        .collect(Collectors.toList()));
        boolean modelHasImages = true;
        
        if(uiModel.isMultifieldMode()) {
            modelHasImages = uiModel.groupListProperty().size() > 0;
        }
        else {
            modelHasImages = uiModel.imageListProperty().size() > 0;
        }
        
        if (modelHasImages && uiModel.currentStepProperty().getValue() == UiStep.WELCOME) {
            uiModel.currentStepProperty().setValue(UiStep.ADD_IMAGE);
        } else {
            uiModel.currentStepProperty().setValue(UiStep.WELCOME);
        }

    }

}
