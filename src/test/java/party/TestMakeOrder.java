package party;

import models.Action;
import models.Inventory;
import models.Items;
import models.Spell;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestMakeOrder {

    @Test
    public void enoughIngredientsInInventory() {
        Inventory inventory = new Inventory(3, 4, 1, 0, 5);
        Items order = new Items(1,2,0,0,10);
        Action action = new Action(75, "BREW", order, new Spell(true));
        Assertions.assertEquals(true, MakeOrder.enoughIngredientsInInventory(inventory, action));
    }

    @Test
    public void notEnoughIngredientsInInventory() {
        Inventory inventory = new Inventory(2, 7, 2, 0, 5);
        Items order = new Items(5,2,0,0,10);
        Action action = new Action(75, "BREW", order, new Spell(false));
        Assertions.assertEquals(false, MakeOrder.enoughIngredientsInInventory(inventory, action));
    }

    @Test
    public void takeBestOrderToMake() {
        Action action = new Action();
    }

}
