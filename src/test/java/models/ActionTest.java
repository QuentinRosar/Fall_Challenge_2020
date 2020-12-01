package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import party.Cast;

public class ActionTest {
    @Test
    public void testConstructor() {
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", (new Action()).toString());
    }

    @Test
    public void testConstructor2() {
        Action actualAction = new Action(Cast.takeBestOrderToMake(new ArrayList<Action>()));
        assertEquals(0, actualAction.getId());
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", actualAction.toString());
        assertNull(actualAction.getActionType());
    }

    @Test
    public void testConstructor3() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        takeBestOrderToMakeResult.setActionType("Action Type");
        Action actualAction = new Action(takeBestOrderToMakeResult);
        assertEquals(0, actualAction.getId());
        assertEquals("Action{id=0, actionType='Action Type', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", actualAction.toString());
        assertEquals("Action Type", actualAction.getActionType());
    }

    @Test
    public void testCompareTo() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        assertEquals(0, takeBestOrderToMakeResult.compareTo(Cast.takeBestOrderToMake(new ArrayList<Action>())));
    }

    @Test
    public void testSetId() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        takeBestOrderToMakeResult.setId(1);
        assertEquals(1, takeBestOrderToMakeResult.getId());
    }

    @Test
    public void testSetActionType() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        takeBestOrderToMakeResult.setActionType("Action Type");
        assertEquals("Action Type", takeBestOrderToMakeResult.getActionType());
    }

    @Test
    public void testSetItems() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        takeBestOrderToMakeResult.setItems(new Items());
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", takeBestOrderToMakeResult.toString());
    }

    @Test
    public void testSetSpell() {
        Action takeBestOrderToMakeResult = Cast.takeBestOrderToMake(new ArrayList<Action>());
        takeBestOrderToMakeResult.setSpell(new Spell());
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", takeBestOrderToMakeResult.toString());
    }

    @Test
    public void testToString() {
        assertEquals("Action{id=0, actionType='null', items=Order{delta0=0, delta1=0, delta2=0, delta3=0, price=0},"
                + " spell=Spell{castable=false}}", Cast.takeBestOrderToMake(new ArrayList<Action>()).toString());
    }
}

