package it.italiandudes.easy_sheet.common.sheet;

import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames;
import it.italiandudes.easy_sheet.common.sheet.generic.Spell;
import it.italiandudes.easy_sheet.common.sheet.spell_category.CasterHeader;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Base64;

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
    public SpellCategory(@NotNull Element dndSheet) throws RuntimeException {
        Element spellCategory = (Element) dndSheet.getElementsByTagName(XMLElementNames.SpellCategory.SPELL_CATEGORY).item(0);
        casterHeader = new CasterHeader(dndSheet);
        spells = new ArrayList<>();
        NodeList spellNodeList = spellCategory.getElementsByTagName(XMLElementNames.SpellCategory.Spell.SPELL);
        for(int i=0; i<spellNodeList.getLength(); i++){
            Element spellElement = (Element) spellNodeList.item(i);
            String spellName = spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.NAME).item(0).getTextContent();
            int spellLevel = Integer.parseInt(spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.LEVEL).item(0).getTextContent());
            String spellType;
            if(spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.TYPE).getLength()>0){
                spellType = spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.TYPE).item(0).getTextContent();
            }else{
                spellType = "";
            }
            String spellDescription;
            if(spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.DESCRIPTION).getLength()>0){
                spellDescription = spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.DESCRIPTION).item(0).getTextContent();
            }else{
                spellDescription = "";
            }
            Image spellImage;
            if(spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.IMAGE).getLength()>0){
                spellImage = new Image(new ByteArrayInputStream(Base64.getDecoder().decode(
                        spellElement.getElementsByTagName(XMLElementNames.SpellCategory.Spell.IMAGE).item(0).getTextContent()
                )));
            }else{
                spellImage = null;
            }
            spells.add(new Spell(spellName, spellLevel, spellType, spellDescription, spellImage));
        }
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
