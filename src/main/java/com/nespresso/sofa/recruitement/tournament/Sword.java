package com.nespresso.sofa.recruitement.tournament;

public class Sword extends Weapon {
    Sword() {
        super(5);
    }

    @Override
    public boolean canBreakBuckler() {
        return false;
    }

    @Override
    public boolean readyToHit() {
        return true;
    }
}
