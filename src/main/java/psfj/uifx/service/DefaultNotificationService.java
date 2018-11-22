/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import org.scijava.plugin.Plugin;
import org.scijava.service.Service;

/**
 *
 * @author cyrilmongis
 */
@Plugin(type = Service.class)
public class DefaultNotificationService extends AbstractPsfjUiService implements NotificationService {

    @Override
    public void error(String message) {
        
        System.out.println(message);
                
                
    }

    @Override
    public void notify(String message) {
        System.out.println(message);
    }
    
}
