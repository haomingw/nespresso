package com.nespresso.sofa.recruitement.tournament;

public class Armor {
    private static final int reduceDamageReceivedBy = 3;
    private static final int reduceDamageGivenBy = 1;

    public int reduceDamageReceived(int damage) {
        return damage - reduceDamageReceivedBy;
    }

    public int reduceDamageGiven(int damage) {
        return damage - reduceDamageGivenBy;
    }

}
