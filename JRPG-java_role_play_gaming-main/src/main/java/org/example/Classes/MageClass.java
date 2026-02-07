package org.example.Classes;


import org.example.Armory.MageSpellsEnum;
import org.example.model.HumanModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MageClass extends HumanModel {
    private final String emoji = "🧙‍♂️";
    private int intelligence;
    private double mana = 100;
    private List<MageSpellsEnum> spellsList = new ArrayList<>(Arrays.asList(MageSpellsEnum.values()));


    public String test(int indexOfSpell){
        return String.valueOf(spellsList.get(indexOfSpell).getDamage());
    }
}
