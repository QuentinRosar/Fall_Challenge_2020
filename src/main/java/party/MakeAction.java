package party;

import models.Action;
import models.Inventory;

import java.util.List;

public class MakeAction {

    public static String toMakeCommandBestPrice(List<Action> actions, Inventory inventory) {
        actions.sort(Action::compareTo);

        for(Action action : actions) {
            if(enoughIndredientsInInventory(inventory,action)) {
                return  String.valueOf(action.getId());
            }
        }
        return String.valueOf(0);
    }

    public static boolean enoughIndredientsInInventory(Inventory inventory, Action action) {
        boolean ingredient0IsOk = inventory.getInv0() >= action.getDelta0();
        boolean ingredient1IsOk = inventory.getInv1() >= action.getDelta1();
        boolean ingredient2IsOk = inventory.getInv2() >= action.getDelta2();
        boolean ingredient3IsOK = inventory.getInv3() >= action.getDelta3();

        return ingredient0IsOk && ingredient1IsOk && ingredient2IsOk && ingredient3IsOK;
    }

    public static int removeActionUse(List<Action> actions, String idAction) {
        int index = -1;

        for(Action action : actions) {
            int id = Integer.valueOf(idAction);
            if(action.getId() == id) {
                return index;
            }
            index++;
        }
        return index;
    }
}
