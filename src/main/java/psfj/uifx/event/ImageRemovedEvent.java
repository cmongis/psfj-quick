/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.event;

import psfj.uifx.model.MultichannelImage;


/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class ImageRemovedEvent extends PsfjEvent<MultichannelImage>{
    
    final private boolean purgeBeadImages;
    
     public ImageRemovedEvent(MultichannelImage data, boolean purgeBeadImages) {
        super(data);
        this.purgeBeadImages = purgeBeadImages;
    }
    
    public ImageRemovedEvent(MultichannelImage data) {
        this(data,true);
    }

    public boolean doPurgeBeadImages() {
        return purgeBeadImages;
    }

   

    
    
}
