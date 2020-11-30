package party;

import models.Action;
import models.Inventory;
import models.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cast {

    public static String operationForMakeBrew(List<Action> brews, List<Action> spells, Inventory inventory) {
        if(enoughItemsForBrew(inventory, brews)) {
            return makeBrew(brews, inventory);
        } else if(castableAndEnoughItemsForSpell(spells, inventory)
                && sizeInventory(inventory) <= 10) {
            return launchSpellOrRest(spells, inventory, brews);
        } else if(sizeInventory(inventory) > 8) {
            return launchSpellBaseOrRest(spells, inventory);
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

    private static boolean castableAndEnoughItemsForSpell(List<Action> spells, Inventory inventory) {
        boolean result = false;

        for(Action cast : spells) {
            if(cast.getSpell().isCastable() && enoughItemForSpell(inventory, cast)) {
                result = true;
            }
        }

        return  result;
    }

    private static String launchSpellOrRest(List<Action> spells, Inventory inventory, List<Action> brews) {
        List<Action> spellCastable = spells.stream().filter(cast -> cast.getSpell().isCastable()).collect(Collectors.toList());
        Action bestAction = takeBestOrderToMake(brews);

        for(Action spell : spellCastable) {
            if(enoughItemForSpell(inventory, spell)
                    && enoughPlaceInventoryForSPell(inventory, spell)) {
                bestAction = spell;
            }
        }

        if(bestAction.getId() > 0) {
            return "CAST " + String.valueOf(bestAction.getId());
        } else {
            return "REST";
        }
    }

    private static boolean enoughItemForSpell(Inventory inventory, Action spell) {
        return inventory.getInv0() + spell.getItems().getDelta0() >= 0
                && inventory.getInv1() + spell.getItems().getDelta1() >= 0
                && inventory.getInv2() + spell.getItems().getDelta2() >= 0
                && inventory.getInv3() + spell.getItems().getDelta3() >= 0;
    }

    private static boolean enoughPlaceInventoryForSPell(Inventory inventory, Action spell) {
        int sumInventory = sizeInventory(inventory);
        int sumCast = spell.getItems().getDelta0() + spell.getItems().getDelta1() + spell.getItems().getDelta2() + spell.getItems().getDelta3();

        return (sumInventory + sumCast) < 10;
    }

    private static int sizeInventory(Inventory inventory) {
        return inventory.getInv0() + inventory.getInv1() + inventory.getInv2() + inventory.getInv3();
    }

    private static boolean bestAction(Items itemsMiss, Action spell, Action bestAction) {
        boolean item0 = spell.getItems().getDelta0() > bestAction.getItems().getDelta0();
        boolean item1 = spell.getItems().getDelta1() > bestAction.getItems().getDelta1();
        boolean item2 = spell.getItems().getDelta2() > bestAction.getItems().getDelta2();
        boolean item3 = spell.getItems().getDelta3() > bestAction.getItems().getDelta3();

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

    private static String launchSpellBaseOrRest(List<Action> spells, Inventory inventory) {
        List<Action> spellBase = makeSpellsBase(spells);
        Action bestAction = new Action();

        for(Action cast : spellBase) {
            if(cast.getSpell().isCastable() && enoughItemForSpell(inventory, cast)) {
                bestAction = cast;
            }
        }
        if(bestAction.getId() > 0) {
            return "CAST " + String.valueOf(bestAction.getId());
        } else {
            return "REST";
        }
    }

    private static List<Action> makeSpellsBase(List<Action> spell) {
        List<Action> spellBase = new ArrayList<>();

        for(Action cast : spell) {
            if(cast.getId() == 78
                    || cast.getId() == 79
                    || cast.getId() == 80
                    ||cast.getId() == 81) {
                spellBase.add(cast);
            }
        }

        return spellBase;
    }

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
