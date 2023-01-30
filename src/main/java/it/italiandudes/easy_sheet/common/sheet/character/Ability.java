package it.italiandudes.easy_sheet.common.sheet.character;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public enum Ability {
    ACROBATICS(0, MajorAbility.DEXTERITY),
    ANIMAL_HANDLING(1, MajorAbility.WISDOM),
    ARCANA(2, MajorAbility.INTELLIGENCE),
    ATHELITCS(3, MajorAbility.STRENGTH),
    DECEPTION(4, MajorAbility.CHARISMA),
    HISTORY(5, MajorAbility.INTELLIGENCE),
    INSIGHT(6, MajorAbility.WISDOM),
    INTIMIDATION(7, MajorAbility.CHARISMA),
    INVESTIGATION(8, MajorAbility.INTELLIGENCE),
    MEDICINE(9, MajorAbility.WISDOM),
    NATURE(10, MajorAbility.INTELLIGENCE),
    PERCEPTION(11, MajorAbility.WISDOM),
    PERFORMANCE(12, MajorAbility.CHARISMA),
    PERSUASION(13, MajorAbility.CHARISMA),
    RELIGION(14, MajorAbility.INTELLIGENCE),
    SLEIGHT_OF_HAND(15, MajorAbility.DEXTERITY),
    STEALTH(16, MajorAbility.DEXTERITY),
    SURVIVAL(17, MajorAbility.WISDOM)
    ;
    //Attributes
    public final int id;
    public final MajorAbility relativeMajorAbility;
    private int proficiencyLevel; // 0 : none, 1 : proficiency, 2 : mastery

    //Constructors
    Ability(int id, @NotNull MajorAbility relativeMajorAbility){
        this(id, relativeMajorAbility, 0);
    }
    Ability(int id, @NotNull MajorAbility relativeMajorAbility, int proficiencyLevel){
        this.id = id;
        this.relativeMajorAbility = relativeMajorAbility;
        if(proficiencyLevel > 2) this.proficiencyLevel = 2;
        else this.proficiencyLevel = Math.max(proficiencyLevel, 0);
    }

    //Methods
    public int getProficiencyLevel() {
        return proficiencyLevel;
    }
    public void setProficiencyLevel(int proficiencyLevel) {
        if(proficiencyLevel > 2) this.proficiencyLevel = 2;
        else this.proficiencyLevel = Math.max(proficiencyLevel, 0);
    }
    @Override
    public String toString() {
        return "Ability{" +
                "id=" + id +
                ", proficiencyLevel=" + proficiencyLevel +
                "} " + super.toString();
    }
}
