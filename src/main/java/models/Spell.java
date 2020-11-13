package models;

public class Spell {
    private boolean castable;

    public Spell(boolean castable) {
        this.castable = castable;
    }

    public boolean isCastable() {
        return castable;
    }

    public void setCastable(boolean castable) {
        this.castable = castable;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "castable=" + castable +
                '}';
    }
}
