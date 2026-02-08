package org.example.Classes;


import org.example.Armory.MageSpellsEnum;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MageClass extends Player {
    private final String emoji = "🧙‍♂️";
    private int intelligence;
    private double mana = 100;
    private List<MageSpellsEnum> spellsList = new ArrayList<>(Arrays.asList(MageSpellsEnum.values()));


    public String attack(){

        return String.valueOf(spellsList.get(indexOfSpell).getDamage());
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public boolean isLive() {
        return false;
    }
}
