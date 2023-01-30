package it.italiandudes.easy_sheet.common.sheet.character;

@SuppressWarnings("unused")
public enum MajorAbility {
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
}
