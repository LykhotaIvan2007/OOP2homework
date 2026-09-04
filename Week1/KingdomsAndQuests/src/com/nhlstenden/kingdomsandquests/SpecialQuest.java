package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class SpecialQuest extends Quest
{
    private List<Item> items;
    public SpecialQuest(int XP_Reward, Character enemyCharacter, int difficulty)
    {
        super(XP_Reward, enemyCharacter, difficulty);
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItems(List<Item> items)
    {
        this.items.addAll(items);
    }

    public void addItem(Item item)
    {
        this.items.add(item);
    }

    @Override
    public void giveRewards(Player player) {
        super.giveRewards(player);
        player.addItems(this.items);
    }
}
