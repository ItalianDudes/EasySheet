package it.italiandudes.easy_sheet.common.sheet.character;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;

@SuppressWarnings("unused")
public final class ArmorClass {

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
    public ArmorClass(@NotNull Document dndSheet){
        //TODO: read xml sheet
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
