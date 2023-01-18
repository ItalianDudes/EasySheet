package it.italiandudes.easy_sheet.javafx.scene;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.idl.common.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("unused")
public final class SceneStartup {

    //Scene Generator
    public static Scene getScene(){
        try {
            Objects Objects;
            return new Scene(FXMLLoader.load(JFXDefs.Resource.get(JFXDefs.Resource.FXML.FXML_STARTUP)));
        }catch (IOException e){
            Logger.log(e);
            return null;
        }
    }

}
