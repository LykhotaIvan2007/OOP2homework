package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private Character character;
    private int XP;
    private List<Item> items;
    private int level;

    public Player(Character character, int XP) {
        this.character = character;
        this.XP = XP;
        this.items = new ArrayList<>();
        level = 1;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void LevelUp()
    {
        if (this.getXP() >= 200)
        {
            this.setLevel(this.getLevel() + 1);
            this.setXP(this.getXP() - 200);
        }
    }

    public void addItems(List<Item> items)
    {
        this.items.addAll(items);
    }

    public void earnXP(int xp)
    {
        this.setXP(this.getXP() + xp);
    }
}
