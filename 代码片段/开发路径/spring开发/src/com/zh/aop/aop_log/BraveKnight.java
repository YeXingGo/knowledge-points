package com.zh.aop.aop_log;

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
