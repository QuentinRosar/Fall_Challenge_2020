package party;

import models.Action;
import models.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Play {

    public static String play(List<Action> actionList, Inventory inventory) {
        List<Action> brews = actionList.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList());
        List<Action> casts = new ArrayList<>();
        List<Action> learns = new ArrayList<>();



        Action orderToMake = MakeOrder.takeBestOrderToMake(actionList.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList()));
        if(MakeOrder.enoughIngredientsInInventory(inventory, orderToMake)) {
            return "BEW " + String.valueOf(orderToMake.getId());
        } else {
            return "CAST" + Cast.makeInventory(inventory, orderToMake, actionList.stream().filter(f -> f.getActionType().equals("CAST")).collect(Collectors.toList()));
        }
    }

    private List<Action> makeBrews(List<Action> actions) {
        List<Action> brews = new ArrayList<>();
        actions.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList());
        return brews;
    }
}
