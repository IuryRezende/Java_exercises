package org.example.model;

public interface Combatent {

    void takeDamage(int damage);
    void attack(Combatent target);
    void dodge();
    void defense();
    boolean isLive();
}
