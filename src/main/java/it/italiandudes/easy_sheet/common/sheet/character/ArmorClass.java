package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import org.jetbrains.annotations.NotNull;
import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class ArmorClass implements SheetComponent {

    //Attributes
    private int currentAC;
    private int naturalAC;
    private int armorAC;
    private int shieldAC;
    private int traitsAC;

    //Constructors
    public ArmorClass(int naturalAC, int armorAC, int shieldAC, int traitsAC){
        this.naturalAC = naturalAC;
        this.armorAC = armorAC;
        this.shieldAC = shieldAC;
        this.traitsAC = traitsAC;
        updateTotalAC();
    }
    public ArmorClass(){
        this.naturalAC = 1;
        this.armorAC = 0;
        this.shieldAC = 0;
        this.traitsAC = 0;
        updateTotalAC();
    }
    public ArmorClass(@NotNull Element dndSheet) throws RuntimeException {
        naturalAC = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.ArmorClass.NATURAL_AC).item(0).getTextContent());
        armorAC = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.ArmorClass.ARMOR_AC).item(0).getTextContent());
        shieldAC = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.ArmorClass.SHIELD_AC).item(0).getTextContent());
        traitsAC = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.ArmorClass.TRAITS_AC).item(0).getTextContent());
        updateTotalAC();
    }

    //Methods
    public void updateTotalAC(){
        currentAC = naturalAC+armorAC+shieldAC+traitsAC;
    }
    public int getCurrentAC() {
        return currentAC;
    }
    public int getNaturalAC() {
        return naturalAC;
    }
    public void setNaturalAC(int naturalAC) {
        this.naturalAC = naturalAC;
        updateTotalAC();
    }
    public int getArmorAC() {
        return armorAC;
    }
    public void setArmorAC(int armorAC) {
        this.armorAC = armorAC;
        updateTotalAC();
    }
    public int getShieldAC() {
        return shieldAC;
    }
    public void setShieldAC(int shieldAC) {
        this.shieldAC = shieldAC;
        updateTotalAC();
    }
    public int getTraitsAC() {
        return traitsAC;
    }
    public void setTraitsAC(int traitsAC) {
        this.traitsAC = traitsAC;
        updateTotalAC();
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element armorClassElement = dndSheet.createElement(Character.Vitality.ArmorClass.ARMOR_CLASS);
        Element naturalACElement = dndSheet.createElement(Character.Vitality.ArmorClass.NATURAL_AC);
        naturalACElement.setTextContent(String.valueOf(naturalAC));
        armorClassElement.appendChild(naturalACElement);
        Element armorACElement = dndSheet.createElement(Character.Vitality.ArmorClass.ARMOR_AC);
        armorACElement.setTextContent(String.valueOf(armorAC));
        armorClassElement.appendChild(armorACElement);
        Element shieldACElement = dndSheet.createElement(Character.Vitality.ArmorClass.SHIELD_AC);
        shieldACElement.setTextContent(String.valueOf(shieldAC));
        armorClassElement.appendChild(shieldACElement);
        Element traitsACElement = dndSheet.createElement(Character.Vitality.ArmorClass.TRAITS_AC);
        traitsACElement.setTextContent(String.valueOf(traitsAC));
        armorClassElement.appendChild(traitsACElement);
        parent.appendChild(armorClassElement);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArmorClass that = (ArmorClass) o;

        if (getCurrentAC() != that.getCurrentAC()) return false;
        if (getNaturalAC() != that.getNaturalAC()) return false;
        if (getArmorAC() != that.getArmorAC()) return false;
        if (getShieldAC() != that.getShieldAC()) return false;
        return getTraitsAC() == that.getTraitsAC();
    }
    @Override
    public int hashCode() {
        int result = getCurrentAC();
        result = 31 * result + getNaturalAC();
        result = 31 * result + getArmorAC();
        result = 31 * result + getShieldAC();
        result = 31 * result + getTraitsAC();
        return result;
    }
    @Override
    public String toString() {
        return "ArmorClass{" +
                "currentAC=" + currentAC +
                ", naturalAC=" + naturalAC +
                ", armorAC=" + armorAC +
                ", shieldAC=" + shieldAC +
                ", traitsAC=" + traitsAC +
                '}';
    }
}
