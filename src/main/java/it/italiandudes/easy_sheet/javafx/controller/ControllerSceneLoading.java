package it.italiandudes.easy_sheet.javafx.controller;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class ControllerSceneLoading {

    //Attributes
    private static final Image GIF_LOADING = new Image(JFXDefs.Resource.get(JFXDefs.Resource.GIF.GIF_LOADING).toString());

    //FXML Elements
    @FXML private ImageView loadingView;


    //Initialize
    @FXML
    private void initialize() {
        EasySheet.getStage().setResizable(false);
        loadingView.setImage(GIF_LOADING);
    }

}
