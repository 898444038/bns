package com.ming.bns.admin.utils.luck.luck1;

import com.ming.bns.admin.utils.consoletable.ConsoleTable;
import com.ming.bns.admin.utils.consoletable.enums.Align;
import com.ming.bns.admin.utils.consoletable.table.Cell;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AwardGroup {

    private List<Award> awardgroup;
    private boolean isAutoReduce; // 是否自动减少数量
    private int total = 0; // 总权数

    public int getTotal() {
        return total;
    }

    public AwardGroup() {
        awardgroup = new ArrayList<Award>();
    }

    public boolean addAward(Award award) {
        total += award.getWeight();
        return awardgroup.add(award);
    }

    public boolean remove(Award award) {
        total -=  award.getWeight();
        return awardgroup.remove(award);
    }

    public List<Award> getAwardgroup() {
        return awardgroup;
    }

    public void setAwardgroup(List<Award> awardgroup) {
        this.awardgroup = awardgroup;
        total = 0;
        for (Award award : awardgroup) {
            total += award.getWeight();
        }
    }

    public boolean isAutoReduce() {
        return isAutoReduce;
    }

    public void setAutoReduce(boolean isAutoReduce) {
        this.isAutoReduce = isAutoReduce;
    }

    public synchronized Award startGetAward() {
        if (awardgroup == null || total <= 0) {
            return null;
        }
        Random random = new Random();
        int awardNUmber = random.nextInt(total);
        for (Award award : awardgroup) {
            if (awardNUmber + 1 - award.getWeight() > 0) {
                awardNUmber -= award.getWeight();
                continue;
            }
            if (isAutoReduce) {
                award.reduceWeight(1);
                total -= 1;
            }
            Award award1 = new Award();
            BeanUtils.copyProperties(award, award1);
            return award1;
        }
        return null;
    }

}
