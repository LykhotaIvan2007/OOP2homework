package com.nhlstenden.kingdomsandquests;

public class Quest
{
    private int XP_Reward;
    private Character enemyCharacter;
    private int difficulty;

    public Quest(int XP_Reward, Character enemyCharacter, int difficulty)
    {
        this.XP_Reward = XP_Reward;
        this.enemyCharacter = enemyCharacter;
        this.difficulty = difficulty;
    }

    public int getXP_Reward() {
        return XP_Reward;
    }

    public void setXP_Reward(int XP_Reward) {
        this.XP_Reward = XP_Reward;
    }

    public Character getEnemyCharacter() {
        return enemyCharacter;
    }

    public void setEnemyCharacter(Character enemyCharacter) {
        this.enemyCharacter = enemyCharacter;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean methodWhichShowsFight(Character character)
    {
        return Math.random() < 0.5;
    }

    public void giveRewards(Player player)
    {
        player.earnXP(this.getXP_Reward());
    }
}
