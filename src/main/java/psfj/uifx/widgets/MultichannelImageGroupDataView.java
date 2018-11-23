/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psfj.uifx.widgets;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import mongis.utils.task.ProgressHandler;
import psfj.uifx.dataview.AbstractFXMLDataView;
import psfj.uifx.dataview.DataPaneController;
import psfj.uifx.dataview.DefaultDataPaneController;
import psfj.uifx.model.MultichannelImage;
import psfj.uifx.model.MultichannelImageGroup;

/**
 *
 * @author Cyril MONGIS [http://www.cyrilmongis.net]
 */
public class MultichannelImageGroupDataView extends AbstractFXMLDataView<MultichannelImageGroup>  {

    
    
    
    @FXML
    Label label;
    
    @FXML
    VBox dataList;
    
    final DataPaneController<MultichannelImage> dataPaneCtrl;
    
    public MultichannelImageGroupDataView() throws IOException {
      init("/fxml/widgets/MultichannelImageGroupDataView.fxml");
       
        
     dataPaneCtrl  = new DefaultDataPaneController<MultichannelImage>()
             .setPane(dataList)
             .setDataViewFactory(()->new MultichannelImageDataView());
             
             
        
    }

    @Override
    public void update() {
        dataPaneCtrl.setData(getItem().getImageList());
        
        dataPaneCtrl.update(ProgressHandler.NONE);
    }
    
    
   
    
}
