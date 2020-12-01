package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemsTest {
    @Test
    public void testConstructor() {
        Items actualItems = new Items(new Items());
        assertEquals(0, actualItems.getPrice());
        assertEquals(0, actualItems.getDelta2());
        assertEquals(0, actualItems.getDelta3());
        assertEquals(0, actualItems.getDelta0());
        assertEquals(0, actualItems.getDelta1());
    }

    @Test
    public void testConstructor2() {
        Items items = new Items();
        items.setDelta3(2);
        Items actualItems = new Items(items);
        assertEquals(0, actualItems.getPrice());
        assertEquals(0, actualItems.getDelta2());
        assertEquals(2, actualItems.getDelta3());
        assertEquals(0, actualItems.getDelta0());
        assertEquals(0, actualItems.getDelta1());
    }

    @Test
    public void testSetDelta0() {
        Items items = new Items();
        items.setDelta0(2);
        assertEquals(2, items.getDelta0());
    }

    @Test
    public void testSetDelta1() {
        Items items = new Items();
        items.setDelta1(2);
        assertEquals(2, items.getDelta1());
    }

    @Test
    public void testSetDelta2() {
        Items items = new Items();
        items.setDelta2(2);
        assertEquals(2, items.getDelta2());
    }

    @Test
    public void testSetDelta3() {
        Items items = new Items();
        items.setDelta3(2);
        assertEquals(2, items.getDelta3());
    }

    @Test
    public void testSetPrice() {
        Items items = new Items();
        items.setPrice(1);
        assertEquals(1, items.getPrice());
    }

    @Test
    public void testToString() {
        assertEquals("Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0}", (new Items()).toString());
    }
}

