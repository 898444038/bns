package com.ming.bns.admin.utils.luck.luck1;

public class Award {
    public Award() {

    }
    public Award(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public Award(String name, int weight, int money) {
        this.name = name;
        this.weight = weight;
        this.money = money;
    }

    private String name; // 奖品名称
    private int weight; // 奖品权重
    private int money; // 奖品价值
    private String index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void reduceWeight(int reduce) {
        if (weight - reduce < 0) {
            weight = 0;
        } else {
            weight -= reduce;
        }
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "恭喜您获得奖品 " + name;
    }
}
