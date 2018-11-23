/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.actions;

import psfj.uifx.event.PsfjEvent;
import psfj.uifx.model.MultichannelImage;

/**
 *
 * @author cyrilmongis
 */
public class AddFileAsChannelToImageAction extends PsfjEvent<MultichannelImage> {
    
    public AddFileAsChannelToImageAction(MultichannelImage data) {
        super(data);
    }
    
}
