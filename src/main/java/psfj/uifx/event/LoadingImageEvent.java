/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.event;

import javafx.concurrent.Task;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class LoadingImageEvent extends PsfjEvent<Task> {
        
    public LoadingImageEvent(Task data) {
        super(data);
    }
        
}
