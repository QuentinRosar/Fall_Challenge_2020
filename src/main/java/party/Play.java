package party;

import models.Action;
import models.Inventory;
import models.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Play {

    public static String play(List<Action> actionList, Inventory inventory) {
        List<Action> brews = actionList.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList());
        List<Action> casts = actionList.stream().filter(f -> f.getActionType().equals("CAST")).collect(Collectors.toList());

       return Cast.operationForMakeOrder(brews, casts, inventory);
    }
}
