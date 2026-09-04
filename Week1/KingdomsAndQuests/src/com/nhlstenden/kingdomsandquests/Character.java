package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public abstract class Character
{
    private List<Attribute> attributes;
    private List<Ability> abilities;
    private double heals;
    private double damageValue;
    private  double defenceValue;

    public Character(double heals, double damageValue, double defenceValue)
    {
        this.abilities = new ArrayList<>();
        this.attributes = new ArrayList<>();
        this.heals = heals;
        this.damageValue = damageValue;
        this.defenceValue = defenceValue;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public double getHeals() {
        return heals;
    }

    public void setHeals(double heals) {
        this.heals = heals;
    }

    public double getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(double damageValue) {
        this.damageValue = damageValue;
    }

    public double getDefenceValue() {
        return defenceValue;
    }

    public void setDefenceValue(double defenceValue) {
        this.defenceValue = defenceValue;
    }

    public double attack(double modifier)
    {
        return this.damageValue * modifier;
    }

    public double defend(double modifier)
    {
        return this.defenceValue * modifier;
    }

    public abstract void useSpecialAbility();
}
