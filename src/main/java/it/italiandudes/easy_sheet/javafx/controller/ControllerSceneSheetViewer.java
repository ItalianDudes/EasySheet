package it.italiandudes.easy_sheet.javafx.controller;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.easy_sheet.javafx.scene.sheet_section.SceneCharacterSection;
import it.italiandudes.idl.common.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public final class ControllerSceneSheetViewer {

    //Attributes
    private FXMLLoader currentSection;

    //FXML Elements
    @FXML private AnchorPane mainPane;
    @FXML private AnchorPane sectionPane;
    @FXML private Label characterLabel;
    @FXML private Label inventoryLabel;
    @FXML private Label spellLabel;


    //Initialize
    @FXML
    private void initialize() {
        EasySheet.getStage().setResizable(false);
        currentSection = new FXMLLoader(JFXDefs.Resource.get(JFXDefs.Resource.FXML.SheetSection.FXML_SHEET_CHARACTER));
        try {
            sectionPane.getChildren().add(currentSection.load());
        }catch (IOException e){
            Logger.log(e);
        }
    }

    //EDT

}
