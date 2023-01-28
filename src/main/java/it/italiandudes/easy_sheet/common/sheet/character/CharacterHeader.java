package it.italiandudes.easy_sheet.common.sheet.character;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import it.italiandudes.easy_sheet.EasySheet.Defs.XMLElementNames.Character;
import org.w3c.dom.Element;

@SuppressWarnings("unused")
public final class CharacterHeader {

    //Attributes
    @NotNull private String characterName;
    @NotNull private String characterClass;
    private int level;
    @NotNull private String background;
    @NotNull private String race;
    @NotNull private String playerName;
    @NotNull private String alignment;
    @NotNull private String campaign;
    private int exp;

    //Constructors
    public CharacterHeader(@Nullable String characterName, @Nullable String characterClass, int level,
                           @Nullable String background, @Nullable String race, @Nullable String playerName,
                           @Nullable String alignment, @Nullable String campaign){
        if(characterName == null) characterName = "";
        this.characterName = characterName;
        if(characterClass == null) characterClass = "";
        this.characterClass = characterClass;
        this.level = level;
        if(background == null) background = "";
        this.background = background;
        if(race == null) race = "";
        this.race = race;
        if(playerName == null) playerName = "";
        this.playerName = playerName;
        if(alignment == null) alignment = "";
        this.alignment = alignment;
        if(campaign == null) campaign = "";
        this.campaign = campaign;
    }
    public CharacterHeader(){
        this(null, null, 1, null, null, null, null, null);
    }
    public CharacterHeader(@NotNull Element dndSheet) throws RuntimeException {
        characterName = dndSheet.getElementsByTagName(Character.CharacterHeader.CHARACTER_NAME).item(0).getTextContent();
        characterClass = dndSheet.getElementsByTagName(Character.CharacterHeader.CHARACTER_CLASS).item(0).getTextContent();
        level = Integer.parseInt(dndSheet.getElementsByTagName(Character.CharacterHeader.LEVEL).item(0).getTextContent());
        background = dndSheet.getElementsByTagName(Character.CharacterHeader.BACKGROUND).item(0).getTextContent();
        race = dndSheet.getElementsByTagName(Character.CharacterHeader.RACE).item(0).getTextContent();
        playerName = dndSheet.getElementsByTagName(Character.CharacterHeader.PLAYER_NAME).item(0).getTextContent();
        alignment = dndSheet.getElementsByTagName(Character.CharacterHeader.ALIGNMENT).item(0).getTextContent();
        campaign = dndSheet.getElementsByTagName(Character.CharacterHeader.CAMPAIGN).item(0).getTextContent();
        exp = Integer.parseInt(dndSheet.getElementsByTagName(Character.CharacterHeader.EXP).item(0).getTextContent());
    }

    //Methods
    @NotNull
    public String getCharacterName() {
        return characterName;
    }
    public void setCharacterName(@Nullable String characterName) {
        if(characterName == null) this.characterName = "";
        else this.characterName = characterName;
    }
    @NotNull
    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(@Nullable String characterClass) {
        if(characterClass == null) this.characterClass = "";
        else this.characterClass = characterClass;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    @NotNull
    public String getBackground() {
        return background;
    }
    public void setBackground(@Nullable String background) {
        if(background == null) this.background = "";
        else this.background = background;
    }
    @NotNull
    public String getRace() {
        return race;
    }
    public void setRace(@Nullable String race) {
        if(race == null) this.race = "";
        else this.race = race;
    }
    @NotNull
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(@Nullable String playerName) {
        if(playerName == null) this.playerName = "";
        else this.playerName = playerName;
    }
    @NotNull
    public String getAlignment() {
        return alignment;
    }
    public void setAlignment(@Nullable String alignment) {
        if(alignment == null) this.alignment = "";
        else this.alignment = alignment;
    }
    @NotNull
    public String getCampaign() {
        return campaign;
    }
    public void setCampaign(@Nullable String campaign) {
        if(campaign == null) this.campaign = "";
        else this.campaign = campaign;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterHeader that = (CharacterHeader) o;

        if (getLevel() != that.getLevel()) return false;
        if (getExp() != that.getExp()) return false;
        if (!getCharacterName().equals(that.getCharacterName())) return false;
        if (!getCharacterClass().equals(that.getCharacterClass())) return false;
        if (!getBackground().equals(that.getBackground())) return false;
        if (!getRace().equals(that.getRace())) return false;
        if (!getPlayerName().equals(that.getPlayerName())) return false;
        if (!getAlignment().equals(that.getAlignment())) return false;
        return getCampaign().equals(that.getCampaign());
    }
    @Override
    public int hashCode() {
        int result = getCharacterName().hashCode();
        result = 31 * result + getCharacterClass().hashCode();
        result = 31 * result + getLevel();
        result = 31 * result + getBackground().hashCode();
        result = 31 * result + getRace().hashCode();
        result = 31 * result + getPlayerName().hashCode();
        result = 31 * result + getAlignment().hashCode();
        result = 31 * result + getCampaign().hashCode();
        result = 31 * result + getExp();
        return result;
    }
    @Override
    public String toString() {
        return "CharacterHeader{" +
                "characterName='" + characterName + '\'' +
                ", characterClass='" + characterClass + '\'' +
                ", level=" + level +
                ", background='" + background + '\'' +
                ", race='" + race + '\'' +
                ", playerName='" + playerName + '\'' +
                ", alignment='" + alignment + '\'' +
                ", campaign='" + campaign + '\'' +
                ", exp=" + exp +
                '}';
    }
}
