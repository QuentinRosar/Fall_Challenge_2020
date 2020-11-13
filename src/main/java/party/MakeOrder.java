package party;

import models.Action;
import models.Inventory;

import java.util.List;

public class MakeOrder {

    public static String toMakeCommandBestPrice(List<Action> actions, Inventory inventory) {
        actions.sort(Action::compareTo);

        for(Action action : actions) {
            if(enoughIngredientsInInventory(inventory,action)) {
                return  String.valueOf(action.getId());
            }
        }
        return String.valueOf(0);
    }

    public static boolean enoughIngredientsInInventory(Inventory inventory, Action action) {
        boolean ingredient0IsOk = inventory.getInv0() >= action.getOrder().getDelta0();
        boolean ingredient1IsOk = inventory.getInv1() >= action.getOrder().getDelta1();
        boolean ingredient2IsOk = inventory.getInv2() >= action.getOrder().getDelta2();
        boolean ingredient3IsOK = inventory.getInv3() >= action.getOrder().getDelta3();

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
