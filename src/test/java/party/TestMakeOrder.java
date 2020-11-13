package party;

import models.Action;
import models.Inventory;
import models.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestMakeOrder {

    @Test
    public void enoughIngredientsInInventory() {
        Inventory inventory = new Inventory(3, 4, 1, 0, 5);
        Order order = new Order(1,2,0,0,10);
        Action action = new Action(75, "BREW", order);
        Assertions.assertEquals(true, MakeOrder.enoughIngredientsInInventory(inventory, action));
    }

    @Test
    public void notEnoughIngredientsInInventory() {
        Inventory inventory = new Inventory(2, 7, 2, 0, 5);
        Order order = new Order(5,2,0,0,10);
        Action action = new Action(75, "BREW", order);
        Assertions.assertEquals(false, MakeOrder.enoughIngredientsInInventory(inventory, action));
    }

}
