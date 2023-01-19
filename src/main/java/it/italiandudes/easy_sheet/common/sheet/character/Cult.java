package it.italiandudes.easy_sheet.common.sheet.character;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;

@SuppressWarnings("unused")
public final class Cult {

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
    public Cult(@NotNull Document dndSheet){
        //TODO: read xml sheet
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
