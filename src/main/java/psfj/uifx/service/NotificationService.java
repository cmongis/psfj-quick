/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import org.scijava.service.SciJavaService;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public interface NotificationService extends SciJavaService {
    
    
    void error(String message);
    
    void notify(String message);
    
    
}
