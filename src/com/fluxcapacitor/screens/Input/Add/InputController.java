package com.fluxcapacitor.screens.Input.Add;

import com.fluxcapacitor.core.util.Inject.InformationInput;
import com.fluxcapacitor.screens.Input.MainMenu.InputMainMenuController;
import com.fluxcapacitor.screens.MenuBar.AbstractMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import org.datafx.controller.FXMLController;
import org.datafx.controller.flow.action.ActionTrigger;
import org.datafx.controller.flow.action.BackAction;
import org.datafx.controller.flow.action.LinkAction;
import org.datafx.controller.flow.context.ActionHandler;
import org.datafx.controller.flow.context.FlowActionHandler;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Eddie on 5/17/2015.
 */
@FXMLController("InputFXML.fxml")
public class InputController extends AbstractMenuController{
    @Inject
    private InformationInput data;

    @FXML
    @BackAction
    private Button backBtn;

    @FXML
    @LinkAction(InputMainMenuController.class)
    private Button saveBtn;


    @FXML
    private Text headerText;
    @PostConstruct
    public void init(){
        System.out.println(data.getSelectedPark());
        String header = "Input Data for "+data.getSelectedPark()+" on "+data.getSelectedMonth()+" "+data.getSelectedDay()+", "+data.getSelectedYear()+"("+data.getSelectedPark()+")";
        headerText.setText(header);

        DatePicker datePicker = new DatePicker();

        getViewBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getCreateBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getInputBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getParkBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");
        getUserBtn().getStylesheets().add("/com/fluxcapacitor/screens/MenuBar/MainMenuCSS.css");


    }
}
