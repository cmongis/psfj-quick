/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.event;

import org.scijava.event.SciJavaEvent;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public abstract class PsfjEvent<T> extends SciJavaEvent {
      
    
    private final T data;

    public PsfjEvent(T data) {
        this.data = data;
    }
    
    
    
    public T getData() {
        return data;
    }
    
}
