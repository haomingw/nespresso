package com.nespresso.sofa.recruitement.tournament;

public class Swordsman extends Warrior {
    Swordsman() {
        super(100, new Sword());
    }

    Swordsman(String status) {
        this();
        setStatus(status);
    }

    @Override
    Swordsman equip(String name) {
        wear(name);
        return this;
    }

    @Override
    int applyAdditionalDamage(int damage) {
        if (hasStatus() && getStatus().equals("Vicious") && getHit() <= 2)
            damage += 20;
        return damage;
    }
}
