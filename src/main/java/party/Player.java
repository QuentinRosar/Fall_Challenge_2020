package party;

import models.Action;
import models.Inventory;
import models.Items;
import models.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {

    public static String main(String[] args) {
        final Scanner in = new Scanner(System.in);

        final List<Action> actions = new ArrayList<Action>();
        final List<Inventory> inventories = new ArrayList<Inventory>();
        int firstRounds = 1;

        // game loop
        while (true) {
            actions.clear();
            inventories.clear();

            final int actionCount = in.nextInt(); // the number of spells and recipes in play
            for (int i = 0; i < actionCount; i++) {
                final int actionId = in.nextInt(); // the unique ID of this spell or recipe
                final String actionType = in.next(); // in the first league: BREW; later: CAST, OPPONENT_CAST, LEARN, BREW
                final int delta0 = in.nextInt(); // tier-0 ingredient change
                final int delta1 = in.nextInt(); // tier-1 ingredient change
                final int delta2 = in.nextInt(); // tier-2 ingredient change
                final int delta3 = in.nextInt(); // tier-3 ingredient change
                final int price = in.nextInt(); // the price in rupees if this is a potion
                final int tomeIndex = in.nextInt(); // in the first two leagues: always 0; later: the index in the tome if this is a tome spell, equal to the read-ahead tax
                final int taxCount = in.nextInt(); // in the first two leagues: always 0; later: the amount of taxed tier-0 ingredients you gain from learning this spell
                final boolean castable = in.nextInt() != 0; // in the first league: always 0; later: 1 if this is a castable player spell
                final boolean repeatable = in.nextInt() != 0; // for the first two leagues: always 0; later: 1 if this is a repeatable player spell

                actions.add(new Action(actionId, actionType,
                            new Items(delta0, delta1, delta2, delta3, price),
                            new Spell(castable, tomeIndex, taxCount, repeatable)));
            }
            for (int i = 0; i < 2; i++) {
                final int inv0 = in.nextInt(); // tier-0 ingredients in inventory
                final int inv1 = in.nextInt();
                final int inv2 = in.nextInt();
                final int inv3 = in.nextInt();
                final int score = in.nextInt(); // amount of rupees

                inventories.add(new Inventory(inv0, inv1, inv2, inv3, score));
            }

            // in the first league: BREW <id> | WAIT; later: BREW <id> | CAST <id> [<times>] | LEARN <id> | REST | WAIT
            if(firstRounds <= 10) {
                List<Action> learn = actions.stream().filter(f -> f.getActionType().equals("LEARN")).collect(Collectors.toList());
                firstRounds++;
                System.out.println("LEARN " + String.valueOf(learn.get(0).getId())) ;
            } else {
                System.out.println(Play.play(actions, inventories.get(0)));
            }
        }
    }



}

