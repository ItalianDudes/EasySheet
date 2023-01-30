package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.common.sheet.character.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Character implements SheetComponent {

    //Attributes
    @NotNull private final CharacterHeader characterHeader;
    @NotNull private final CharacterDescription characterDescription;
    @NotNull private final Stats stats;
    @NotNull private final Vitality vitality;
    @NotNull private String story;
    @NotNull private final ArrayList<String> otherProficienciesAndLanguages;
    @NotNull private final ArrayList<String> alliesAndOrganizations;
    @NotNull private final Cult cult;

    //Constructors
    public Character(@NotNull CharacterHeader characterHeader, @NotNull CharacterDescription characterDescription,
                     @NotNull Stats stats, @NotNull ArrayList<String> otherProficienciesAndLanguages, @NotNull Vitality vitality, @Nullable String story,
                     @NotNull ArrayList<String> alliesAndOrganizations, @NotNull Cult cult) {
        this.characterHeader = characterHeader;
        this.characterDescription = characterDescription;
        this.stats = stats;
        this.otherProficienciesAndLanguages = otherProficienciesAndLanguages;
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
                new ArrayList<>(),
                new Vitality(),
                null,
                new ArrayList<>(),
                new Cult());
    }
    public Character(@NotNull Element dndSheet) throws RuntimeException {
        characterHeader = new CharacterHeader(dndSheet);
        characterDescription = new CharacterDescription(dndSheet);
        stats = new Stats(dndSheet);
        otherProficienciesAndLanguages = new ArrayList<>();
        NodeList otherProficienciesAndLanguagesList = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.OtherProficienciesAndLanguages.OTHER_PROFICIENCY_OR_LANGUAGE);
        for(int i=0;i<otherProficienciesAndLanguagesList.getLength();i++){
            otherProficienciesAndLanguages.add(otherProficienciesAndLanguagesList.item(i).getTextContent());
        }
        vitality = new Vitality(dndSheet);
        story = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.STORY).item(0).getTextContent();
        alliesAndOrganizations = new ArrayList<>();
        NodeList alliesAndOrganizationList = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.AlliesAndOrganizations.ALLY_OR_ORGANIZATION);
        for(int i=0;i<alliesAndOrganizationList.getLength();i++){
            alliesAndOrganizations.add(alliesAndOrganizationList.item(i).getTextContent());
        }
        cult = new Cult(dndSheet);
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
    public ArrayList<String> getOtherProficienciesAndLanguages(){
        return otherProficienciesAndLanguages;
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
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element characterElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.CHARACTER);
        characterHeader.writeComponent(dndSheet, characterElement);
        characterDescription.writeComponent(dndSheet, characterElement);
        stats.writeComponent(dndSheet, characterElement);
        Element otherProficienciesAndLanguagesElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.OtherProficienciesAndLanguages.OTHER_PROFICIENCIES_AND_LANGUAGES);
        Element otherProficiencyOrLanguageElement;
        for(String otherProficiencyOrLanguage : otherProficienciesAndLanguages){
            otherProficiencyOrLanguageElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.OtherProficienciesAndLanguages.OTHER_PROFICIENCY_OR_LANGUAGE);
            otherProficiencyOrLanguageElement.setTextContent(otherProficiencyOrLanguage);
            otherProficienciesAndLanguagesElement.appendChild(otherProficiencyOrLanguageElement);
        }
        characterElement.appendChild(otherProficienciesAndLanguagesElement);
        vitality.writeComponent(dndSheet, characterElement);
        Element storyElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.STORY);
        storyElement.setTextContent(story);
        characterElement.appendChild(storyElement);
        Element alliesAndOrganizationsElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.AlliesAndOrganizations.ALLIES_AND_ORGANIZATIONS);
        Element allyOrOrganizationElement;
        for(String allyOrOrganization : alliesAndOrganizations){
            allyOrOrganizationElement = dndSheet.createElement(EasySheet.Defs.XMLElementNames.Character.AlliesAndOrganizations.ALLY_OR_ORGANIZATION);
            allyOrOrganizationElement.setTextContent(allyOrOrganization);
            alliesAndOrganizationsElement.appendChild(allyOrOrganizationElement);
        }
        characterElement.appendChild(alliesAndOrganizationsElement);
        cult.writeComponent(dndSheet, characterElement);
        parent.appendChild(characterElement);
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
        if (!getOtherProficienciesAndLanguages().equals(character.getOtherProficienciesAndLanguages())) return false;
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
        result = 31 * result + getOtherProficienciesAndLanguages().hashCode();
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
                ", otherProficienciesAndLanguages=" + otherProficienciesAndLanguages +
                ", alliesAndOrganizations=" + alliesAndOrganizations +
                ", cult=" + cult +
                '}';
    }
}
