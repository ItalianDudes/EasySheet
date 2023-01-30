package it.italiandudes.easy_sheet.common;

import it.italiandudes.easy_sheet.EasySheet;
import it.italiandudes.easy_sheet.common.sheet.Character;
import it.italiandudes.easy_sheet.common.sheet.Inventory;
import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import it.italiandudes.easy_sheet.common.sheet.SpellCategory;
import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.idl.common.Logger;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@SuppressWarnings("unused")
public final class Sheet implements SheetComponent {

    //Attributes
    @NotNull private final Character character;
    @NotNull private final Inventory inventory;
    @NotNull private final SpellCategory spellCategory;

    //Constructors
    public Sheet(){
        this.character = new Character();
        this.inventory = new Inventory();
        this.spellCategory = new SpellCategory();
    }
    public Sheet(@NotNull Character character, @NotNull Inventory inventory, @NotNull SpellCategory spellCategory){
        this.character = character;
        this.inventory = inventory;
        this.spellCategory = spellCategory;
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
        dndSheet.normalize();
        Element rootElement = dndSheet.getDocumentElement();
        this.character = new Character(rootElement);
        this.inventory = new Inventory(rootElement);
        this.spellCategory = new SpellCategory(rootElement);
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
    public SpellCategory getSpellCategory(){
        return spellCategory;
    }
    public void writeSheet(@NotNull String sheetPath) throws IOException, TransformerException {
        Document dndSheet = EasySheet.XML_DOCUMENT_BUILDER.newDocument();
        Element root = dndSheet.createElement(EasySheet.Defs.XMLElementNames.DND_SHEET);
        dndSheet.appendChild(root);
        character.writeComponent(dndSheet, root);
        inventory.writeComponent(dndSheet, root);
        spellCategory.writeComponent(dndSheet, root);
        File outputSheetFile = new File(sheetPath);
        DOMSource source = new DOMSource(root);
        StreamResult result;
        result = new StreamResult(Files.newOutputStream(outputSheetFile.toPath()));
        EasySheet.XML_DOCUMENT_WRITER.transform(source, result);
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        character.writeComponent(dndSheet, parent);
        inventory.writeComponent(dndSheet, parent);
        spellCategory.writeComponent(dndSheet, parent);
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
                ", spellCategory=" + spellCategory +
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
