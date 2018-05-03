package com.nespresso.sofa.recruitement.tournament;

public class GreatSword extends Weapon {
    private int hit = 0;

    GreatSword() {
        super(12);
    }

    @Override
    public boolean canBreakBuckler() {
        return false;
    }

    @Override
    public boolean readyToHit() {
        hit++;
        return hit % 3 != 0;
    }
}
