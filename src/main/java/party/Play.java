package party;

import models.Action;
import models.Inventory;

import java.util.List;
import java.util.stream.Collectors;

public class Play {

    public static String play(List<Action> actionList, Inventory inventory) {
        Action orderToMake = MakeOrder.takeBestOrderToMake(actionList.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList()));
        if(MakeOrder.enoughIngredientsInInventory(inventory, orderToMake)) {
            return "BEW " + String.valueOf(orderToMake.getId());
        } else {
            return "CAST" + Cast.makeInventory(inventory, orderToMake, actionList.stream().filter(f -> f.getActionType().equals("CAST")).collect(Collectors.toList()));
        }
    }
}
