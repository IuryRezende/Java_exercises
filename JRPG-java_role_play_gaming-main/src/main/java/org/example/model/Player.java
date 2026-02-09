package org.example.model;

import org.example.Interface.Combatent;

public abstract class Player implements Combatent {
    protected String name;
    protected int life;
    protected int defense;
    protected int dodge;
    protected int mana;
    private Combatent combatent;

    public Player() {}

    public Player(String name, int life) {
        this.name = name;
        this.life += life;
    }

    public double getLife() { return life; }

    public void setLife(int life) { this.life = life; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getDefense() { return defense; }

    public void setDefense(int defense) { this.defense = defense; }

    public int getDodge() { return dodge; }

    public void setDodge(int dodge) { this.dodge = dodge; }

    public int getMana() { return mana; }

    public void setMana(int mana) { this.mana = mana; }

    @Override
    public void takeDamage(int damage) {
        life -= damage;
    }

    public void attack(Combatent target){}

    public void defense(){}

    public void dodge(){}

    @Override
    public boolean isLive(){ return life > 0; }
}
