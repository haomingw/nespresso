package com.nespresso.sofa.recruitement.tournament;

public class Axe extends Weapon {
    Axe() {
        super(6);
    }

    @Override
    public boolean canBreakBuckler() {
        return true;
    }

    @Override
    public boolean readyToHit() {
        return true;
    }
}
