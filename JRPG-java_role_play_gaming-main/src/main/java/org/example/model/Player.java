package org.example.model;

public abstract class Player implements Combatent {
    protected String name;
    protected int life;
    protected int naturalDefense;
    protected int naturalDodge;
    protected int naturalMana;
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

    public int getNaturalDefense() { return naturalDefense; }

    public void setNaturalDefense(int naturalDefense) { this.naturalDefense = naturalDefense; }

    public int getNaturalDodge() { return naturalDodge; }

    public void setNaturalDodge(int naturalDodge) { this.naturalDodge = naturalDodge; }

    public int getNaturalMana() { return naturalMana; }

    public void setNaturalMana(int naturalMana) { this.naturalMana = naturalMana; }

    @Override
    public void takeDamage(int damage) { life -= damage; }

    public void attack(Combatent target){}

    public void defense(){}

    public void dodge(){}

    @Override
    public boolean isLive(){ return life > 0; }
}
