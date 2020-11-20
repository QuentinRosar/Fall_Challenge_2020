package party;

import models.Action;
import models.Inventory;
import models.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cast {

    public static String operationForMakeOrder(List<Action> brews, List<Action> casts, Inventory inventory) {
        if(enoughItemsForBrew(inventory, brews)) {
            return makeBrew(brews, inventory);
        } else if(castableAndEnoughItemsForCast(casts, inventory) && sizeInventoryForCast(inventory) <= 10) {
            List<Action> spellCastable = casts.stream().filter(cast -> cast.getSpell().isCastable()).collect(Collectors.toList());
            Action bestAction = new Action();

            for(Action action : spellCastable) {
                if(enoughItemForCast(inventory, action)
                    && enoughPlaceInventory(inventory, action)) {
                    bestAction = action;
                }
            }

            if(bestAction.getId() > 0) {
                return "CAST " + String.valueOf(bestAction.getId());
            } else {
                return "REST";
            }
        } else if(sizeInventoryForCast(inventory) > 8) {
            List<Action> spellBase = makeSpellsBase(casts);
            Action bestAction = new Action();

            for(Action cast : spellBase) {
                if(cast.getSpell().isCastable() && enoughItemForCast(inventory, cast)) {
                    bestAction = cast;
                }
            }
            if(bestAction.getId() > 0) {
                return "CAST " + String.valueOf(bestAction.getId());
            } else {
                return "REST";
            }
        } else {
            return "REST";
        }
    }

    private static boolean enoughItemsForBrew(Inventory inventory, List<Action> brews) {
        boolean result = false;

        for(Action order : brews) {
            if(inventory.getInv0() + order.getItems().getDelta0() >= 0
                    && inventory.getInv1() + order.getItems().getDelta1() >= 0
                    && inventory.getInv2() + order.getItems().getDelta2() >= 0
                    && inventory.getInv3() + order.getItems().getDelta3() >= 0) {
                result = true;
            }
        }

        return result;
    }

    private static String makeBrew(List<Action> brews, Inventory inventory) {
        Action result = new Action();

        for(Action brew : brews) {
            if(inventory.getInv0() + brew.getItems().getDelta0() >= 0
                    && inventory.getInv1() + brew.getItems().getDelta1() >= 0
                    && inventory.getInv2() + brew.getItems().getDelta2() >= 0
                    && inventory.getInv3() + brew.getItems().getDelta3() >= 0) {
                result = brew;
            }
        }

        return "BREW " + String.valueOf(result.getId());
    }

    private static boolean castableAndEnoughItemsForCast(List<Action> casts, Inventory inventory) {
        boolean result = false;

        for(Action cast : casts) {
            if(cast.getSpell().isCastable() && enoughItemForCast(inventory, cast)) {
                result = true;
            }
        }

        return  result;
    }

    private static boolean enoughItemForCast(Inventory inventory, Action cast) {
        return inventory.getInv0() + cast.getItems().getDelta0() >= 0
                && inventory.getInv1() + cast.getItems().getDelta1() >= 0
                && inventory.getInv2() + cast.getItems().getDelta2() >= 0
                && inventory.getInv3() + cast.getItems().getDelta3() >= 0;
    }

    private static boolean enoughPlaceInventory(Inventory inventory, Action cast) {
        int sumInventory = sizeInventoryForCast(inventory);
        int sumCast = cast.getItems().getDelta0() + cast.getItems().getDelta1() + cast.getItems().getDelta2() + cast.getItems().getDelta3();

        return (sumInventory + sumCast) < 10;
    }

    private static int sizeInventoryForCast(Inventory inventory) {
        return inventory.getInv0() + inventory.getInv1() + inventory.getInv2() + inventory.getInv3();
    }

    private static boolean bestAction(Items itemsMiss, Action cast, Action bestAction) {
        boolean item0 = cast.getItems().getDelta0() > bestAction.getItems().getDelta0();
        boolean item1 = cast.getItems().getDelta1() > bestAction.getItems().getDelta1();
        boolean item2 = cast.getItems().getDelta2() > bestAction.getItems().getDelta2();
        boolean item3 = cast.getItems().getDelta3() > bestAction.getItems().getDelta3();

        return item0 || item1 || item2 || item3;
    }

    private static Items makeItemsMiss(Action brew, Inventory inventory) {
        Items itemsMiss = new Items();

        itemsMiss.setDelta0(brew.getItems().getDelta0() + inventory.getInv0());
        itemsMiss.setDelta1(brew.getItems().getDelta1() + inventory.getInv1());
        itemsMiss.setDelta2(brew.getItems().getDelta2() + inventory.getInv2());
        itemsMiss.setDelta3(brew.getItems().getDelta3() + inventory.getInv3());

        return itemsMiss;
    }

    private static List<Action> makeSpellsBase(List<Action> casts) {
        List<Action> spellBase = new ArrayList<>();

        for(Action cast : casts) {
            if(cast.getId() == 78
                    || cast.getId() == 79
                    || cast.getId() == 80
                    ||cast.getId() == 81) {
                spellBase.add(cast);
            }
        }

        return spellBase;
    }
}
