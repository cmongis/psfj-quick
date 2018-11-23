/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.util.ArrayList;
import java.util.List;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.service.Service;
import psfj.uifx.reducers.Reducer;

/**
 * This service initialize the different Effects
 * @author cyrilmongis
 */
@Plugin(type = Service.class)
public class DefaultEffectService extends AbstractPsfjUiService implements EffectService{
    
    
     @Parameter
     private PluginService pluginService;
    
     List<Reducer> reducers = new ArrayList<>();
     
    @Override
    public void initialize() {
       reducers = pluginService.createInstancesOfType(Reducer.class);
    }
    
    
}
