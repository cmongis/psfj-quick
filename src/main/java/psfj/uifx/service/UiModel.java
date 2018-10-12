/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import mongis.utils.task.TaskList;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public interface UiModel {
    
    
    ReadOnlyProperty<UiStep> currentStepProperty();
    
    
    ReadOnlyProperty<File> exportFolderProperty();
    
    TaskList taskListProperty();
    
    ReadOnlyBooleanProperty readyProperty();
    
    ObservableList<MultichannelImageGroup> groupListProperty();
    
    ObservableList<MultichannelImage> imageListProperty();
    
    BooleanProperty multifieldModeProperty();
    
    BooleanProperty showLoadingProperty();
    
    ReadOnlyProperty<Task> currentTaskProperty();
    
    
    default boolean isMultifieldMode() {
        return multifieldModeProperty().get();
    }
    
    default boolean isShowLoading() {
        return showLoadingProperty().get();
    }
    
    default File getExportFolder() {
        return exportFolderProperty().getValue();
    }
    
}
