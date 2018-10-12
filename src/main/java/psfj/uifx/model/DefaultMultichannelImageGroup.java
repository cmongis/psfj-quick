/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cyril
 */
public class DefaultMultichannelImageGroup implements MultichannelImageGroup {
 
    
    List<MultichannelImage> fieldList = new ArrayList<>();

    public DefaultMultichannelImageGroup() {
    }
    
    public DefaultMultichannelImageGroup(List<MultichannelImage> images) {
        fieldList.addAll(images);
    }
    
    public DefaultMultichannelImageGroup(MultichannelImage image) {
        fieldList.add(image);
    }
    
    @Override
    public List<MultichannelImage> getImageList() {
       return fieldList;
    }
    
    
}
