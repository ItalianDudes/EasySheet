package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.EasySheet;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;

@SuppressWarnings("unused")
public final class Stats {

    //Attributes
    private int proficiencyBonus;
    private int inspirationBonus;
    private int passivePerception;
    private int initiative;

    //Constructors
    public Stats(int proficiencyBonus, int inspirationBonus, int @NotNull [] majorAbilityValues, int @NotNull [] abilityProficiencyLevels){
        this.proficiencyBonus = proficiencyBonus;
        this.inspirationBonus = inspirationBonus;
        for(int i=0;i<EasySheet.Defs.MAJOR_ABILITIES_NUM;i++){
            MajorAbility.values()[i].setValue(majorAbilityValues[i]);
        }
        for(int i=0;i< EasySheet.Defs.MINOR_ABILITIES_NUM;i++){
            Ability.values()[i].setProficiencyLevel(abilityProficiencyLevels[i]);
        }
        updateInitiative();
        updatePassivePerception();
    }
    public Stats(){
        proficiencyBonus = 2;
        inspirationBonus = 0;
        updateInitiative();
        updatePassivePerception();
    }
    public Stats(@NotNull Document dndSheet){
        //TODO: read xml sheet
    }

    //Methods
    public void updateInitiative(){
        this.initiative = MajorAbility.DEXTERITY.getMod();
    }
    public void updatePassivePerception(){
        this.passivePerception = 10+Ability.PERCEPTION.relativeMajorAbility.getMod()+(proficiencyBonus*Ability.PERCEPTION.getProficiencyLevel());
    }
    public int getProficiencyBonus() {
        return proficiencyBonus;
    }
    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
        updatePassivePerception();
    }
    public int getInspirationBonus() {
        return inspirationBonus;
    }
    public void setInspirationBonus(int inspirationBonus) {
        this.inspirationBonus = inspirationBonus;
    }
    public int getPassivePerception() {
        return passivePerception;
    }
    public int getInitiative() {
        return initiative;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stats stats = (Stats) o;

        if (getProficiencyBonus() != stats.getProficiencyBonus()) return false;
        if (getInspirationBonus() != stats.getInspirationBonus()) return false;
        if (getPassivePerception() != stats.getPassivePerception()) return false;
        return getInitiative() == stats.getInitiative();
    }
    @Override
    public int hashCode() {
        int result = getProficiencyBonus();
        result = 31 * result + getInspirationBonus();
        result = 31 * result + getPassivePerception();
        result = 31 * result + getInitiative();
        return result;
    }
    @Override
    public String toString() {
        return "Stats{" +
                "proficiencyBonus=" + proficiencyBonus +
                ", inspirationBonus=" + inspirationBonus +
                ", passivePerception=" + passivePerception +
                ", initiative=" + initiative +
                '}';
    }
}
