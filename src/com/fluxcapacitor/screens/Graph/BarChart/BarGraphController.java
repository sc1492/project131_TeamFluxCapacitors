package com.fluxcapacitor.screens.Graph.BarChart;

import com.fluxcapacitor.core.util.Inject.InformationGraph;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
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
public class BarGraphController extends AbstractMenuController {

    @Inject
    InformationGraph datas;

    @FXML
    private BarChart chart;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private CategoryAxis yAxis;

    final static String itemA = "Clay Pit";
    final static String itemB = "Hungry Valley";
    final static String itemC = "OCeano Dunes";

    @FXML
    @BackAction
    private Button back;

    @PostConstruct
    public void init() {
        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        chart.setTitle("Summary");
        xAxis.setLabel("Attendence");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Parks");

        Random random = new Random();

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2011");
        series1.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemA));
        series1.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemB));
        series1.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemC));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2010");
        series2.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemA));
        series2.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemB));
        series2.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemC));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2015");
        series3.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemA));
        series3.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemB));
        series3.getData().add(new XYChart.Data(random.nextInt(5000)+1000, itemC));

        chart.getData().addAll(series1, series2, series3);
    }
}
