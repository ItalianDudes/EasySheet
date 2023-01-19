package it.italiandudes.easy_sheet.common.sheet.generic;

@SuppressWarnings("unused")
public final class DiceRoll {

    //Attributes
    private int numDices;
    private int numFaces;

    //Constructors
    public DiceRoll(int numDices, int numFaces){
        this.numDices = numDices;
        this.numFaces = numFaces;
    }

    //Methods
    public int getNumDices() {
        return numDices;
    }
    public void setNumDices(int numDices) {
        this.numDices = numDices;
    }
    public int getNumFaces() {
        return numFaces;
    }
    public void setNumFaces(int numFaces) {
        this.numFaces = numFaces;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiceRoll diceRoll = (DiceRoll) o;

        if (getNumDices() != diceRoll.getNumDices()) return false;
        return getNumFaces() == diceRoll.getNumFaces();
    }
    @Override
    public int hashCode() {
        int result = getNumDices();
        result = 31 * result + getNumFaces();
        return result;
    }

    @Override
    public String toString() {
        return numDices+"d"+numFaces;
    }
}
