package models;

public class Action {
    private int id;
    private String actionType;
    private Order order;
    private int tomIndex;
    private int taxCount;
    private boolean castable;
    private boolean repeatable;

    public Action(int actionID, String actionType, Order order) {
        this.id = actionID;
        this.actionType = actionType;
        this.order = order;
    }

    public int compareTo(Action compareAction) {
        int comparePrice = ((Action) compareAction).getOrder().getPrice();
        return comparePrice - this.order.getPrice();
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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


    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", actionType='" + actionType + '\'' +
                ", order=" + order +
                ", tomIndex=" + tomIndex +
                ", taxCount=" + taxCount +
                ", castable=" + castable +
                ", repeatable=" + repeatable +
                '}';
    }
}
