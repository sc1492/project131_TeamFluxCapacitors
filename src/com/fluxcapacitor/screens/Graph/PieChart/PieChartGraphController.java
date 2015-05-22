package com.fluxcapacitor.screens.Graph.PieChart;

import com.fluxcapacitor.core.util.Inject.InformationGraph;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.BackAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Random;

/**
 * Created by Eddie on 5/17/2015.
 */
@FXMLController("fxml.fxml")
public class PieChartGraphController extends AbstractMenuController {
    @Inject
    InformationGraph datas;
    @FXML
    private PieChart pie;
    @FXML
    @BackAction
    private Button back;
    @PostConstruct
    public void init(){
        pie.setData(getChartData(56));

        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
    }

    private ObservableList<PieChart.Data> getChartData(int data) {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Clay Pit", data),
                        new PieChart.Data("Hungry Valley", data),
                        new PieChart.Data("Oceano Dunes", data),
                        new PieChart.Data("Ocotillo Wells", data),
                        new PieChart.Data("Herber Dunes", data));
        return pieChartData;

    }

}
