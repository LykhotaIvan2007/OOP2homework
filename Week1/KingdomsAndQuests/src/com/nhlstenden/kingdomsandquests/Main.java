package com.nhlstenden.kingdomsandquests;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Character enemy = new Mage(10,10,10);
        Quest quest = new Quest(10, enemy, 0);
        Quest quest1 = new Quest(20, enemy, 2222220);
        SpecialQuest specialQuest = new SpecialQuest(30, enemy, 13);
        Character warrior = new Warrior(1488, 1488, 228);
        Player player = new Player(warrior, 100000);
        PlayQuest playQuest = new PlayQuest(player);
        playQuest.addQuest(quest);
        playQuest.addQuest(quest1);
        playQuest.addQuest(specialQuest);
        Item item = new Item("Первый");
        Item item1 = new Item("Снюс");
        specialQuest.addItem(item);
        specialQuest.addItem(item1);
        for (Quest quest2: playQuest.showAvailableQuests())
        {
            System.out.println(quest2.getDifficulty());
        }
        playQuest.startQuest(specialQuest);
        for (Item item3: player.getItems())
        {
            System.out.println(item3.getName());
        }
    }
}