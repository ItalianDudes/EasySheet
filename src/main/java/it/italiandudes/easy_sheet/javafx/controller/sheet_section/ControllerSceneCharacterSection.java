package it.italiandudes.easy_sheet.javafx.controller.sheet_section;

import it.italiandudes.easy_sheet.EasySheet;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public final class ControllerSceneCharacterSection {

    //Attributes

    //FXML Elements
    @FXML
    private AnchorPane mainPane;

    //Initialize
    @FXML
    private void initialize() {
        EasySheet.getStage().setResizable(false);
    }

}
