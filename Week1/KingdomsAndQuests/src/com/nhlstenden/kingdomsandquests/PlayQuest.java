package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class PlayQuest
{
    private Player player;
    private List<Quest> quests;

    public PlayQuest(Player player)
    {
        this.player = player;
        this.quests = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public void addQuests(List<Quest> quests)
    {
        this.quests.addAll(quests);
    }

    public void addQuest(Quest quest)
    {
        this.quests.add(quest);
    }

    public List<Quest> showAvailableQuests()
    {
        List<Quest> availableQuests = new ArrayList<>();
        for (Quest quest: this.quests)
        {
            if (quest.getDifficulty() * 10 <= this.player.getXP())
            {
                availableQuests.add(quest);
            }
        }

        return availableQuests;
    }

    public void startQuest(Quest quest)
    {
        if (quest.getDifficulty() * 10 > this.player.getXP())
        {
            return;
        }

        //if (quest.methodWhichShowsFight(this.player.getCharacter()))
        //{
            quest.giveRewards(this.player);
        //}
    }
}
