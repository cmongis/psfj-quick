/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import knop.psfj.BeadImageLoader;
import knop.psfj.BeadImageLoadingException;
import knop.psfj.DefaultBeadImageLoader;
import mongis.utils.task.FluentTask;
import mongis.utils.task.ProgressHandler;
import org.scijava.event.EventHandler;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import org.scijava.service.Service;
import psfj.uifx.event.ImagesLoadedEvent;
import psfj.uifx.event.LoadingImageEvent;
import psfj.uifx.event.OpenFileAction;
import psfj.uifx.model.DefaultMultichannelImage;
import psfj.uifx.model.DefaultMultichannelImageGroup;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
@Plugin(type = Service.class)
public class DefaultFileOpenerService extends AbstractPsfjUiService implements FileOpenerService {

    @Parameter
    EventService eventService;

    @Override
    public void open(File file) {
        FluentTask task = new FluentTask<File, List<MultichannelImageGroup>>()
                .setInput(file)
                .callback(this::openFile)
                .then(this::onImageLoadingOver);

        eventService.publish(new LoadingImageEvent(task));

        task.start();
    }
    
    @EventHandler
    public void onOpenFileAction(OpenFileAction action) {
        open(action.getData());
    }

    public MultichannelImageGroup openSingleImage(ProgressHandler handler, File file) {
       handler.setStatus(new StringBuilder()
                            .append("Opening ...")
                            .append(file.getName())
                            .append("...")
                            .toString()
                    );
       handler.increment(1);
       MultichannelImage image = openImage(file);
       
       if(image != null) {
           return new DefaultMultichannelImageGroup(image);
       }
       else {        
           return null;
       }
    }
    
    
     public List<MultichannelImageGroup> openFile(ProgressHandler handler, File file) {
        
         
         
        if(file.isDirectory()) {
         
        handler.setTotal(file.listFiles().length);

        List<MultichannelImageGroup> collect = Stream
                .of(file.listFiles())
                .filter(f -> f.isDirectory() == false)
                .map(f->openSingleImage(handler, f))
                .filter(f->f!=null)
                .collect(Collectors.toList());

        return collect;
        }
        
        else {
            List<MultichannelImageGroup> list = new ArrayList<>();
            
            MultichannelImageGroup image = openSingleImage(handler,file);
            if(image != null) {
                list.add(image);
            }
            
            return list;
   
        }
    }

    private MultichannelImage openImage(File f) {

        try {
            BeadImageLoader loader = new DefaultBeadImageLoader();
            return new DefaultMultichannelImage(loader.load(f.getAbsolutePath(), true));
        } catch (BeadImageLoadingException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void onImageLoadingOver(List<MultichannelImageGroup> list) {
        eventService.publish(new ImagesLoadedEvent(list));
    }

   
}
