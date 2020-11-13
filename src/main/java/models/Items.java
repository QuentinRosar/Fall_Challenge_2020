package models;

public class Items {
    private int delta0;
    private int delta1;
    private int delta2;
    private int delta3;
    private int price;

    public Items(int delta0, int delta1, int delta2, int delta3, int price) {
        this.delta0 = Math.abs(delta0);
        this.delta1 = Math.abs(delta1);
        this.delta2 = Math.abs(delta2);
        this.delta3 = Math.abs(delta3);
        this.price = price;
    }

    public int getDelta0() {
        return delta0;
    }

    public void setDelta0(int delta0) {
        this.delta0 = delta0;
    }

    public int getDelta1() {
        return delta1;
    }

    public void setDelta1(int delta1) {
        this.delta1 = delta1;
    }

    public int getDelta2() {
        return delta2;
    }

    public void setDelta2(int delta2) {
        this.delta2 = delta2;
    }

    public int getDelta3() {
        return delta3;
    }

    public void setDelta3(int delta3) {
        this.delta3 = delta3;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "delta0=" + delta0 +
                ", delta1=" + delta1 +
                ", delta2=" + delta2 +
                ", delta3=" + delta3 +
                ", price=" + price +
                '}';
    }
}
