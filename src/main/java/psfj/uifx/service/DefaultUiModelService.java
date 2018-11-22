/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Platform;
import knop.psfj.BeadImage;
import org.scijava.event.EventHandler;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.service.AbstractService;
import org.scijava.service.Service;
import psfj.uifx.event.ImageRemovedEvent;
import psfj.uifx.event.ImagesLoadedEvent;
import psfj.uifx.event.LoadingImageEvent;
import psfj.uifx.event.OpenFileAction;
import psfj.uifx.event.RemoveImageAction;
import psfj.uifx.reducers.Reducer;

/**
 * The role of this service is to intercept data related event and update the
 * UiModel
 *
 * @author Cyril MONGIS ( http://www.cyrilmongis.net )
 */
@Plugin(type = Service.class)
public class DefaultUiModelService extends AbstractService implements UiModelService {

    private final DefaultUiModel uiModel = new DefaultUiModel();

    private List<Reducer> reducers;
    
    private PluginService pluginService;
    
    @Override
    public void initialize() {
       reducers = pluginService.createInstancesOfType(Reducer.class);
    }
    
    
    @Parameter
    public EventService eventService;

    @Override
    public UiModel getUiModel() {
        return uiModel;
    }

    
    
   

}
