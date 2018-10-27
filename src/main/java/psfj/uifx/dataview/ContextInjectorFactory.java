/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.dataview;

import org.scijava.Context;
import org.scijava.plugin.Parameter;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */


public class ContextInjectorFactory<T extends DataView<R>,R> implements DataViewFactory<R>{
    
    @Parameter
    Context context;
    
    final Class<T> type;

    public ContextInjectorFactory(Class<T> type) {
        this.type = type;
    }

    public ContextInjectorFactory(Context context, Class<T> type) {
        this.context = context;
        this.type = type;
    }
    

    @Override
    public DataView<R> create() throws Exception {
        
        T t = type.newInstance();
        
        context.inject(t);
        
        return t;
        
    }
    
    
}
