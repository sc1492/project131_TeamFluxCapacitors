package com.fluxcapacitor.screens.Graph.ScatterGraph;

import com.fluxcapacitor.core.util.Inject.InformationGraph;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.BackAction;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Eddie on 5/17/2015.
 */
@FXMLController("fxml.fxml")
public class ScatterGraphController extends AbstractMenuController {
    @Inject
    private InformationGraph datas;

    @FXML
    private ScatterChart chart;

    @FXML
    @BackAction
    private Button back;

    @FXML
    private NumberAxis xAxis;

    @FXML
    private CategoryAxis yAxis;

    @PostConstruct
    public void init(){
        chart.setData(getChartData());
        chart.setTitle("4x4 Frequency");
        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
    }

    private ObservableList<XYChart.Series<String, Double>> getChartData() {
        double aValue = 1.56;
        double cValue = 1.06;
        ObservableList<XYChart.Series<String, Double>> answer = FXCollections.observableArrayList();
        XYChart.Series<String, Double> aSeries = new XYChart.Series<String, Double>();
        XYChart.Series<String, Double> cSeries = new XYChart.Series<String, Double>();
        aSeries.setName("Hurber Dunes");
        cSeries.setName("Clay Pit");

        for (int i = 2011; i < 2021; i++) {
            aSeries.getData().add(new XYChart.Data(Integer.toString(i), aValue));
            aValue = aValue + Math.random() - .5;
            cSeries.getData().add(new XYChart.Data(Integer.toString(i), cValue));
            cValue = cValue + Math.random() - .5;
        }
        answer.addAll(aSeries, cSeries);
        return answer;

    }
}
