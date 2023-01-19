package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.common.sheet.generic.Spell;
import it.italiandudes.easy_sheet.common.sheet.spell_category.CasterHeader;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class SpellCategory {

    //Attributes
    @NotNull private final CasterHeader casterHeader;
    @NotNull private final ArrayList<Spell> spells;

    //Constructors
    public SpellCategory(){
        casterHeader = new CasterHeader();
        spells = new ArrayList<>();
    }
    public SpellCategory(@NotNull CasterHeader casterHeader, @NotNull ArrayList<Spell> spells){
        this.casterHeader = casterHeader;
        this.spells = spells;
    }
    public SpellCategory(@NotNull Document dndSheet){
        casterHeader = null;
        spells = null;
        //TODO: read xml sheet
    }

    //Methods
    @NotNull
    public CasterHeader getCasterHeader() {
        return casterHeader;
    }
    @NotNull
    public ArrayList<Spell> getSpells() {
        return spells;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpellCategory that = (SpellCategory) o;

        if (!getCasterHeader().equals(that.getCasterHeader())) return false;
        return getSpells().equals(that.getSpells());
    }
    @Override
    public int hashCode() {
        int result = getCasterHeader().hashCode();
        result = 31 * result + getSpells().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "SpellCategory{" +
                "casterHeader=" + casterHeader +
                ", spells=" + spells +
                '}';
    }
}
