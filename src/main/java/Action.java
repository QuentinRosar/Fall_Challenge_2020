public class Action {
    private int id;
    private String actionType;
    private int[] delta;
    private int price;
    private int tomIndex;
    private int taxCount;
    private boolean castable;
    private boolean repeatable;

    public Action(int actionID, String actionType, int delta0, int delta1, int delta2, int delta3, int price) {
        this.id = actionID;
        this.actionType = actionType;
        this.delta = createDeltaArray(delta0, delta1, delta2, delta3);
        this.price = price;
    }

    private int[] createDeltaArray(int delta0, int delta1, int delta2, int delta3) {
        int[] deltaArray = new int[3];
        deltaArray[0] = delta0;
        deltaArray[1] = delta1;
        deltaArray[2] = delta2;
        deltaArray[3] = delta3;
        return deltaArray;
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

    public int[] getDelta() {
        return delta;
    }

    public void setDelta(int[] delta) {
        this.delta = delta;
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
}
