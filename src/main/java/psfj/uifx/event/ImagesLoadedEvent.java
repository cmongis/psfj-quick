/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.event;

import java.util.List;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class ImagesLoadedEvent extends PsfjEvent<List<MultichannelImageGroup>> {
    
    public ImagesLoadedEvent(List<MultichannelImageGroup> data) {
        super(data);
    }
    
}
