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

    public static void main(final String args[]) {
        final Scanner in = new Scanner(System.in);
        final List<Action> actions = new ArrayList<Action>();
        final List<Inventory> inventories = new ArrayList<Inventory>();
        int firstRounds = 1;

        while (true) {
            actions.clear();
            inventories.clear();

            final int actionCount = in.nextInt();

            for (int i = 0; i < actionCount; i++) {
                final int actionId = in.nextInt();
                final String actionType = in.next();
                final int delta0 = in.nextInt();
                final int delta1 = in.nextInt();
                final int delta2 = in.nextInt();
                final int delta3 = in.nextInt();
                final int price = in.nextInt();
                final int tomeIndex = in.nextInt();
                final int taxCount = in.nextInt();
                final boolean castable = in.nextInt() != 0;
                final boolean repeatable = in.nextInt() != 0;

                actions.add(new Action(actionId, actionType,
                        new Items(delta0, delta1, delta2, delta3, price),
                        new Spell(castable, tomeIndex, taxCount, repeatable)));
            }

            for (int i = 0; i < 2; i++) {
                final int inv0 = in.nextInt();
                final int inv1 = in.nextInt();
                final int inv2 = in.nextInt();
                final int inv3 = in.nextInt();
                final int score = in.nextInt();

                inventories.add(new Inventory(inv0, inv1, inv2, inv3, score));
            }

            if (firstRounds <= 12) {
                List<Action> learn = actions.stream().filter(f -> f.getActionType().equals("LEARN")).collect(Collectors.toList());
                firstRounds++;
                System.out.println("LEARN " + String.valueOf(learn.get(0).getId()));
            } else {
                System.out.println(Play.play(actions, inventories.get(0)));
            }
        }
    }
}

