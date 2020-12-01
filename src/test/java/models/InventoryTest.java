package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InventoryTest {
    @Test
    public void testSetInv0() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        inventory.setInv0(1);
        assertEquals(1, inventory.getInv0());
    }

    @Test
    public void testSetInv1() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        inventory.setInv1(1);
        assertEquals(1, inventory.getInv1());
    }

    @Test
    public void testSetInv2() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        inventory.setInv2(1);
        assertEquals(1, inventory.getInv2());
    }

    @Test
    public void testSetInv3() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        inventory.setInv3(1);
        assertEquals(1, inventory.getInv3());
    }

    @Test
    public void testSetScore() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        inventory.setScore(3);
        assertEquals(3, inventory.getScore());
    }

    @Test
    public void testToString() {
        assertEquals("Inventory{inv0=1, inv1=1, inv2=1, inv3=1, score=3}", (new Inventory(1, 1, 1, 1, 3)).toString());
    }
}

