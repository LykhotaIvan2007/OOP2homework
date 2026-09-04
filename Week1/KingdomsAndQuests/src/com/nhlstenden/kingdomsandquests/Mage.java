package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    public Mage(double heals, double damageValue, double defenceValue)
    {
        super(heals, damageValue, defenceValue);
    }

    @Override
    public void useSpecialAbility()
    {
        this.setDefenceValue(this.getDefenceValue() * 2);
    }
}
