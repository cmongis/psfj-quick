/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx;

import javafx.application.Application;
import static javafx.application.Application.launch;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class Main {
        /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(MainController.class, args);
    }
}
