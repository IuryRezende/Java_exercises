package org.example.Armory;


public enum MageSpellsEnum {
    KATCHAU(40, 50, "⚡"),
    FIREBALL(25, 20, "🔥"),
    FREEZE(10, 30, "❄");

    private int damage;
    private int manaCost;
    private String emoji;

    MageSpellsEnum(int damage, int manaCost, String emoji){
        this.damage = damage;
        this.manaCost = manaCost;
        this.emoji = emoji;

    }

    public double getDamage(){
        return damage;
    }



}
