package com.nespresso.sofa.recruitement.tournament;

public class Buckler {
    private Warrior owner;

    private int hit = 0;
    private int axeHitCount = 0;

    Buckler(Warrior owner) {
        this.owner = owner;
    }

    public void block(Warrior attacker) {
        if (attacker.getWeapon().canBreakBuckler()) axeHitCount++;
        if (axeHitCount == 3) owner.setBuckler(null);
    }

    public boolean canBlock() {
        return hit++ % 2 == 0;
    }
}
