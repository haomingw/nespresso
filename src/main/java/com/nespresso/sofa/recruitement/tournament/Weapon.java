package com.nespresso.sofa.recruitement.tournament;

public abstract class Weapon {
    private int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public static Weapon getWeapon(String name) {
        switch (name) {
            case "axe":
                return new Axe();
            case "sword":
                return new Sword();
            case "greatsword":
                return new GreatSword();
        }
        return null;
    }

    public abstract boolean canBreakBuckler();

    public abstract boolean readyToHit();

    public int getDamage() {
        return damage;
    }
}
