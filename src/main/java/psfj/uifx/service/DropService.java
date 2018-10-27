/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;


import static com.sun.tools.doclint.Entity.image;
import java.io.File;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.AbstractService;
import org.scijava.service.SciJavaService;
import org.scijava.service.Service;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
@Plugin(type = Service.class)
public class DropService extends AbstractService implements SciJavaService{
    
    @Parameter
    private UiModelService modelService;
    
    private static final String IMG_PREFIX = "multichannelimage://";
    
    private static final String GROUP_PREFIX = "multichannelimagegroup://";
    
    public String getDropId(MultichannelImage dropId) {
       return IMG_PREFIX + modelService.getUiModel().imageListProperty().indexOf(image);
    }
    
    public void dropIn(File file) {
        
    }
    
    
    public void dropIn(String dropId) {
        
    }
    
    public void dropIn(File file, MultichannelImage image) {
        
    }
    
    
    public void dropIn(String dropId, MultichannelImage image) {
        
    }
    
    public void dropIn(String dropId, MultichannelImageGroup group) {
        
    }
    
    public void dropIn(File file, MultichannelImageGroup group) {
        
    }
    
    public MultichannelImage getMultichannelImage(String dropId) {
        
        
        if(dropId == null) {
            throw new IllegalArgumentException("The drop ID is null");
        }
        
        if(dropId.startsWith(IMG_PREFIX)) {
            int index =  new Integer(dropId.substring(IMG_PREFIX.length()));
            return modelService.getUiModel().imageListProperty().get(index);
        }
        
        else {
            return null;
        }
    }
    
     public MultichannelImageGroup getMultichannelImageGroup(String dropId) {
        
        
        if(dropId == null) {
            throw new IllegalArgumentException("The drop ID is null");
        }
        
        if(dropId.startsWith(IMG_PREFIX)) {
            int index =  new Integer(dropId.substring(IMG_PREFIX.length()));
            return modelService.getUiModel().groupListProperty().get(index);
        }
        
        else {
            return null;
        }
    }
    
}
