package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestOrder {

    @Test
    public void createOrder() {
        Order order = new Order(-1, 0, -2, -3, 10);
        Assertions.assertEquals(1, order.getDelta0());
        Assertions.assertEquals(0, order.getDelta1());
        Assertions.assertEquals(2, order.getDelta2());
        Assertions.assertEquals(3, order.getDelta3());
        Assertions.assertEquals(10, order.getPrice());
    }
}
