/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import org.scijava.service.SciJavaService;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public interface FileOpenerService extends SciJavaService{
    
    
    public void open(File file);
    
    
}
