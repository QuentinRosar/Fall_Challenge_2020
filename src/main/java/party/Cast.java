package party;

import models.Action;
import models.Inventory;

import java.util.List;

public class Cast {

    public static String makeInventory(Inventory inventory, Action order, List<Action> casts) {
        if(inventory.getInv3() <= order.getItems().getDelta3()
                && inventory.getInv2() > 0
                && casts.get(3).getSpell().isCastable()) {
            return  "CAST " + String.valueOf(casts.get(3).getId());
        } else if(inventory.getInv2() <= order.getItems().getDelta2()
                && inventory.getInv1() > 0
                && casts.get(2).getSpell().isCastable()) {
            return  "CAST " + String.valueOf(casts.get(2).getId());
        } else if(inventory.getInv1() <= order.getItems().getDelta1()
                && inventory.getInv0() > 0
                && casts.get(1).getSpell().isCastable()) {
            return  "CAST " + String.valueOf(casts.get(1).getId());
        } else if(inventory.getInv0() <= order.getItems().getDelta0()
                && casts.get(0).getSpell().isCastable()) {
            return  "CAST " + String.valueOf(casts.get(0).getId());
        } else {
            return "REST";
        }
    }
}
