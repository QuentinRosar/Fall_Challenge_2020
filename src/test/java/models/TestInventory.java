package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestInventory {

    @Test
    public void createInventory() {
        Inventory inventory = new Inventory(3, 2, 1, 0, 5);
        Assertions.assertEquals(3, inventory.getInv0());
        Assertions.assertEquals(2, inventory.getInv1());
        Assertions.assertEquals(1, inventory.getInv2());
        Assertions.assertEquals(0, inventory.getInv3());
        Assertions.assertEquals(5, inventory.getScore());
    }
}
