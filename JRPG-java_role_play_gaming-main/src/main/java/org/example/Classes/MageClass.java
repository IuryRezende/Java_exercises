package org.example.Classes;


import org.example.Armory.MageSpellsEnum;
import org.example.Interface.Combatent;
import org.example.model.Player;

import java.util.*;


public class MageClass extends Player {

    private int intelligence;
    private int mana = 100;
    private final List<MageSpellsEnum> spellsList = new ArrayList<>(Arrays.asList(MageSpellsEnum.values()));

    private int calcDamage(int damage, int enemyDefense){ return enemyDefense >= damage ? 0 : damage - enemyDefense; };

    private boolean checkIfHasMana(int manaCost){ return mana >= manaCost; }


    public void attack(int numOfSpell, Player player){
        Map<String, String> spell = Map.of(
                "name", spellsList.get(numOfSpell - 1).name(),
                "emoji", spellsList.get(numOfSpell - 1).getEmoji(),
                "manaCost", String.valueOf(spellsList.get(numOfSpell - 1).getManaCost()),
                "damage", String.valueOf(spellsList.get(numOfSpell - 1).getDamage())
        );

        try {
            if (!checkIfHasMana(Integer.parseInt(spell.get("manaCost")))){
                throw new RuntimeException("Not enough mana to conjure this spell❌");
            }
            int damage = calcDamage(Integer.parseInt(spell.get("damage")), player.getDefense());
            player.takeDamage(damage);
            System.out.println("\n=============================================\n"
                    + this.getName()
                    + " conjured "
                    + spell.get("name")
                    + " "
                    + spell.get("emoji")
                    + "\n"
                    + player.getName()
                    + " suffered: "
                    + damage
                    + " points of damage"
                    + "\n=============================================\n");
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    public MageClass(){};


    public MageClass(String name, int life, int intelligence, int mana) {
        super(name, life);
        this.intelligence = intelligence;
        this.mana += mana;
    }

    public int getIntelligence() { return intelligence; }

    public void setIntelligence(int intelligence) { this.intelligence = intelligence; }

    @Override
    public int getMana() { return mana; }

    public void setMana(int mana) { this.mana = mana; }

    @Override
    public boolean isLive() { return life <= 0; }


    public String getSheet(){
        String title = name + " Sheet";

        StringBuilder sbSheet = new StringBuilder();
        StringBuilder sbSpells = new StringBuilder();

        for (MageSpellsEnum s : spellsList){
            sbSpells.append(s.name()).append(" ");
        }

        int width = sbSpells.length() + 12;
        int padding = (width - title.length())/2;

        sbSheet.append("=".repeat(width)).append("\n")
                .append(" ".repeat(padding)).append(title).append(" ".repeat(padding)).append("\n")
                .append("=".repeat(width)).append("\n")
                .append(String.format("| %-" + (width - 4) + "s |%n", "Life: " + life))
                .append(String.format("| %-" + (width - 4) + "s |%n", "Defense: " + defense))
                .append(String.format("| %-" + (width - 4) + "s |%n", "Dodge: " + dodge))
                .append(String.format("| %-" + (width - 4) + "s |%n", "Mana: " + mana))
                .append(String.format("| %-" + (width - 4) + "s |%n", "Spells: " + sbSpells))
                .append("=".repeat(width));

        return sbSheet.toString();

    }
}
