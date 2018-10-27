/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.model;

import com.google.common.collect.ImmutableList;
import java.util.List;
import knop.psfj.BeadImage;
import knop.psfj.resolution.Microscope;

/**
 *
 * @author cyril
 */
public interface MultichannelImage {
    
    
    Microscope getMicroscope(int channel);
    
    MultichannelImage addImage(BeadImage image);
    
    MultichannelImage setMicroscope(int channel, Microscope m);
    
    MultichannelImage setBaseMicroscope(Microscope m);
    
    MultichannelImage setWavelenth(int channel, double wavelength);
    
    boolean hasMicroscope(int channel);
    
    boolean hasChannel(int channel);
    
    boolean isReady();
    
    String getName();
    
    List<BeadImage> getImages();
    
    
    
}
