package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public enum MajorAbility implements SheetComponent {
    STRENGTH(0),
    DEXTERITY(1),
    CONSTITUTION(2),
    INTELLIGENCE(3),
    WISDOM(4),
    CHARISMA(5)
    ;

    //Attributes
    public final int id;
    private int value;
    private int mod;
    private boolean savingThrowProficiency;

    //Constructors
    MajorAbility(int id, int value){
        this.id = id;
        this.value = value;
        this.mod = (value-10)/2;
    }
    MajorAbility(int id){
        this(id, 8);
    }

    //Methods
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
        mod = (value-10)/2;
    }
    public int getMod(){
        return mod;
    }
    public boolean hasSavingThrowProficiency(){
        return savingThrowProficiency;
    }
    public void setSavingThrowProficiency(boolean savingThrowProficiency){
        this.savingThrowProficiency = savingThrowProficiency;
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        //TODO: implement sheet component write
    }
}
