package models;

public class Spell {
    private boolean castable;
    private int tomIndex;
    private int taxCount;
    private boolean repeatable;

    public Spell() {}

    public Spell(boolean castable, int tomIndex, int taxCount, boolean repeatable) {
        this.castable = castable;
        this.tomIndex = tomIndex;
        this.taxCount = taxCount;
        this.repeatable = repeatable;
    }

    public boolean isCastable() {
        return castable;
    }

    public void setCastable(boolean castable) {
        this.castable = castable;
    }

    public int getTomIndex() {
        return tomIndex;
    }

    public void setTomIndex(int tomIndex) {
        this.tomIndex = tomIndex;
    }

    public int getTaxCount() {
        return taxCount;
    }

    public void setTaxCount(int taxCount) {
        this.taxCount = taxCount;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "castable=" + castable +
                '}';
    }
}
