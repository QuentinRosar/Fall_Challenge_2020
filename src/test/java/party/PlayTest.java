package party;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import models.Action;
import models.Inventory;
import models.Items;
import models.Spell;
import org.junit.jupiter.api.Test;

public class PlayTest {
    @Test
    public void testPlay() {
        Inventory inventory = new Inventory(1, 1, 1, 1, 3);
        assertEquals("REST", Play.play(new ArrayList<Action>(), inventory));
    }

    @Test
    public void testPlay2() {
        Items order = new Items();
        Action e = new Action(1, "Action Type", order, new Spell());
        ArrayList<Action> actionList = new ArrayList<Action>();
        actionList.add(e);
        assertEquals("REST", Play.play(actionList, new Inventory(1, 1, 1, 1, 3)));
    }
}

