/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.actions;

import psfj.uifx.event.AbstractTargetedEvent;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class AddImageToGroupAction extends AbstractTargetedEvent<MultichannelImageGroup,MultichannelImage>{
    
    public AddImageToGroupAction(MultichannelImageGroup target, MultichannelImage data) {
        super(target, data);
    }
    
}
