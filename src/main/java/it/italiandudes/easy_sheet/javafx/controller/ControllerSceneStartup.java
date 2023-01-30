package it.italiandudes.easy_sheet.javafx.controller;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.common.Sheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.easy_sheet.javafx.alert.ErrorAlert;
import it.italiandudes.easy_sheet.javafx.scene.SceneLoading;
import it.italiandudes.easy_sheet.javafx.scene.SceneSheetViewer;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
        Scene currentScene = EasySheet.getStage().getScene();
        EasySheet.getStage().setScene(SceneLoading.getScene());
        Service<Void> openSheetService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() {
                        File sheetFileController = new File(pathSheetTextField.getText());
                        if(!sheetFileController.exists() || !sheetFileController.isFile()){
                            Platform.runLater(() -> {
                                new ErrorAlert("ERRORE", "Errore durante la lettura della scheda", "Il percorso inserito non porta a nessuna scheda compatibile.");
                                EasySheet.getStage().setScene(currentScene);
                            });
                            return null;
                        }

                        Sheet sheet;
                        try{
                            sheet = new Sheet(pathSheetTextField.getText());
                        }catch (Exception e){
                            Platform.runLater(() -> {
                                new ErrorAlert("ERRORE", "Errore durante la lettura della scheda", e.getMessage());
                                EasySheet.getStage().setScene(currentScene);
                            });
                            return null;
                        }

                        EasySheet.setSheet(sheet);

                        Platform.runLater(() -> EasySheet.getStage().setScene(SceneSheetViewer.getScene()));

                        return null;
                    }
                };
            }
        };
        openSheetService.start();
    }
    @FXML
    private void createSheet(){
        Scene currentScene = EasySheet.getStage().getScene();
        EasySheet.getStage().setScene(SceneLoading.getScene());
        Service<Void> createSheetService = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() {
                        EasySheet.setSheet(new Sheet());
                        Platform.runLater(() -> EasySheet.getStage().setScene(SceneSheetViewer.getScene()));
                        return null;
                    }
                };
            }
        };
        createSheetService.start();
    }

}
