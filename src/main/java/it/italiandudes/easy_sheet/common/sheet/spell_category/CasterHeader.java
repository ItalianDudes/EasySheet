package it.italiandudes.easy_sheet.common.sheet.spell_category;

import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class CasterHeader {

    //Attributes
    @NotNull private String casterClass;
    @NotNull private String casterAbility;
    private int cdSpellSavingThrows;
    private int spellAttackBonus;

    //Constructors
    public CasterHeader(@Nullable String casterClass, @Nullable String casterAbility, int cdSpellSavingThrows, int spellAttackBonus){
        if(casterAbility == null) casterAbility = "";
        this.casterAbility = casterAbility;
        if(casterClass == null) casterClass = "";
        this.casterClass = casterClass;
        this.cdSpellSavingThrows = cdSpellSavingThrows;
        this.spellAttackBonus = spellAttackBonus;
    }
    public CasterHeader(){
        casterClass = "";
        casterAbility = "";
        cdSpellSavingThrows = 0;
        spellAttackBonus = 0;
    }
    public CasterHeader(@NotNull Element dndSheet) throws RuntimeException {
        Element casterHeaderElement = (Element) dndSheet.getElementsByTagName(XMLElementNames.SpellCategory.CasterHeader.CASTER_HEADER).item(0);
        casterClass = casterHeaderElement.getElementsByTagName(XMLElementNames.SpellCategory.CasterHeader.CASTER_CLASS).item(0).getTextContent();
        casterAbility = casterHeaderElement.getElementsByTagName(XMLElementNames.SpellCategory.CasterHeader.CASTER_ABILITY).item(0).getTextContent();
        cdSpellSavingThrows = Integer.parseInt(casterHeaderElement.getElementsByTagName(XMLElementNames.SpellCategory.CasterHeader.CD_SPELL_SAVING_THROWS).item(0).getTextContent());
        spellAttackBonus = Integer.parseInt(casterHeaderElement.getElementsByTagName(XMLElementNames.SpellCategory.CasterHeader.SPELL_ATTACK_BONUS).item(0).getTextContent());
    }

    //Methods
    @NotNull
    public String getCasterClass() {
        return casterClass;
    }
    public void setCasterClass(@Nullable String casterClass) {
        if(casterClass == null) this.casterClass = "";
        else this.casterClass = casterClass;
    }
    @NotNull
    public String getCasterAbility() {
        return casterAbility;
    }
    public void setCasterAbility(@Nullable String casterAbility) {
        if(casterAbility == null) this.casterAbility = "";
        else this.casterAbility = casterAbility;
    }
    public int getCdSpellSavingThrows() {
        return cdSpellSavingThrows;
    }
    public void setCdSpellSavingThrows(int cdSpellSavingThrows) {
        this.cdSpellSavingThrows = cdSpellSavingThrows;
    }
    public int getSpellAttackBonus() {
        return spellAttackBonus;
    }
    public void setSpellAttackBonus(int spellAttackBonus) {
        this.spellAttackBonus = spellAttackBonus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CasterHeader that = (CasterHeader) o;

        if (getCdSpellSavingThrows() != that.getCdSpellSavingThrows()) return false;
        if (getSpellAttackBonus() != that.getSpellAttackBonus()) return false;
        if (!getCasterClass().equals(that.getCasterClass())) return false;
        return getCasterAbility().equals(that.getCasterAbility());
    }
    @Override
    public int hashCode() {
        int result = getCasterClass().hashCode();
        result = 31 * result + getCasterAbility().hashCode();
        result = 31 * result + getCdSpellSavingThrows();
        result = 31 * result + getSpellAttackBonus();
        return result;
    }
    @Override
    public String toString() {
        return "SpellCategory{" +
                "casterClass='" + casterClass + '\'' +
                ", casterAbility='" + casterAbility + '\'' +
                ", cdSpellSavingThrows=" + cdSpellSavingThrows +
                ", spellAttackBonus=" + spellAttackBonus +
                '}';
    }
}
