package models;

public class Action {
    private int id;
    private String actionType;
    private int delta0;
    private int delta1;
    private int delta2;
    private int delta3;
    private int price;
    private int tomIndex;
    private int taxCount;
    private boolean castable;
    private boolean repeatable;

    public Action(int actionID, String actionType, int delta0, int delta1, int delta2, int delta3, int price) {
        this.id = actionID;
        this.actionType = actionType;
        this.delta0 = delta0;
        this.delta1 = delta1;
        this.delta2 = delta0;
        this.delta3 = delta3;
        this.price = price;
    }

    public int compareTo(Action compareAction) {
        int comparePrice = ((Action) compareAction).getPrice();
        return  comparePrice - this.price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public boolean isCastable() {
        return castable;
    }

    public void setCastable(boolean castable) {
        this.castable = castable;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
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

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", actionType='" + actionType + '\'' +
                ", delta0=" + delta0 +
                ", delta1=" + delta1 +
                ", delta2=" + delta2 +
                ", delta3=" + delta3 +
                ", price=" + price +
                ", tomIndex=" + tomIndex +
                ", taxCount=" + taxCount +
                ", castable=" + castable +
                ", repeatable=" + repeatable +
                '}';
    }
}
