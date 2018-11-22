/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import knop.psfj.BeadImage;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import psfj.uifx.event.RemoveImageAction;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;


/**
 * This service is responsible of managing the open data.
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
@Plugin(type = Service.class)
public class DataManagerService extends AbstractPsfjUiService{
    
    
    
    @Parameter
    FileOpenerService fileOpenerService;
    
    @Parameter
    NotificationService notificationService;
    
    @Parameter
    EventService eventService;
    
    public void addMultichannelImage(MultichannelImage image) {
        
    }
    
    public void addFile(File file) {
        
       
        fileOpenerService.open(file);
        
        
    }
    
    public void addFile(MultichannelImage target, File data) {
        
    }
    
    public void addChannelToImage(MultichannelImage target, MultichannelImage data) {
        
         for(int i = 0;i!=data.getImages().size();i++) {
            
             BeadImage image = data.getImages().get(i);
             target.addImage(image);
             target.setWavelenth(target.getImages().size()-1, image.getMicroscope().getWaveLength());
            
         }
         
         eventService.publish(new RemoveImageAction(data));

    }
    
    public void addImageToGroup(MultichannelImage image, MultichannelImageGroup target) {
        
        target.getImageList().add(image);
        
        eventService.publish(new RemoveImageAction(image));
        
        
    }
    
   
    
}
