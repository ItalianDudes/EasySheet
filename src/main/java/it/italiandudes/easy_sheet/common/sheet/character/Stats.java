package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@SuppressWarnings("unused")
public final class Stats implements SheetComponent {

    //Attributes
    private int proficiencyBonus;
    private int inspirationBonus;

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
    }
    public Stats(){
        proficiencyBonus = 2;
        inspirationBonus = 0;
    }
    public Stats(@NotNull Element dndSheet) throws RuntimeException {
        proficiencyBonus = Integer.parseInt(dndSheet.getElementsByTagName(Character.Stats.PROFICIENCY_BONUS).item(0).getTextContent());
        inspirationBonus = Integer.parseInt(dndSheet.getElementsByTagName(Character.Stats.INSPIRATION_BONUS).item(0).getTextContent());
        NodeList majorAbilityList = dndSheet.getElementsByTagName(Character.Stats.MajorAbility.MAJOR_ABILITY);
        for(int i=0;i<majorAbilityList.getLength();i++){
            MajorAbility.values()[i].setValue(Integer.parseInt(((Element)majorAbilityList.item(i)).getAttribute(Character.Stats.MajorAbility.VALUE)));
            MajorAbility.values()[i].setSavingThrowProficiency(Boolean.parseBoolean(((Element)majorAbilityList.item(i)).getAttribute(Character.Stats.MajorAbility.SAVING_THROW_PROFICIENCY)));
        }
        NodeList abilityList = dndSheet.getElementsByTagName(Character.Stats.Abilities.ABILITY);
        for(int i=0;i<abilityList.getLength();i++){
            Ability.values()[i].setProficiencyLevel(Integer.parseInt(((Element) abilityList.item(i)).getAttribute(Character.Stats.Abilities.PROFICIENCY_LEVEL)));
        }
    }

    //Methods
    public int getProficiencyBonus() {
        return proficiencyBonus;
    }
    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }
    public int getInspirationBonus() {
        return inspirationBonus;
    }
    public void setInspirationBonus(int inspirationBonus) {
        this.inspirationBonus = inspirationBonus;
    }
    public int getPassivePerception() {
        return 10+Ability.PERCEPTION.relativeMajorAbility.getMod()+(proficiencyBonus*Ability.PERCEPTION.getProficiencyLevel());
    }
    public int getInitiative() {
        return MajorAbility.DEXTERITY.getMod();
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element statsElement = dndSheet.createElement(Character.Stats.STATS);
        Element proficiencyBonusElement = dndSheet.createElement(Character.Stats.PROFICIENCY_BONUS);
        proficiencyBonusElement.setTextContent(String.valueOf(proficiencyBonus));
        statsElement.appendChild(proficiencyBonusElement);
        Element inspirationBonusElement = dndSheet.createElement(Character.Stats.INSPIRATION_BONUS);
        inspirationBonusElement.setTextContent(String.valueOf(inspirationBonus));
        statsElement.appendChild(inspirationBonusElement);
        Element majorAbilityElement;
        for(int i=0;i<MajorAbility.values().length;i++){
            majorAbilityElement = dndSheet.createElement(Character.Stats.MajorAbility.MAJOR_ABILITY);
            majorAbilityElement.setAttribute(Character.Stats.MajorAbility.ID, String.valueOf(i));
            majorAbilityElement.setAttribute(Character.Stats.MajorAbility.VALUE, String.valueOf(MajorAbility.values()[i].getValue()));
            majorAbilityElement.setAttribute(Character.Stats.MajorAbility.SAVING_THROW_PROFICIENCY, String.valueOf(MajorAbility.values()[i].hasSavingThrowProficiency()));
            statsElement.appendChild(majorAbilityElement);
        }
        Element abilitiesElement = dndSheet.createElement(Character.Stats.Abilities.ABILITIES);
        Element abilityElement;
        for(int i=0;i<Ability.values().length;i++){
            abilityElement = dndSheet.createElement(Character.Stats.Abilities.ABILITY);
            abilityElement.setAttribute(Character.Stats.Abilities.ID, String.valueOf(i));
            abilityElement.setAttribute(Character.Stats.Abilities.PROFICIENCY_LEVEL, String.valueOf(Ability.values()[i].getProficiencyLevel()));
            abilitiesElement.appendChild(abilityElement);
        }
        statsElement.appendChild(abilitiesElement);
        parent.appendChild(statsElement);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stats stats = (Stats) o;

        if (getProficiencyBonus() != stats.getProficiencyBonus()) return false;
        return getInspirationBonus() == stats.getInspirationBonus();
    }
    @Override
    public int hashCode() {
        int result = getProficiencyBonus();
        result = 31 * result + getInspirationBonus();
        return result;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "proficiencyBonus=" + proficiencyBonus +
                ", inspirationBonus=" + inspirationBonus +
                ", passivePerception=" + getPassivePerception() +
                ", initiative=" + getInitiative() +
                '}';
    }
}
