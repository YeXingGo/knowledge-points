package com.zh.ioc;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/9/14  22:06
 * @版本：
 */
public class BraveKnight implements  Knight{
    private Quest quest;
    private Minstrel minstrel;

/*    public BraveKnight (Quest quest) {
        this.quest = quest;
    }*/

    public BraveKnight(Quest quest) {
        System.out.println("------BraveKnight  调用----------");
        this.quest = quest;
    }

    public BraveKnight() {
        System.out.println();
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public void setMinstrel(Minstrel minstrel) {
        this.minstrel = minstrel;
    }
    @Override
    public void embarkOnQuest() {
        quest.embark();
    }
}
