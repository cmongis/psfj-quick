/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.effects;

import java.io.File;
import mongis.utils.task.FluentTask;
import org.scijava.event.EventHandler;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import psfj.uifx.actions.AddChannelToImageAction;
import psfj.uifx.actions.AddFileAsChannelToImageAction;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.service.AbstractPsfjUiService;
import psfj.uifx.service.FileOpenerService;

/**
 *
 * @author cyrilmongis
 */
@Plugin(type = Service.class)
public class ImageActionService extends AbstractPsfjUiService{
    
    
    @Parameter
    private FileOpenerService fileOpenerService;
    
    @Parameter
    private EventService eventService;
    
    @EventHandler
    public void onFileAsChannelToImage(AddFileAsChannelToImageAction action) {
        
        
        File file = fileOpenerService.promptFileOpen();
        
        if(file != null) {
            
            new FluentTask<File,MultichannelImage>()
                    .setInput(file)
                    .callback((progress,f)-> {
                        MultichannelImage image = fileOpenerService.openSingleImage(progress,f);
                        return image;
                    })
                    .then( image-> eventService.publish(new AddChannelToImageAction(action.getData(),image)))
                    .start();   
            
           
        }        
    }
}
