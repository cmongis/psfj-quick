/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public enum UiStep {
    
    
    INITIALIZING("Initializing"),
    
    WELCOME("Welcome !"),
    
    ADD_IMAGE("Add images"),
    
    PROCESSING("Processing"),
    
    END("Over...")
    
    ;
    
    
    
    private final String name;
   
    
    UiStep(String n) {
        name = n;
    }

    

   

    

    
    
}
