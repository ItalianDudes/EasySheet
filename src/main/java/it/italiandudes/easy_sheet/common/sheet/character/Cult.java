package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import it.italiandudes.easy_sheet.common.util.ImageFX64;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class Cult implements SheetComponent {

    //Attributes
    @NotNull private String cultName;
    @NotNull private String cultDescription;
    @Nullable private Image cultImage;

    //Constructors
    public Cult(@Nullable String cultName, @Nullable String cultDescription, @Nullable Image cultImage){
        if(cultName == null) this.cultName = "";
        else this.cultName = cultName;
        if(cultDescription == null) this.cultDescription = "";
        else this.cultDescription = cultDescription;
        this.cultImage = cultImage;
    }
    public Cult(){
        this.cultName = "";
        this.cultDescription = "";
        this.cultImage = null;
    }
    public Cult(@NotNull Element dndSheet) throws RuntimeException {
        if(dndSheet.getElementsByTagName(Character.Cult.NAME).getLength() > 0){
            cultName = dndSheet.getElementsByTagName(Character.Cult.NAME).item(0).getTextContent();
        }else{
            cultName = "";
        }
        if(dndSheet.getElementsByTagName(Character.Cult.DESCRIPTION).getLength() > 0){
            cultDescription = dndSheet.getElementsByTagName(Character.Cult.DESCRIPTION).item(0).getTextContent();
        }else{
            cultDescription = "";
        }
        if(dndSheet.getElementsByTagName(Character.Cult.IMAGE).getLength()>0){
            cultImage = ImageFX64.base64ToImage(dndSheet.getElementsByTagName(Character.Cult.IMAGE).item(0).getTextContent());
        }else{
            cultImage = null;
        }
    }

    //Methods
    @NotNull
    public String getCultName() {
        return cultName;
    }
    public void setCultName(@Nullable String cultName) {
        if(cultName == null) this.cultName = "";
        else this.cultName = cultName;
    }
    @NotNull
    public String getCultDescription() {
        return cultDescription;
    }
    public void setCultDescription(@Nullable String cultDescription) {
        if(cultDescription == null) this.cultDescription = "";
        else this.cultDescription = cultDescription;
    }
    @Nullable
    public Image getCultImage() {
        return cultImage;
    }
    public void setCultImage(@Nullable Image cultImage) {
        this.cultImage = cultImage;
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element cultElement = dndSheet.createElement(Character.Cult.CULT);
        Element nameElement = dndSheet.createElement(Character.Cult.NAME);
        nameElement.setTextContent(cultName);
        cultElement.appendChild(nameElement);
        Element descriptionElement = dndSheet.createElement(Character.Cult.DESCRIPTION);
        descriptionElement.setTextContent(cultDescription);
        cultElement.appendChild(descriptionElement);
        if (cultImage != null) {
            Element imageElement = dndSheet.createElement(Character.Cult.IMAGE);
            imageElement.setTextContent(ImageFX64.imageToBase64(cultImage));
            cultElement.appendChild(imageElement);
        }
        parent.appendChild(cultElement);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cult cult = (Cult) o;

        if (!getCultName().equals(cult.getCultName())) return false;
        if (!getCultDescription().equals(cult.getCultDescription())) return false;
        return getCultImage() != null ? getCultImage().equals(cult.getCultImage()) : cult.getCultImage() == null;
    }
    @Override
    public int hashCode() {
        int result = getCultName().hashCode();
        result = 31 * result + getCultDescription().hashCode();
        result = 31 * result + (getCultImage() != null ? getCultImage().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Cult{" +
                "cultName='" + cultName + '\'' +
                ", cultDescription='" + cultDescription + '\'' +
                ", cultImage=" + cultImage +
                '}';
    }
}
