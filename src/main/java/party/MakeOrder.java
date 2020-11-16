package party;

import models.Action;
import models.Inventory;

import java.util.List;

public class MakeOrder {

    public static Action takeBestOrderToMake(List<Action> actions) {
        double actionScore = 0;
        Action resultBestActionOrder = new Action();

        for(Action action : actions) {
            double calc = 0;
            calc += action.getItems().getDelta0()*0.5;
            calc += (action.getItems().getDelta1()*2)+1;
            calc += (action.getItems().getDelta2()*3)+1;
            calc += (action.getItems().getDelta3()*4)+1;
            calc /= action.getItems().getPrice();

            if(calc > actionScore) {
                actionScore = calc;
                resultBestActionOrder = action;
            }
        }
        return resultBestActionOrder;
    }

    public static String toMakeCommandBestPrice(List<Action> actions, Inventory inventory) {
        actions.sort(Action::compareTo);

        for (Action action : actions) {
            if (enoughIngredientsInInventory(inventory, action)) {
                return String.valueOf(action.getId());
            }
        }
        return String.valueOf(0);
    }

    public static boolean enoughIngredientsInInventory(Inventory inventory, Action action) {
        boolean ingredient0IsOk = inventory.getInv0() >= action.getItems().getDelta0();
        boolean ingredient1IsOk = inventory.getInv1() >= action.getItems().getDelta1();
        boolean ingredient2IsOk = inventory.getInv2() >= action.getItems().getDelta2();
        boolean ingredient3IsOK = inventory.getInv3() >= action.getItems().getDelta3();

        return ingredient0IsOk && ingredient1IsOk && ingredient2IsOk && ingredient3IsOK;
    }

}
