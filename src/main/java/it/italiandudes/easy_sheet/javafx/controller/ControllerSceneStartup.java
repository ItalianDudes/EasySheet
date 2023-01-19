package it.italiandudes.easy_sheet.javafx.controller;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;

@SuppressWarnings("unused")
public final class ControllerSceneStartup {

    //Attributes

    //Graphic Elements
    @FXML private BorderPane mainPane;
    @FXML private TextField pathSheetTextField;
    @FXML private Button fileChooserButton;
    @FXML private Button openSheetButton;
    @FXML private Button createSheetButton;

    //Initialize
    @FXML
    private void initialize(){
        EasySheet.getStage().setResizable(false);
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
            String path = event.getDragboard().getFiles().get(0).getAbsolutePath();
            File fp = new File(path);
            if(fp.exists() && fp.isFile()){
                openSheetButton.setDisable(false);
                createSheetButton.setDisable(true);
            }else{
                openSheetButton.setDisable(true);
                createSheetButton.setDisable(false);
            }
            pathSheetTextField.setText(path);
            event.setDropCompleted(true);
        }else{
            event.setDropCompleted(false);
        }
    }
    @FXML
    private void openSheetFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleziona la Scheda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("D&D Sheet", "*."+JFXDefs.AppInfo.SHEET_FILE_EXTENSION));
        fileChooser.setInitialDirectory(EasySheet.Defs.JAR_EXECUTABLE_PATH);
        File fileSheet = fileChooser.showOpenDialog(fileChooserButton.getScene().getWindow());
        if(fileSheet!=null) {
            if(fileSheet.exists() && fileSheet.isFile()){
                openSheetButton.setDisable(false);
                createSheetButton.setDisable(true);
            }else{
                openSheetButton.setDisable(true);
                createSheetButton.setDisable(false);
            }
            pathSheetTextField.setText(fileSheet.getAbsolutePath());
        }
    }
    @FXML
    private void openSheet(){
        //TODO: openSheet()
    }
    @FXML
    private void createSheet(){
        //TODO: createSheet()
    }

}
