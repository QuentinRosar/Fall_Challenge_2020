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
            calc += Math.abs(action.getItems().getDelta0()) * 1;
            calc += Math.abs(action.getItems().getDelta1()) * 2;
            calc += Math.abs(action.getItems().getDelta2()) * 3;
            calc += Math.abs(action.getItems().getDelta3()) *4;
            calc /= action.getItems().getPrice();

            if(calc > actionScore) {
                actionScore = calc;
                resultBestActionOrder = action;
            }
        }
        return resultBestActionOrder;
    }
}
