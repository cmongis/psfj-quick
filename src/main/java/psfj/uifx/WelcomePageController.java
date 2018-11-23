/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import mongis.utils.FXUtilities;
import org.scijava.event.EventService;
import org.scijava.plugin.Parameter;
import psfj.uifx.event.OpenFileAction;
import psfj.uifx.service.UiModelService;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class WelcomePageController extends AnchorPane {

    
  
    @Parameter
    private EventService eventService;
    
    @Parameter
    private UiModelService uiModelService;
    
    public WelcomePageController() throws Exception {

        FXUtilities.injectFXML(this, "/fxml/WelcomePage.fxml");
        
    }
    
    @FXML
    protected void addFile() {
        
        
        File file = FXUtilities.openFileSync("Select file to open", null, "Image file",".*");
        
        eventService.publish(new OpenFileAction(file));
        
        
    }
    
    @FXML
    protected void addFolder() {
        File folder = FXUtilities.openFolder("Open the folder containing all the image", null);
        
        eventService.publish(new OpenFileAction(folder));
    }
    
    
    
 
}
