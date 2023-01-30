package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import it.italiandudes.easy_sheet.common.util.ImageFX64;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;

@SuppressWarnings("unused")
public final class CharacterDescription implements SheetComponent {

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
    public CharacterDescription(@NotNull Element dndSheet) throws RuntimeException {
        personality = new ArrayList<>();
        Element personalityElement = (Element) dndSheet.getElementsByTagName(Character.CharacterDescription.Personality.PERSONALITY).item(0);
        NodeList personalityTraits = personalityElement.getElementsByTagName(Character.CharacterDescription.Personality.TRAIT);
        for(int i=0;i<personalityTraits.getLength();i++){
            personality.add(personalityTraits.item(i).getTextContent());
        }
        flaws = new ArrayList<>();
        Element flawsElement = (Element) dndSheet.getElementsByTagName(Character.CharacterDescription.Flaws.FLAWS).item(0);
        NodeList flawTraits = flawsElement.getElementsByTagName(Character.CharacterDescription.Flaws.FLAW);
        for(int i=0;i<flawTraits.getLength();i++){
            flaws.add(flawTraits.item(0).getTextContent());
        }
        ideals = new ArrayList<>();
        Element idealsElement = (Element) dndSheet.getElementsByTagName(Character.CharacterDescription.Ideals.IDEALS).item(0);
        NodeList idealTraits = idealsElement.getElementsByTagName(Character.CharacterDescription.Ideals.IDEAL);
        for(int i=0;i<idealTraits.getLength();i++){
            ideals.add(idealTraits.item(i).getTextContent());
        }
        bonds = new ArrayList<>();
        Element bondsElement = (Element) dndSheet.getElementsByTagName(Character.CharacterDescription.Bonds.BONDS).item(0);
        NodeList bondTraits = bondsElement.getElementsByTagName(Character.CharacterDescription.Bonds.BOND);
        for(int i=0;i<bondTraits.getLength();i++){
            bonds.add(bondTraits.item(i).getTextContent());
        }
        privilegesAndTraits = new ArrayList<>();
        Element privilegesAndTraitsElement = (Element) dndSheet.getElementsByTagName(Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGES_AND_TRAITS).item(0);
        NodeList privilegesAndTraitsList = privilegesAndTraitsElement.getElementsByTagName(Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGE_OR_TRAIT);
        for(int i=0;i<privilegesAndTraitsList.getLength();i++){
            privilegesAndTraits.add(privilegesAndTraitsList.item(i).getTextContent());
        }
        age = dndSheet.getElementsByTagName(Character.CharacterDescription.AGE).item(0).getTextContent();
        height = dndSheet.getElementsByTagName(Character.CharacterDescription.HEIGHT).item(0).getTextContent();
        weight = dndSheet.getElementsByTagName(Character.CharacterDescription.WEIGHT).item(0).getTextContent();
        eyes = dndSheet.getElementsByTagName(Character.CharacterDescription.EYES).item(0).getTextContent();
        skin = dndSheet.getElementsByTagName(Character.CharacterDescription.SKIN).item(0).getTextContent();
        hair = dndSheet.getElementsByTagName(Character.CharacterDescription.HAIR).item(0).getTextContent();
        age = dndSheet.getElementsByTagName(Character.CharacterDescription.AGE).item(0).getTextContent();
        if(dndSheet.getElementsByTagName(Character.CharacterDescription.CHARACTER_IMAGE).getLength()>0){
            characterImage = new Image(new ByteArrayInputStream(Base64.getDecoder().decode(
                    dndSheet.getElementsByTagName(Character.CharacterDescription.CHARACTER_IMAGE).item(0).getTextContent()
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
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element characterDescriptionElement = dndSheet.createElement(Character.CharacterDescription.CHARACTER_DESCRIPTION);
        Element personalityElement = dndSheet.createElement(Character.CharacterDescription.Personality.PERSONALITY);
        Element traitElement;
        for(String trait : personality){
            traitElement = dndSheet.createElement(Character.CharacterDescription.Personality.TRAIT);
            traitElement.setTextContent(trait);
            personalityElement.appendChild(traitElement);
        }
        characterDescriptionElement.appendChild(personalityElement);
        Element flawsElement = dndSheet.createElement(Character.CharacterDescription.Flaws.FLAWS);
        Element flawElement;
        for(String flaw : flaws){
            flawElement = dndSheet.createElement(Character.CharacterDescription.Flaws.FLAW);
            flawElement.setTextContent(flaw);
            flawsElement.appendChild(flawElement);
        }
        characterDescriptionElement.appendChild(flawsElement);
        Element idealsElement = dndSheet.createElement(Character.CharacterDescription.Ideals.IDEALS);
        Element idealElement;
        for(String ideal : ideals){
            idealElement = dndSheet.createElement(Character.CharacterDescription.Ideals.IDEAL);
            idealElement.setTextContent(ideal);
            idealsElement.appendChild(idealElement);
        }
        characterDescriptionElement.appendChild(idealsElement);
        Element bondsElement = dndSheet.createElement(Character.CharacterDescription.Bonds.BONDS);
        Element bondElement;
        for(String bond : bonds){
            bondElement = dndSheet.createElement(Character.CharacterDescription.Bonds.BOND);
            bondElement.setTextContent(bond);
            bondsElement.appendChild(bondElement);
        }
        characterDescriptionElement.appendChild(bondsElement);
        Element privilegesAndTraitsElement = dndSheet.createElement(Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGES_AND_TRAITS);
        Element privilegeOrTraitElement;
        for(String privilegeOrTrait : privilegesAndTraits){
            privilegeOrTraitElement = dndSheet.createElement(Character.CharacterDescription.PrivilegesAndTraits.PRIVILEGE_OR_TRAIT);
            privilegeOrTraitElement.setTextContent(privilegeOrTrait);
            privilegesAndTraitsElement.appendChild(privilegeOrTraitElement);
        }
        characterDescriptionElement.appendChild(privilegesAndTraitsElement);
        Element ageElement = dndSheet.createElement(Character.CharacterDescription.AGE);
        ageElement.setTextContent(age);
        characterDescriptionElement.appendChild(ageElement);
        Element heightElement = dndSheet.createElement(Character.CharacterDescription.HEIGHT);
        heightElement.setTextContent(height);
        characterDescriptionElement.appendChild(heightElement);
        Element weightElement = dndSheet.createElement(Character.CharacterDescription.WEIGHT);
        weightElement.setTextContent(weight);
        characterDescriptionElement.appendChild(weightElement);
        Element eyesElement = dndSheet.createElement(Character.CharacterDescription.EYES);
        eyesElement.setTextContent(eyes);
        characterDescriptionElement.appendChild(eyesElement);
        Element skinElement = dndSheet.createElement(Character.CharacterDescription.SKIN);
        skinElement.setTextContent(skin);
        characterDescriptionElement.appendChild(skinElement);
        Element hairElement = dndSheet.createElement(Character.CharacterDescription.HAIR);
        hairElement.setTextContent(hair);
        characterDescriptionElement.appendChild(hairElement);
        if(characterImage!=null){
            Element characterImageElement = dndSheet.createElement(Character.CharacterDescription.CHARACTER_IMAGE);
            characterImageElement.setTextContent(ImageFX64.imageToBase64(characterImage));
            characterDescriptionElement.appendChild(characterImageElement);
        }
        parent.appendChild(characterDescriptionElement);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterDescription that = (CharacterDescription) o;

        if (!getPersonality().equals(that.getPersonality())) return false;
        if (!getFlaws().equals(that.getFlaws())) return false;
        if (!getIdeals().equals(that.getIdeals())) return false;
        if (!getBonds().equals(that.getBonds())) return false;
        if (!getPrivilegesAndTraits().equals(that.getPrivilegesAndTraits())) return false;
        if (!getAge().equals(that.getAge())) return false;
        if (!getHeight().equals(that.getHeight())) return false;
        if (!getWeight().equals(that.getWeight())) return false;
        if (!getEyes().equals(that.getEyes())) return false;
        if (!getSkin().equals(that.getSkin())) return false;
        if (!getHair().equals(that.getHair())) return false;
        return getCharacterImage() != null ? getCharacterImage().equals(that.getCharacterImage()) : that.getCharacterImage() == null;
    }
    @Override
    public int hashCode() {
        int result = getPersonality().hashCode();
        result = 31 * result + getFlaws().hashCode();
        result = 31 * result + getIdeals().hashCode();
        result = 31 * result + getBonds().hashCode();
        result = 31 * result + getPrivilegesAndTraits().hashCode();
        result = 31 * result + getAge().hashCode();
        result = 31 * result + getHeight().hashCode();
        result = 31 * result + getWeight().hashCode();
        result = 31 * result + getEyes().hashCode();
        result = 31 * result + getSkin().hashCode();
        result = 31 * result + getHair().hashCode();
        result = 31 * result + (getCharacterImage() != null ? getCharacterImage().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "CharacterDescription{" +
                "personality=" + personality +
                ", flaws=" + flaws +
                ", ideals=" + ideals +
                ", bonds=" + bonds +
                ", privilegesAndTraits=" + privilegesAndTraits +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", eyes='" + eyes + '\'' +
                ", skin='" + skin + '\'' +
                ", hair='" + hair + '\'' +
                ", characterImage=" + characterImage +
                '}';
    }
}
