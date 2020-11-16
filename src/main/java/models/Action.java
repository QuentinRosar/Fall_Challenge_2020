package models;

public class Action {
    private int id;
    private String actionType;
    private Items items;
    private Spell spell;

    public Action() {}

    public Action(int actionID, String actionType, Items order, Spell spell) {
        this.id = actionID;
        this.actionType = actionType;
        this.items = order;
        this.spell = spell;
    }

    public Action(Action action) {
        this.id = action.getId();
        this.actionType = action.getActionType();
        this.items = action.getItems();
        this.spell = action.spell;
    }



    public int compareTo(Action compareAction) {
        int comparePrice = ((Action) compareAction).getItems().getPrice();
        return comparePrice - this.items.getPrice();
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

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", actionType='" + actionType + '\'' +
                ", items=" + items +
                ", spell=" + spell +
                '}';
    }
}
