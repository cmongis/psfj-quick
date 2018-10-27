package psfj.uifx;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class MainController extends Application {
    
    
    private static String STYLESHEET = "/styles/Styles.css";
    private static String DEV_STYLE_SHEET;
    @Override
    public void start(Stage stage) throws Exception {
        
        DEV_STYLE_SHEET =  "file://" + new File("src/main/resources/styles/Styles.css").getAbsolutePath();
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add(STYLESHEET);
        scene.getStylesheets().add(DEV_STYLE_SHEET);
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        
        
        scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent->{
            
            scene.getStylesheets().remove(STYLESHEET);
            
            System.out.println("it happened !");
            if(keyEvent.getCode() == KeyCode.F5) {
                
                System.out.println(new File("./").getAbsolutePath());
                
                scene.getStylesheets().remove(DEV_STYLE_SHEET);
                
                scene.getStylesheets().add(DEV_STYLE_SHEET);
                
            }
        
        
        });
        
    }



}
