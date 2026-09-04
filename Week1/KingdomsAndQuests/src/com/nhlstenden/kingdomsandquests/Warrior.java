package com.nhlstenden.kingdomsandquests;

public class Warrior extends Character
{
    public Warrior(double heals, double damageValue, double defenceValue) {
        super(heals, damageValue, defenceValue);
    }

    @Override
    public void useSpecialAbility() {
        this.setDamageValue(this.getDamageValue() * 3);
    }
}
