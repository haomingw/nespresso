package com.nespresso.sofa.recruitement.tournament;

public class Highlander extends Warrior {
    private static final int initialHealth = 150;

    Highlander() {
        super(initialHealth, new GreatSword());
    }

    Highlander(String status) {
        this();
        setStatus(status);
    }

    @Override
    Warrior equip(String name) {
        wear(name);
        return this;
    }

    @Override
    int applyAdditionalDamage(int damage) {
        if (hasStatus() && getStatus().equals("Veteran") && hitPoints() <= 0.3 * initialHealth)
            damage *= 2;
        return damage;
    }

}
