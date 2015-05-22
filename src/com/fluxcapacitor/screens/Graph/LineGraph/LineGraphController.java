package com.fluxcapacitor.screens.Graph.LineGraph;

import com.fluxcapacitor.core.util.Inject.InformationConstants;
import com.fluxcapacitor.core.util.Inject.InformationGraph;
import com.fluxcapacitor.core.util.Inject.InformationView;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
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
public class LineGraphController extends AbstractMenuController {

    @Inject
    InformationGraph datas;

    @Inject
    private InformationConstants constants;

    @FXML
    private LineChart graph;

    @FXML
    private NumberAxis x;

    @FXML
    @BackAction
    private Button back;

    @PostConstruct
    public void init() {
        Random random = new Random();
        ArrayList<XYChart.Series> seriesList = new ArrayList<>();
        for (int i =0;i<datas.getAmount();i++){
            seriesList.add(new XYChart.Series());
            seriesList.get(i).setName(constants.getParkName()[i+1]);
            for(int j = 0;j<30;j=j+4){
                seriesList.get(i).getData().add(new XYChart.Data(j, random.nextInt(500)));
            }

            graph.getData().add(seriesList.get(i));
        }


//        graph.getData().add(series);

        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
    }
}
