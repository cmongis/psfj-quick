package psfj.uifx;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import mongis.utils.FXUtilities;
import mongis.utils.task.FluentTask;
import org.scijava.Context;
import org.scijava.event.EventService;
import org.scijava.plugin.Bean;
import org.scijava.plugin.Parameter;
import psfj.uifx.service.FileOpenerService;
import psfj.uifx.service.UiModelService;
import psfj.uifx.service.UiStep;

public class MainWindowController implements Initializable {

    @FXML
    AnchorPane contentPane;

    @Parameter
    private UiModelService uiModelService;

    @Parameter
    private EventService eventService;

    @Parameter
    private FileOpenerService fileOpenerService;

    @Bean
    private WelcomePageController welcomePageController;

    @Bean
    private ImageListPageController imageListPageController;

    private Node center;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        new FluentTask()
                .run(this::init)
                .then(this::afterInit)
                .start();

    }

    private void init() {
        Context context = new Context();
        context.inject(this);
    }

    private void afterInit(Object o) {
        
        uiModelService
                .getUiModel()
                .currentStepProperty()
                .addListener(this::onStepChanged);
        
        setCenter(welcomePageController);
        fileOpenerService.open(new File("/home/cyril/psfj-test-data"));
    }

    private void setCenter(Node node) {
        if (center != null) {
            contentPane.getChildren().remove(center);
        }

        center = node;
        if (center != null) {
            contentPane.getChildren().add(node);
            FXUtilities.setAnchors(node, 0);
        }
    }

    protected void onStepChanged(Observable obs, UiStep oldValue, UiStep newValue) {
        if (newValue == UiStep.WELCOME) {
            setCenter(welcomePageController);
        } else if (newValue == UiStep.ADD_IMAGE) {
            setCenter(imageListPageController);
        }
    }

}
