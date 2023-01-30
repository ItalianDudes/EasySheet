package it.italiandudes.easy_sheet.common.sheet.character;

import it.italiandudes.easy_sheet.common.sheet.SheetComponent;
import it.italiandudes.easy_sheet.common.sheet.generic.DiceRoll;
import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class Vitality implements SheetComponent {

    //Attributes
    @NotNull private final ArmorClass AC;
    @NotNull private String speed;
    private int maxHP;
    private int currentHP;
    @NotNull private final DiceRoll totalHitDiceRoll;
    @NotNull private final DiceRoll currentHitDiceRoll;
    private int successDeathSavingThrows;
    private int failDeathSavingThrows;

    //Constructors
    public Vitality(@NotNull ArmorClass AC, @Nullable String speed, int maxHP, int currentHP,
                    @NotNull DiceRoll totalHitDiceRoll, @NotNull DiceRoll currentHitDiceRoll,
                    int successDeathSavingThrows, int failDeathSavingThrows){
        this.AC = AC;
        if(speed == null) this.speed = "";
        else this.speed = speed;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.totalHitDiceRoll = totalHitDiceRoll;
        this.currentHitDiceRoll = currentHitDiceRoll;
        this.successDeathSavingThrows = successDeathSavingThrows;
        this.failDeathSavingThrows = failDeathSavingThrows;
    }
    public Vitality(){
        AC = new ArmorClass();
        speed = "";
        maxHP = currentHP = 0;
        this.totalHitDiceRoll = new DiceRoll(0, 0);
        this.currentHitDiceRoll = new DiceRoll(0, 0);
        successDeathSavingThrows = 0;
        failDeathSavingThrows = 0;
    }
    public Vitality(@NotNull Element dndSheet) throws RuntimeException {
        AC = new ArmorClass(dndSheet);
        speed = dndSheet.getElementsByTagName(Character.Vitality.SPEED).item(0).getTextContent();
        maxHP = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.MAX_HP).item(0).getTextContent());
        currentHP = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.CURRENT_HP).item(0).getTextContent());
        totalHitDiceRoll = new DiceRoll(dndSheet.getElementsByTagName(Character.Vitality.TOTAL_HIT_DICE_ROLL).item(0).getTextContent());
        currentHitDiceRoll = new DiceRoll(dndSheet.getElementsByTagName(Character.Vitality.CURRENT_HIT_DICE_ROLL).item(0).getTextContent());
        successDeathSavingThrows = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.SUCCESS_DEATH_SAVING_THROWS).item(0).getTextContent());
        failDeathSavingThrows = Integer.parseInt(dndSheet.getElementsByTagName(Character.Vitality.FAIL_DEATH_SAVING_THROWS).item(0).getTextContent());
    }

    //Methods
    @NotNull
    public ArmorClass getAC() {
        return AC;
    }
    @NotNull
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(@Nullable String speed) {
        if(speed == null) this.speed = "";
        else this.speed = speed;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }
    public int getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
    @NotNull
    public DiceRoll getTotalHitDiceRoll() {
        return totalHitDiceRoll;
    }
    @NotNull
    public DiceRoll getCurrentHitDiceRoll() {
        return currentHitDiceRoll;
    }
    public int getSuccessDeathSavingThrows() {
        return successDeathSavingThrows;
    }
    public void setSuccessDeathSavingThrows(int successDeathSavingThrows) {
        this.successDeathSavingThrows = successDeathSavingThrows;
    }
    public int getFailDeathSavingThrows() {
        return failDeathSavingThrows;
    }
    public void setFailDeathSavingThrows(int failDeathSavingThrows) {
        this.failDeathSavingThrows = failDeathSavingThrows;
    }
    @Override
    public void writeComponent(@NotNull Document dndSheet, @NotNull Element parent) {
        Element vitalityElement = dndSheet.createElement(Character.Vitality.VITALITY);
        AC.writeComponent(dndSheet, vitalityElement);
        Element speedElement = dndSheet.createElement(Character.Vitality.SPEED);
        speedElement.setTextContent(speed);
        vitalityElement.appendChild(speedElement);
        Element maxHPElement = dndSheet.createElement(Character.Vitality.MAX_HP);
        maxHPElement.setTextContent(String.valueOf(maxHP));
        vitalityElement.appendChild(maxHPElement);
        Element currentHPElement = dndSheet.createElement(Character.Vitality.CURRENT_HP);
        currentHPElement.setTextContent(String.valueOf(currentHP));
        vitalityElement.appendChild(currentHPElement);
        Element totalHitDiceRollElement = dndSheet.createElement(Character.Vitality.TOTAL_HIT_DICE_ROLL);
        totalHitDiceRollElement.setTextContent(totalHitDiceRoll.toString());
        vitalityElement.appendChild(totalHitDiceRollElement);
        Element currentHitDiceRollElement = dndSheet.createElement(Character.Vitality.CURRENT_HIT_DICE_ROLL);
        currentHitDiceRollElement.setTextContent(currentHitDiceRoll.toString());
        vitalityElement.appendChild(currentHitDiceRollElement);
        Element successDeathSavingThrowsElement = dndSheet.createElement(Character.Vitality.SUCCESS_DEATH_SAVING_THROWS);
        successDeathSavingThrowsElement.setTextContent(String.valueOf(successDeathSavingThrows));
        vitalityElement.appendChild(successDeathSavingThrowsElement);
        Element failDeathSavingThrowsElement = dndSheet.createElement(Character.Vitality.FAIL_DEATH_SAVING_THROWS);
        failDeathSavingThrowsElement.setTextContent(String.valueOf(failDeathSavingThrows));
        vitalityElement.appendChild(failDeathSavingThrowsElement);
        parent.appendChild(vitalityElement);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vitality vitality = (Vitality) o;

        if (getMaxHP() != vitality.getMaxHP()) return false;
        if (getCurrentHP() != vitality.getCurrentHP()) return false;
        if (getSuccessDeathSavingThrows() != vitality.getSuccessDeathSavingThrows()) return false;
        if (getFailDeathSavingThrows() != vitality.getFailDeathSavingThrows()) return false;
        if (!getAC().equals(vitality.getAC())) return false;
        if (!getSpeed().equals(vitality.getSpeed())) return false;
        if (!getTotalHitDiceRoll().equals(vitality.getTotalHitDiceRoll())) return false;
        return getCurrentHitDiceRoll().equals(vitality.getCurrentHitDiceRoll());
    }
    @Override
    public int hashCode() {
        int result = getAC().hashCode();
        result = 31 * result + getSpeed().hashCode();
        result = 31 * result + getMaxHP();
        result = 31 * result + getCurrentHP();
        result = 31 * result + getTotalHitDiceRoll().hashCode();
        result = 31 * result + getCurrentHitDiceRoll().hashCode();
        result = 31 * result + getSuccessDeathSavingThrows();
        result = 31 * result + getFailDeathSavingThrows();
        return result;
    }
    @Override
    public String toString() {
        return "Vitality{" +
                "AC=" + AC +
                ", speed='" + speed + '\'' +
                ", maxHP=" + maxHP +
                ", currentHP=" + currentHP +
                ", totalHitDiceRoll=" + totalHitDiceRoll +
                ", currentHitDiceRoll=" + currentHitDiceRoll +
                ", successDeathSavingThrows=" + successDeathSavingThrows +
                ", failDeathSavingThrows=" + failDeathSavingThrows +
                '}';
    }
}
