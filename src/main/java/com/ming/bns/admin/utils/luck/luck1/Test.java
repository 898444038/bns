package com.ming.bns.admin.utils.luck.luck1;

public class Test {
    public static void main(String[] args) {

        AwardGroup awardGroup = new AwardGroup();
        awardGroup.setAutoReduce(false); // 是否每抽一次减少一个奖品
        awardGroup.addAward(new Award("黄龙灵1段*1", 5, 0)); // Award 分别是 奖品名称 奖品权重（个数） 奖品价格
        awardGroup.addAward(new Award("觉醒洪门八角金刚石*1", 45, 0));
        awardGroup.addAward(new Award("五色线*2", 1150, 0));
        awardGroup.addAward(new Award("诸天碎片*1", 1000, 0));
        awardGroup.addAward(new Award("黄龟鳞*1", 800, 0));
        awardGroup.addAward(new Award("副本重置石*2", 1500, 0));
        awardGroup.addAward(new Award("稀有守护石粉末*1", 800, 0));
        awardGroup.addAward(new Award("千年蟠桃*1", 800, 0));
        awardGroup.addAward(new Award("灿烂辉石选择箱*1", 400, 0));
        awardGroup.addAward(new Award("千里传音*1", 1000, 0));
        awardGroup.addAward(new Award("精制星辰结晶*1", 500, 0));
        awardGroup.addAward(new Award("耀眼快速侠义团成长护符*1", 2000, 0));
        System.out.println("总权重："+awardGroup.getTotal());
        AwardStatistics statistics = new AwardStatistics();
        statistics.initAward(awardGroup.getAwardgroup());
        Award award = null;
        for (int i = 0; i < 1000; i++) {
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
