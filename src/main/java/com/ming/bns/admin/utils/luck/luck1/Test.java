package com.ming.bns.admin.utils.luck.luck1;

public class Test {
    public static void main(String[] args) {
        //https://bns.qq.com/webplat/info/news_version3/1298/15027/15030/m11526/201907/821205.shtml
        AwardGroup awardGroup = new AwardGroup();
        awardGroup.setAutoReduce(false); // 是否每抽一次减少一个奖品

        awardGroup.addAward(new Award("舞台漫步", 1, 0));
        awardGroup.addAward(new Award("其他", 9999, 0));
        /*awardGroup.addAward(new Award("黄龙灵1段*1", 50, 0)); // Award 分别是 奖品名称 奖品权重（个数） 奖品价格
        awardGroup.addAward(new Award("觉醒洪门八角金刚石*1", 450, 0));
        awardGroup.addAward(new Award("五色线*2", 11500, 0));
        awardGroup.addAward(new Award("诸天碎片*1", 10000, 0));
        awardGroup.addAward(new Award("黄龟鳞*1", 8000, 0));
        awardGroup.addAward(new Award("副本重置石*2", 15000, 0));
        awardGroup.addAward(new Award("稀有守护石粉末*1", 8000, 0));
        awardGroup.addAward(new Award("千年蟠桃*1", 8000, 0));
        awardGroup.addAward(new Award("灿烂辉石选择箱*1", 4000, 0));
        awardGroup.addAward(new Award("千里传音*1", 10000, 0));
        awardGroup.addAward(new Award("精制星辰结晶*1", 5000, 0));
        awardGroup.addAward(new Award("耀眼快速侠义团成长护符*1", 20000, 0));
*/

        /*awardGroup.addAward(new Award("辉煌天光石(功力)", 110));
        awardGroup.addAward(new Award("辉煌天光石(命中)", 110));
        awardGroup.addAward(new Award("辉煌天光石(恢复)", 110));
        awardGroup.addAward(new Award("辉煌天光石(爆伤)", 110));
        awardGroup.addAward(new Award("辉煌天光石(暴击)", 110));
        awardGroup.addAward(new Award("辉煌天光石(生命)", 110));
        awardGroup.addAward(new Award("辉煌天光石(穿刺)", 110));
        awardGroup.addAward(new Award("辉煌天光石(防御)", 110));

        awardGroup.addAward(new Award("雪峰天光石(功力)", 15));
        awardGroup.addAward(new Award("雪峰天光石(命中)", 15));
        awardGroup.addAward(new Award("雪峰天光石(恢复)", 15));
        awardGroup.addAward(new Award("雪峰天光石(爆伤)", 15));
        awardGroup.addAward(new Award("雪峰天光石(暴击)", 15));
        awardGroup.addAward(new Award("雪峰天光石(生命)", 15));
        awardGroup.addAward(new Award("雪峰天光石(穿刺)", 15));
        awardGroup.addAward(new Award("雪峰天光石(防御)", 15));*/

        System.out.println("总权重："+awardGroup.getTotal());
        AwardStatistics statistics = new AwardStatistics();
        statistics.initAward(awardGroup.getAwardgroup());
        Award award = null;
        int loop = 1;
        int count = 50;

        for (int i = 0; i < count; i++) {
            award = awardGroup.startGetAward();
            String record = addZeroForNumber((i+1)+"",3)+"、"+award;
            System.out.println(record);
            String indexs = award.getIndex() == null?"":award.getIndex()+",";
            award.setIndex(indexs+(i+1));
            statistics.addAward(award);
            statistics.addAwardRecord(record);
        }
        statistics.statisticsHtml();
    }

    public static String addZeroForNumber(String str,int strLength){
        int strLen = str.length();
        if(strLen<strLength){
            while (strLen<strLength){
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);//左补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }
}
