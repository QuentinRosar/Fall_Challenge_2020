package models;

public class Items {
    private int delta0;
    private int delta1;
    private int delta2;
    private int delta3;
    private int price;

    public Items() {}

    public Items(Items items) {
        this.delta0 = items.getDelta0();
        this.delta1 = items.getDelta1();
        this.delta2 = items.getDelta2();
        this.delta3 = items.getDelta3();
        this.price = items.getPrice();
    }

    public Items(int delta0, int delta1, int delta2, int delta3, int price) {
        this.delta0 = delta0;
        this.delta1 = delta1;
        this.delta2 = delta2;
        this.delta3 = delta3;
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
