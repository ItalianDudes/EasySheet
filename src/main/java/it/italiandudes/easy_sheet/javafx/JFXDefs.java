package it.italiandudes.easy_sheet.javafx;

import it.italiandudes.easy_sheet.EasySheet;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.util.Objects;

@SuppressWarnings("unused")
public final class JFXDefs {

    //App Info
    public static final class AppInfo {
        public static final String NAME = "Easy Sheet";
        public static final String SHEET_FILE_EXTENSION = "dndx";
        public static final Image LOGO = new Image(JFXDefs.Resource.get(JFXDefs.Resource.Image.IMAGE_LOGO).toString());
    }

    //CSS Functions
    public static final class CSS {}

    //Resource Locations
    public static final class Resource {

        //Resource Getter
        public static URL get(@NotNull final String resourceConst){
            return Objects.requireNonNull(EasySheet.class.getResource(resourceConst));
        }

        //FXML Location
        public static final class FXML {
            private static final String FXML_DIR = "/fxml/";
            public static final String FXML_STARTUP = FXML_DIR + "SceneStartup.fxml";
            public static final String FXML_LOADING = FXML_DIR+"SceneLoading.fxml";
            public static final String FXML_SHEET_VIEW = FXML_DIR+"SceneSheetViewer.fxml";
            public static final class SheetSection {
                private static final String SECTION_DIR = FXML_DIR+"sheet_section/";
                public static final String FXML_SHEET_CHARACTER = SECTION_DIR+"SceneSheetCharacterSection.fxml";
            }
        }

        //XML Scheme Locations
        public static final class XMLSchema {
            private static final String XML_SCHEMA_DIR = "/schema/";
            public static final String XML_SCHEMA_SHEET = XML_SCHEMA_DIR+"scheme_sheet.xsd";
        }

        //GIF Location
        public static final class GIF {
            private static final String GIF_DIR = "/gif/";
            public static final String GIF_LOADING = GIF_DIR+"loading.gif";
        }

        //Image Location
        public static final class Image {
            private static final String IMAGE_DIR = "/image/";
            public static final String IMAGE_LOGO = IMAGE_DIR+"app-logo.png";
            public static final String IMAGE_FILE_EXPLORER = IMAGE_DIR+"file-explorer.png";
        }

    }

}
