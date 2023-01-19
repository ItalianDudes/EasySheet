package it.italiandudes.easy_sheet.common.sheet.generic;

import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@SuppressWarnings("unused")
public final class Spell {

    //Attributes
    @NotNull private String name;
    private int level;
    @NotNull private String type;
    @NotNull private String description;
    @Nullable private Image image;

    //Constructors
    public Spell(@NotNull String name, int level, @NotNull String type, @Nullable String description, @Nullable Image image){
        this.name = name;
        this.level = level;
        this.type = type;
        if(description == null) description = "";
        this.description = description;
        this.image = image;
    }

    //Methods
    @NotNull
    public String getName() {
        return name;
    }
    public void setName(@NotNull String name) {
        this.name = name;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    @NotNull
    public String getType() {
        return type;
    }
    public void setType(@NotNull String type) {
        this.type = type;
    }
    @NotNull
    public String getDescription() {
        return description;
    }
    public void setDescription(@Nullable String description) {
        if(description == null) this.description = "";
        else this.description = description;
    }
    @Nullable
    public Image getImage() {
        return image;
    }
    public void setImage(@Nullable Image image) {
        this.image = image;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spell spell = (Spell) o;

        if (getLevel() != spell.getLevel()) return false;
        if (!getName().equals(spell.getName())) return false;
        if (!getType().equals(spell.getType())) return false;
        if (!getDescription().equals(spell.getDescription())) return false;
        return getImage() != null ? getImage().equals(spell.getImage()) : spell.getImage() == null;
    }
    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getLevel();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Spell{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }
}
