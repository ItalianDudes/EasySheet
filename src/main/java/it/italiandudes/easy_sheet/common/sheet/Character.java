package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.common.sheet.character.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Character {

    //Attributes
    @NotNull private final CharacterHeader characterHeader;
    @NotNull private final CharacterDescription characterDescription;
    @NotNull private final Stats stats;
    @NotNull private final Vitality vitality;
    @NotNull private String story;
    @NotNull private final ArrayList<String> alliesAndOrganizations;
    @NotNull private final Cult cult;

    //Constructors
    public Character(@NotNull CharacterHeader characterHeader, @NotNull CharacterDescription characterDescription,
                     @NotNull Stats stats, @NotNull Vitality vitality, @Nullable String story,
                     @NotNull ArrayList<String> alliesAndOrganizations, @NotNull Cult cult) {
        this.characterHeader = characterHeader;
        this.characterDescription = characterDescription;
        this.stats = stats;
        this.vitality = vitality;
        if(story == null) this.story = "";
        else this.story = story;
        this.alliesAndOrganizations = alliesAndOrganizations;
        this.cult = cult;
    }
    public Character(){
        this(new CharacterHeader(),
                new CharacterDescription(),
                new Stats(),
                new Vitality(),
                null,
                new ArrayList<>(),
                new Cult());
    }
    public Character(@NotNull Element dndSheet){
        characterHeader = null;
        characterDescription = null;
        stats = null;
        vitality = null;
        story = null;
        alliesAndOrganizations = null;
        cult = null;
        //TODO: read xml sheet
    }

    //Methods
    @NotNull
    public CharacterHeader getCharacterHeader() {
        return characterHeader;
    }
    @NotNull
    public CharacterDescription getCharacterDescription() {
        return characterDescription;
    }
    @NotNull
    public Stats getStats() {
        return stats;
    }
    @NotNull
    public Vitality getVitality() {
        return vitality;
    }
    @NotNull
    public String getStory() {
        return story;
    }
    public void setStory(@Nullable String story) {
        if(story == null) this.story = "";
        else this.story = story;
    }
    @NotNull
    public ArrayList<String> getAlliesAndOrganizations() {
        return alliesAndOrganizations;
    }
    @NotNull
    public Cult getCult() {
        return cult;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (!getCharacterHeader().equals(character.getCharacterHeader())) return false;
        if (!getCharacterDescription().equals(character.getCharacterDescription())) return false;
        if (!getStats().equals(character.getStats())) return false;
        if (!getVitality().equals(character.getVitality())) return false;
        if (!getStory().equals(character.getStory())) return false;
        if (!getAlliesAndOrganizations().equals(character.getAlliesAndOrganizations())) return false;
        return getCult().equals(character.getCult());
    }
    @Override
    public int hashCode() {
        int result = getCharacterHeader().hashCode();
        result = 31 * result + getCharacterDescription().hashCode();
        result = 31 * result + getStats().hashCode();
        result = 31 * result + getVitality().hashCode();
        result = 31 * result + getStory().hashCode();
        result = 31 * result + getAlliesAndOrganizations().hashCode();
        result = 31 * result + getCult().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Character{" +
                "characterHeader=" + characterHeader +
                ", characterDescription=" + characterDescription +
                ", stats=" + stats +
                ", vitality=" + vitality +
                ", story='" + story + '\'' +
                ", alliesAndOrganizations=" + alliesAndOrganizations +
                ", cult=" + cult +
                '}';
    }
}
