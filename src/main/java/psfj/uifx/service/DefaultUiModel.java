/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import mongis.utils.task.TaskList;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class DefaultUiModel implements UiModel{

    
    private final ObjectProperty<UiStep> currentStepProperty = new SimpleObjectProperty<>(UiStep.WELCOME);
    
    private final ObjectProperty<File> currentExportFolderProperty = new SimpleObjectProperty<>(null);
    
    private final TaskList taskList = new TaskList();
    
    private final ObservableList<MultichannelImageGroup> groupListProperty = FXCollections.observableArrayList();
    
    private final ObservableList<MultichannelImage> imageListProperty = FXCollections.observableArrayList();
    
    private final BooleanProperty readyProperty = new SimpleBooleanProperty();
    
    private final BooleanProperty showLoadingProperty = new SimpleBooleanProperty();
    
    private final BooleanProperty multifieldModeProperty = new SimpleBooleanProperty(false);
    
    @Override
    public Property<UiStep> currentStepProperty() {
        return currentStepProperty;
    }

    @Override
    public Property<File> exportFolderProperty() {
        return currentExportFolderProperty;
    }

    @Override
    public TaskList taskListProperty() {
        return taskList;
    }

    @Override
    public BooleanProperty readyProperty() {
        return readyProperty;
    }

    @Override
    public ObservableList<MultichannelImageGroup> groupListProperty() {
        return groupListProperty;
    }
    
    @Override
    public BooleanProperty showLoadingProperty() {
        return showLoadingProperty;
    }
    
    @Override
    public Property<Task> currentTaskProperty() {
        return taskList.foregroundTaskProperty();
    }

    @Override
    public BooleanProperty multifieldModeProperty() {
        return multifieldModeProperty;
    }
    
    @Override
    public ObservableList<MultichannelImage> imageListProperty() {
        return imageListProperty;
    }
    
    
    
    
    
}
