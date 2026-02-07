package org.example.Classes;

import org.example.model.HumanModel;

public class AssassinClass extends HumanModel {

    private final String emoji = "🐱‍👤";
    private final int defaultDodge = 2;
    private int dodge;

    public AssassinClass() {}


    public AssassinClass(String name, Double life, int naturalDefense, int dodge) {
        super(name, life, naturalDefense);
        this.dodge = dodge + defaultDodge;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
}
