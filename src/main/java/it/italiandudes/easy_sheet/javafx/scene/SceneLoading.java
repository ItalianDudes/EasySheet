package it.italiandudes.easy_sheet.javafx.scene;

import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.idl.common.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

@SuppressWarnings("unused")
public final class SceneLoading {

    //Scene Generator
    public static Scene getScene(){
        try {
            return new Scene(FXMLLoader.load(JFXDefs.Resource.get(JFXDefs.Resource.FXML.FXML_LOADING)));
        }catch (IOException e){
            if(Logger.isInitialized()){
                Logger.log(e);
            }else{
                e.printStackTrace();
            }
            return null;
        }
    }
}
