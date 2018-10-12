/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx;

import java.util.logging.Logger;


/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class PsfjUiLogger {
    
   private static final Logger LOGGER = Logger.getLogger(PsfjUiLogger.class.getName());
    
   public static Logger get() {
       return LOGGER;
   }
    
    
}
