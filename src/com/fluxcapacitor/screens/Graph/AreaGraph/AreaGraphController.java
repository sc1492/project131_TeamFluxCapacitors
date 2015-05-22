package com.fluxcapacitor.screens.Graph.AreaGraph;

import com.fluxcapacitor.core.util.Inject.InformationConstants;
import com.fluxcapacitor.core.util.Inject.InformationGraph;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.BackAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Eddie on 5/17/2015.
 */
@FXMLController("fxml.fxml")
public class AreaGraphController extends AbstractMenuController{
    @Inject
    InformationGraph datas;

    @Inject
    private InformationConstants constants;

    @FXML
    private StackedAreaChart chart;

    @FXML
    private NumberAxis xAxis, yAxis;

    @FXML
    @BackAction
    private javafx.scene.control.Button back;

    @PostConstruct
    public void init(){
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(31);
        xAxis.setTickUnit(1);

        chart.setTitle("Park Attendence");
        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");

        ArrayList<XYChart.Series> series = new ArrayList<>();
        Random random = new Random();

        for(int i =0;i<datas.getAmount();i++){
            series.add(new XYChart.Series());
            series.get(i).setName(constants.getParkName()[i+1]);
            for(int j = 0;j<30;j=j+4){
                series.get(i).getData().add(new XYChart.Data(j, random.nextInt(500)));
            }
            chart.getData().add(series.get(i));
        }

    }
}
