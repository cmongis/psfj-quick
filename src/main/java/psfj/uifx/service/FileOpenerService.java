/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.service;

import java.io.File;
import java.util.List;
import mongis.utils.task.ProgressHandler;
import org.scijava.service.SciJavaService;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public interface FileOpenerService extends SciJavaService{
    
    
    public void open(File file);
    
    public  List<MultichannelImageGroup> openFile(ProgressHandler handler, File file);

    public MultichannelImage  openSingleImage(ProgressHandler handler, File file);
    
    public File promptFileOpen();
    
}
