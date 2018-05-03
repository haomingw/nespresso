package com.nespresso.sofa.recruitement.tournament;

public class Viking extends Warrior {
    Viking() {
        super(120, new Axe());
    }

    @Override
    Viking equip(String name) {
        wear(name);
        return this;
    }

    @Override
    int applyAdditionalDamage(int damage) {
        return damage;
    }
}
