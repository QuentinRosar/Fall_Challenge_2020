package party;

import models.Action;
import models.Inventory;

import java.util.List;
import java.util.stream.Collectors;

public class Play {

    public static String play(List<Action> actionList, Inventory inventory) {
        List<Action> brews = actionList.stream().filter(f -> f.getActionType().equals("BREW")).collect(Collectors.toList());
        List<Action> spells = actionList.stream().filter(f -> f.getActionType().equals("CAST")).collect(Collectors.toList());

       return Cast.operationForMakeBrew(brews, spells, inventory);
    }
}
