/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.event;

import java.io.File;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class OpenFileAction extends PsfjEvent<File>
{
    
    public OpenFileAction(File data) {
        super(data);
    }
        
}
