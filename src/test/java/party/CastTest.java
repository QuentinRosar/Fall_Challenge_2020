package party;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import models.Action;
import models.Inventory;
import org.junit.jupiter.api.Test;

public class CastTest {
    @Test
    public void testOperationForMakeBrew() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        ArrayList<Action> brews = new ArrayList<Action>();
        assertEquals("REST", Cast.operationForMakeBrew(brews, new ArrayList<Action>(), inventory));
    }

    @Test
    public void testOperationForMakeBrew2() {
        Action e = Cast.takeBestOrderToMake(new ArrayList<Action>());
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(e);
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        assertEquals("BREW 0", Cast.operationForMakeBrew(actionList, new ArrayList<Action>(), inventory));
    }

    @Test
    public void testOperationForMakeBrew3() {
        Action e = Cast.takeBestOrderToMake(new ArrayList<Action>());
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(e);
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        assertEquals("REST", Cast.operationForMakeBrew(new ArrayList<Action>(), actionList, inventory));
    }

    @Test
    public void testOperationForMakeBrew4() {
        Inventory inventory = new Inventory(8, 1, 1, 1, 3);
        ArrayList<Action> brews = new ArrayList<Action>();
        assertEquals("REST", Cast.operationForMakeBrew(brews, new ArrayList<Action>(), inventory));
    }

    @Test
    public void testTakeBestOrderToMake() {
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", Cast.takeBestOrderToMake(new ArrayList<Action>()).toString());
    }

    @Test
    public void testTakeBestOrderToMake2() {
        Action e = Cast.takeBestOrderToMake(new ArrayList<Action>());
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(e);
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", Cast.takeBestOrderToMake(actionList).toString());
    }
}

