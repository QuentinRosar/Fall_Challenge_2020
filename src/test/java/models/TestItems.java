package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestItems {

    @Test
    public void createOrder() {
        Items items = new Items(-1, 0, -2, -3, 10);
        Assertions.assertEquals(1, items.getDelta0());
        Assertions.assertEquals(0, items.getDelta1());
        Assertions.assertEquals(2, items.getDelta2());
        Assertions.assertEquals(3, items.getDelta3());
        Assertions.assertEquals(10, items.getPrice());
    }
}
