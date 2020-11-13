package models;

public class Inventory {
    int inv0;
    int inv1;
    int inv2;
    int inv3;
    int score;

    public Inventory(int inv0, int inv1, int inv2, int inv3, int score) {
        this.inv0 = inv0;
        this.inv1 = inv1;
        this.inv2 = inv2;
        this.inv3 = inv3;
        this.score = score;
    }

    public int getInv0() {
        return inv0;
    }

    public void setInv0(int inv0) {
        this.inv0 = inv0;
    }

    public int getInv1() {
        return inv1;
    }

    public void setInv1(int inv1) {
        this.inv1 = inv1;
    }

    public int getInv2() {
        return inv2;
    }

    public void setInv2(int inv2) {
        this.inv2 = inv2;
    }

    public int getInv3() {
        return inv3;
    }

    public void setInv3(int inv3) {
        this.inv3 = inv3;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inv0=" + inv0 +
                ", inv1=" + inv1 +
                ", inv2=" + inv2 +
                ", inv3=" + inv3 +
                ", score=" + score +
                '}';
    }
}
