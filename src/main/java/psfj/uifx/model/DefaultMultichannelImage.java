/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import knop.psfj.BeadImage;
import knop.psfj.resolution.Microscope;
import org.apache.log4j.Logger;

/**
 *
 * @author cyril
 */
public class DefaultMultichannelImage implements MultichannelImage {

    private List<BeadImage> images = new ArrayList<>();

    private Microscope main;

    private static final Logger logger = Logger.getLogger(MultichannelImage.class);

    private static final String EMPTY = "Empty";
    
    private static final String MULTIFILE = "Multiple files";
    
    public DefaultMultichannelImage(List<BeadImage> images) {
        
       this.images.addAll(images);
        
    }

    
    
    private void checkMainMicroscope() {

    }

    @Override
    public Microscope getMicroscope(int channel) {

        if (images.size() > channel) {

            return images.get(channel).getMicroscope();

        } else {
            return null;
        }

    }

    @Override
    public MultichannelImage setMicroscope(int channel, Microscope m) {
        if (hasChannel(channel)) {
            images.get(channel).setMicroscope(m);
        } else {
            logger.warn(
                    new StringBuilder()
                            .append("Could not set the microscope")
                            .append(m.toString())
                            .append(" to bead image ")
                            .append(channel)
                            .append(": channel does not exists")
                            .toString()
            );

        }
        return this;
    }

    @Override
    public MultichannelImage setBaseMicroscope(Microscope m) {
        this.main = m;

        images.forEach(image -> {

            if (image.getMicroscope() == null) {
                image.setMicroscope(m.copyWithWavelength(image.getMicroscope().getWaveLength()));
            }

        });

        return this;
    }

    @Override
    public MultichannelImage setWavelenth(int channel, double wavelength) {

        if (getMicroscope(channel) != null) {
            getMicroscope(channel).setWaveLength(wavelength);
        } else {
            setMicroscope(channel, main.copyWithWavelength(wavelength));
        }
        return this;
    }

    @Override
    public MultichannelImage addImage(BeadImage image) {
        images.add(image);

        if (main == null) {
            main = image.getMicroscope();
        }
        return this;

    }

    @Override
    public boolean hasChannel(int channel) {
        return channel < images.size();
    }

    @Override
    public boolean hasMicroscope(int channel) {

        if (hasChannel(channel)) {
            return images.get(channel).getMicroscope() != null;
        } else {
            return false;
        }

    }

    @Override
    public boolean isReady() {

        return images
                .stream()
                .filter(img -> img.getMicroscope() != null)
                .count() == images.size();

    }
    
     @Override
    public String getName() {

        if (images.size() == 0) {
            return EMPTY;
        } else {

            final String firstImageName = images.get(0).getFileAddress();

            if (firstImageName == null) {
                return "No Name for the FIRST ???";
            }
            final int imagesWithSameAddress = images
                    .stream()
                    .mapToInt(img -> firstImageName.equals(img.getFileAddress()) ? 1 : 0)
                    .sum();
            if (imagesWithSameAddress == images.size()) {
                return new File(firstImageName).getName();
            } else {
                return MULTIFILE;
            }
        }
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    
    public int hashCode() {
        return getName().hashCode() + images.stream().mapToInt(image->image.hashCode()).sum();
    }

    @Override
    public List<BeadImage> getImages() {
        return new ArrayList(images);
    }
    
    
    
}
