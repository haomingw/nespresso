package com.nespresso.sofa.recruitement.tournament;

public abstract class Warrior {
    private int health;

    private Weapon weapon;

    private Buckler buckler;

    private Armor armor;

    private String status;

    private int hit = 0;

    Warrior(int health, Weapon weapon) {
        this.health = health;
        this.weapon = weapon;
    }

    private void sufferDamage(int damage) {
        health -= damage;
        health = Math.max(health, 0);
    }

    private void hit(Warrior victim) {
        hit++;
        if (victim.canBlock())
            victim.getBuckler().block(this);
        else
            victim.sufferDamage(victim.getSufferedDamage(this));
    }

    private int getGivenDamage() {
        int damage = weapon.getDamage();
        damage = applyAdditionalDamage(damage);
        if (hasArmor())
            damage = armor.reduceDamageGiven(damage);
        return damage;

    }

    private int getSufferedDamage(Warrior attacker) {
        int damage = attacker.getGivenDamage();
        if (hasArmor())
            damage = armor.reduceDamageReceived(damage);
        return damage;
    }

    private void blow(Warrior victim) {
        if (weapon.readyToHit())
            hit(victim);
    }

    public void engage(Warrior opponent) {
        while (true) {
            blow(opponent);
            if (opponent.isDead()) break;
            opponent.blow(this);
            if (isDead()) break;
        }
    }

    abstract Warrior equip(String name);

    abstract int applyAdditionalDamage(int damage);

    protected void wear(String equipment) {
        Weapon weapon = Weapon.getWeapon(equipment);
        if (weapon != null) this.weapon = weapon;
        else if (equipment.equals("buckler")) buckler = new Buckler(this);
        else if (equipment.equals("armor")) armor = new Armor();
    }

    private boolean canBlock() {
        return hasBuckler() && buckler.canBlock();
    }

    private boolean hasBuckler() {
        return buckler != null;
    }

    private boolean hasArmor() {
        return armor != null;
    }

    protected boolean hasStatus() {
        return status != null;
    }

    private boolean isDead() {
        return health == 0;
    }

    public int hitPoints() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Buckler getBuckler() {
        return buckler;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHit() {
        return hit;
    }

    public void setBuckler(Buckler buckler) {
        this.buckler = buckler;
    }

}
