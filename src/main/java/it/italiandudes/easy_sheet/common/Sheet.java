package it.italiandudes.easy_sheet.common;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.common.sheet.Character;
import it.italiandudes.easy_sheet.common.sheet.Inventory;
import it.italiandudes.easy_sheet.common.sheet.spell_category.CasterHeader;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.idl.common.Logger;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public final class Sheet {

    //Attributes
    @NotNull private final Character character;
    @NotNull private final Inventory inventory;
    @NotNull private final CasterHeader casterHeader;

    //Constructors
    public Sheet(){
        this.character = new Character();
        this.inventory = new Inventory();
        this.casterHeader = new CasterHeader();
    }
    public Sheet(@NotNull Character character, @NotNull Inventory inventory, @NotNull CasterHeader casterHeader){
        this.character = character;
        this.inventory = inventory;
        this.casterHeader = casterHeader;
    }
    public Sheet(String sheetPath) throws RuntimeException {
        if(!validateSheet(sheetPath)) throw new RuntimeException("The sheet is invalid!");
        Document dndSheet;
        try {
            dndSheet = EasySheet.XML_DOCUMENT_BUILDER.parse(new File(sheetPath));
        }catch (IOException | SAXException e) {
            Logger.log(e);
            throw new RuntimeException(e);
        }
        this.character = new Character(dndSheet);
        this.inventory = new Inventory(dndSheet);
        this.casterHeader = new CasterHeader(dndSheet);
    }

    //Methods
    @NotNull
    public Character getCharacter(){
        return character;
    }
    @NotNull
    public Inventory getInventory(){
        return inventory;
    }
    @NotNull
    public CasterHeader getSpellCategory(){
        return casterHeader;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sheet sheet = (Sheet) o;

        if (!getCharacter().equals(sheet.getCharacter())) return false;
        if (!getInventory().equals(sheet.getInventory())) return false;
        return getSpellCategory().equals(sheet.getSpellCategory());
    }
    @Override
    public int hashCode() {
        int result = getCharacter().hashCode();
        result = 31 * result + getInventory().hashCode();
        result = 31 * result + getSpellCategory().hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Sheet{" +
                "character=" + character +
                ", inventory=" + inventory +
                ", spellCategory=" + casterHeader +
                '}';
    }

    //Constants
    private static final Validator SHEET_VALIDATOR;
    static {
        try {
            SHEET_VALIDATOR = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(JFXDefs.Resource.get(JFXDefs.Resource.XMLSchema.XML_SCHEMA_SHEET)).newValidator();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }

    //Sheet Validator
    public static boolean validateSheet(@NotNull String sheetPath) {
        try {
            SHEET_VALIDATOR.validate(new StreamSource(new File(sheetPath)));
            return true;
        } catch (Exception e) {
            Logger.log(e);
            return false;
        }
    }
}
