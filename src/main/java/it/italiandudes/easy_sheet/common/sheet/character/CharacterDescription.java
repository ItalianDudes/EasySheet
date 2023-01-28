package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.EasySheet;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;

@SuppressWarnings("unused")
public final class CharacterDescription {

    //Attributes
    @NotNull private ArrayList<String> personality;
    @NotNull private ArrayList<String> flaws;
    @NotNull private ArrayList<String> ideals;
    @NotNull private ArrayList<String> bonds;
    @NotNull private ArrayList<String> privilegesAndTraits;
    @NotNull private String age;
    @NotNull private String height;
    @NotNull private String weight;
    @NotNull private String eyes;
    @NotNull private String skin;
    @NotNull private String hair;
    @Nullable private Image characterImage;

    //Constructors
    public CharacterDescription(){
        personality = new ArrayList<>();
        flaws = new ArrayList<>();
        ideals = new ArrayList<>();
        bonds = new ArrayList<>();
        privilegesAndTraits = new ArrayList<>();
        age = "";
        height = "";
        weight = "";
        eyes = "";
        skin = "";
        hair = "";
        characterImage = null;
    }
    public CharacterDescription(@NotNull Element dndSheet){
        personality = new ArrayList<>();
        Element personalityElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Personality.PERSONALITY).item(0);
        NodeList personalityTraits = personalityElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Personality.TRAIT);
        for(int i=0;i<personalityTraits.getLength();i++){
            personality.add(personalityTraits.item(i).getTextContent());
        }
        flaws = new ArrayList<>();
        Element flawsElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Flaws.FLAWS).item(0);
        NodeList flawTraits = flawsElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Flaws.FLAW);
        for(int i=0;i<flawTraits.getLength();i++){
            flaws.add(flawTraits.item(0).getTextContent());
        }
        ideals = new ArrayList<>();
        Element idealsElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Ideals.IDEALS).item(0);
        NodeList idealTraits = idealsElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Ideals.IDEAL);
        for(int i=0;i<idealTraits.getLength();i++){
            ideals.add(idealTraits.item(i).getTextContent());
        }
        bonds = new ArrayList<>();
        Element bondsElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Bonds.BONDS).item(0);
        NodeList bondTraits = bondsElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.Bonds.BOND);
        for(int i=0;i<bondTraits.getLength();i++){
            bonds.add(bondTraits.item(i).getTextContent());
        }
        privilegesAndTraits = new ArrayList<>();
        Element privilegesAndTraitsElement = (Element) dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGES_AND_TRAITS).item(0);
        NodeList privilegesAndTraitsList = privilegesAndTraitsElement.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGE_OR_TRAIT);
        for(int i=0;i<privilegesAndTraitsList.getLength();i++){
            privilegesAndTraits.add(privilegesAndTraitsList.item(i).getTextContent());
        }
        age = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.AGE).item(0).getTextContent();
        height = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.HEIGHT).item(0).getTextContent();
        weight = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.WEIGHT).item(0).getTextContent();
        eyes = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.EYES).item(0).getTextContent();
        skin = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.SKIN).item(0).getTextContent();
        hair = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.HAIR).item(0).getTextContent();
        age = dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.AGE).item(0).getTextContent();
        if(dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.CHARACTER_IMAGE).getLength()>0){
            characterImage = new Image(new ByteArrayInputStream(Base64.getDecoder().decode(
                    dndSheet.getElementsByTagName(EasySheet.Defs.XMLElementNames.Character.CharacterDescription.CHARACTER_IMAGE).item(0).getTextContent()
            )));
        }else{
            characterImage = null;
        }
    }

    //Methods
    @NotNull
    public ArrayList<String> getPersonality() {
        return personality;
    }
    public void setPersonality(@Nullable ArrayList<String> personality) {
        if(personality == null) this.personality = new ArrayList<>();
        else this.personality = personality;
    }
    @NotNull
    public ArrayList<String> getFlaws() {
        return flaws;
    }
    public void setFlaws(@Nullable ArrayList<String> flaws) {
        if(flaws == null) this.flaws = new ArrayList<>();
        else this.flaws = flaws;
    }
    @NotNull
    public ArrayList<String> getIdeals() {
        return ideals;
    }
    public void setIdeals(@Nullable ArrayList<String> ideals) {
        if (ideals == null) this.ideals = new ArrayList<>();
        else this.ideals = ideals;
    }
    @NotNull
    public ArrayList<String> getBonds() {
        return bonds;
    }
    public void setBonds(@Nullable ArrayList<String> bonds) {
        if(bonds == null) bonds = new ArrayList<>();
        this.bonds = bonds;
    }
    @NotNull
    public ArrayList<String> getPrivilegesAndTraits() {
        return privilegesAndTraits;
    }
    public void setPrivilegesAndTraits(@Nullable ArrayList<String> privilegesAndTraits) {
        if(privilegesAndTraits == null) this.privilegesAndTraits = new ArrayList<>();
        else this.privilegesAndTraits = privilegesAndTraits;
    }
    @NotNull
    public String getAge() {
        return age;
    }
    public void setAge(@Nullable String age) {
        if(age == null) this.age = "";
        else this.age = age;
    }
    @NotNull
    public String getHeight() {
        return height;
    }
    public void setHeight(@Nullable String height) {
        if(height == null) this.height = "";
        else this.height = height;
    }
    @NotNull
    public String getWeight() {
        return weight;
    }
    public void setWeight(@Nullable String weight) {
        if(weight == null) this.weight = "";
        else this.weight = weight;
    }
    @NotNull
    public String getEyes() {
        return eyes;
    }
    public void setEyes(@Nullable String eyes) {
        if(eyes == null) this.eyes = "";
        else this.eyes = eyes;
    }
    @NotNull
    public String getSkin() {
        return skin;
    }
    public void setSkin(@Nullable String skin) {
        if(skin == null) this.skin = "";
        else this.skin = skin;
    }
    @NotNull
    public String getHair() {
        return hair;
    }
    public void setHair(@Nullable String hair) {
        if(hair == null) this.hair = "";
        else this.hair = hair;
    }
    @Nullable
    public Image getCharacterImage() {
        return characterImage;
    }
    public void setCharacterImage(@Nullable Image characterImage) {
        this.characterImage = characterImage;
    }
}
