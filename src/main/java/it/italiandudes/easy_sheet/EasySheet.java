package it.italiandudes.easy_sheet;

import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.easy_sheet.javafx.scene.SceneStartup;
import it.italiandudes.idl.common.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public final class EasySheet extends Application {

    //Attributes
    public static final DocumentBuilder XML_DOCUMENT_BUILDER;
    static {
        try {
            XML_DOCUMENT_BUILDER = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage stage = null;

    //Start Method
    @Override
    public void start(Stage stage) {
        EasySheet.stage = stage;
        stage.setTitle(JFXDefs.AppInfo.NAME);
        stage.getIcons().add(JFXDefs.AppInfo.LOGO);
        stage.setScene(SceneStartup.getScene());
        stage.show();
    }

    //Methods
    @NotNull
    public static Stage getStage(){
        return stage;
    }

    //Main Method
    public static void main(String[] args) {
        try {
            if (Logger.init()) {
                Runtime.getRuntime().addShutdownHook(new Thread(Logger::close));
            }
        }catch (IOException e){
            System.err.println("Logger can't be initialized. Exit...");
        }
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> Logger.log(e));
        launch(args);
    }

    //Defs
    public static final class Defs {
        //This Jar Executable Location
        public static final File JAR_EXECUTABLE_PATH = new File(EasySheet.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        public static final int MAJOR_ABILITIES_NUM = 6;
        public static final int MINOR_ABILITIES_NUM = 18;
    }

}
