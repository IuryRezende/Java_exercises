package org.example.Classes;


import org.example.Armory.MageSpellsEnum;
import org.example.Interface.Combatent;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MageClass extends Player {


    private final String emoji = "🧙‍♂️";
    private int intelligence;
    private double mana = 100;
    private final List<MageSpellsEnum> spellsList = new ArrayList<>(Arrays.asList(MageSpellsEnum.values()));

    private int calcDamage(int damage, int enemyDefense){
        return enemyDefense >= damage ? 0 : damage - enemyDefense;
    };


    public void attack(int numOfspell, Player player){
        String spellName = spellsList.get(numOfspell - 1).name();
        String spellEmoji = spellsList.get(numOfspell - 1).getEmoji();
        int damage = calcDamage(spellsList.get(numOfspell - 1).getDamage() ,player.getDefense());
        player.takeDamage(damage);
        System.out.println("\n ======================== \n"
                + this.getName()
                + " conjured "
                + spellName
                + " "
                + spellEmoji
                + "\n"
                + player.getName()
                + " suffered: "
                + damage
                + "points of damage"
                + "\n ======================== \n");
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public boolean isLive() {
        return false;
    }
}
