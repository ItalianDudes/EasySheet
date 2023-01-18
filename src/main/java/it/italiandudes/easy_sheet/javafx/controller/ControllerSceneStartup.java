package it.italiandudes.easy_sheet.javafx.controller;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;

import java.io.File;

public final class ControllerSceneStartup {

    //Attributes

    //Graphic Elements
    @FXML private TextField pathSheetTextField;
    @FXML private Button fileChooserButton;

    //Initialize
    @FXML
    private void initialize(){
        ImageView fileChooserView = new ImageView(JFXDefs.Resource.get(JFXDefs.Resource.Image.IMAGE_FILE_EXPLORER).toString());
        fileChooserView.setFitWidth(fileChooserButton.getPrefWidth());
        fileChooserView.setFitHeight(fileChooserButton.getHeight());
        fileChooserView.setPreserveRatio(true);
        fileChooserButton.setGraphic(fileChooserView);
    }

    //EDT
    @FXML
    private void handleOnDragOver(DragEvent event){
        if(event.getDragboard().hasFiles()){
            event.acceptTransferModes(TransferMode.COPY);
        }
    }
    @FXML
    private void handleOnDragDropped(DragEvent event){
        if(event.getDragboard().hasFiles()){
            pathSheetTextField.setText(event.getDragboard().getFiles().get(0).getAbsolutePath());
            event.setDropCompleted(true);
        }else{
            event.setDropCompleted(false);
        }
    }
    @FXML
    private void openSheetFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona la Scheda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("D&D Sheet", "*.dndx"));
        fileChooser.setInitialDirectory(EasySheet.Defs.JAR_EXECUTABLE_PATH);
        File fileDB = fileChooser.showOpenDialog(fileChooserButton.getScene().getWindow());
        if(fileDB!=null)
            pathSheetTextField.setText(fileDB.getAbsolutePath());
    }

}
