package org.example.Classes;

import org.example.model.Player;

public class AssassinClass extends Player {

    private final String emoji = "🐱‍👤";
    private final int defaultDodge = 2;

    public AssassinClass() {}


    public AssassinClass(String name, Double life) {
        super(name, life);
        naturalDodge += defaultDodge;
    }

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public boolean isLive() {
        return false;
    }
}
