package com.ming.bns.admin.utils;

import com.ming.bns.admin.entity.Equip;
import com.ming.bns.admin.entity.EquipGrow;

import java.util.*;
import java.util.stream.Collectors;

public class EquipUtil {

    public static void main(String[] args) {
        List<Equip> equipList = getEquipList(false);
        List<Equip> equipAllList = getEquipList(true);

        List<EquipGrow> equipGrowList = getEquipGrowList();
        Long startId = 3L;
        Long endId = 27L;
        //route(startId,endId,equipList,equipGrowList);

        List<List<Equip>> routeList = routeTree(startId,endId,equipAllList,equipGrowList);
        System.out.println();
        for(List<Equip> route : routeList){
            routeCount(route);
        }
    }

    /**
     * 成长路线计算
     */
    public static void routeCount(List<Equip> list){

    }

    /**
     * 生成成长路线
     * @param startId
     * @param endId
     * @param equipAllList
     * @param equipGrowList
     * @return
     */
    public static List<List<Equip>> routeTree(Long startId,Long endId,List<Equip> equipAllList,List<EquipGrow> equipGrowList){
        TreeNode treeAll = TreeUtil.getTree(equipAllList);
        List<List<TreeNode>> routeTreeAll = TreeUtil.bfsTree(treeAll);

        List<List<Equip>> lists = new ArrayList<>();
        boolean flag = false;
        for (List<TreeNode> nodeList : routeTreeAll){
            List<Equip> equips = new ArrayList<>();
            for (TreeNode node : nodeList){
                if(startId.equals((long)node.getId())){
                    flag = true;
                }
                if(flag){
                    equips.add(new Equip((long)node.getId(),node.getName(),(long)node.getParentId()));
                }
                if(endId.equals((long)node.getId())){
                    flag = false;
                }
            }
            if(equips.size()!=0 && equips.get(0).getId().equals(startId) && equips.get(equips.size()-1).getId().equals(endId)){
                lists.add(equips);
            }
        }

        for (List<Equip> equips : lists){
            for (Equip equip : equips){
                List<EquipGrow> equipGrowLists = equipGrowList.stream().filter(g->g.getStartEquipId().equals(equip.getId())).collect(Collectors.toList());
                equip.setEquipGrowList(equipGrowLists);
            }
        }
        return lists;
    }

    /**
     * 路线
     * @return
     */
    /*public static void route(Long startId,Long endId,List<Equip> equipList,List<EquipGrow> equipGrowList){
        List<EquipGrow> newEquipGrowList = new LinkedList<>();
        loop(startId, endId, equipList, equipGrowList,newEquipGrowList);
        Collections.reverse(newEquipGrowList);//元素反转
        System.out.println(newEquipGrowList);

        Set<Equip> equipSet = new LinkedHashSet<>();
        for (EquipGrow equipGrow : newEquipGrowList){
            for(Equip equip : equipList){
                if(equip.getId().equals(equipGrow.getStartEquipId()) || equip.getId().equals(equipGrow.getEndEquipId())){
                    equipSet.add(equip);
                }
            }
        }
        for (Equip equip : equipSet){
            System.out.print(equip.getName()+" -> ");
        }
    }*/

    /*public static void loop(Long startId,Long endId,List<Equip> equipList,List<EquipGrow> equipGrowList,List<EquipGrow> newEquipGrowList){
        List<EquipGrow> equipGrows = equipGrowList.stream().filter(g->g.getEndEquipId().equals(endId)).collect(Collectors.toList());//.findFirst().orElse(equipGrowList.get(equipGrowList.size() - 1));
        for (EquipGrow equipGrow : equipGrows){
            newEquipGrowList.add(equipGrow);
            if(!equipGrow.getStartEquipId().equals(startId)){
                loop(startId, equipGrow.getStartEquipId(), equipList, equipGrowList,newEquipGrowList);
            }
        }

        //EquipGrow equipGrow = equipGrowList.stream().filter(g->g.getEndEquipId().equals(endId)).findFirst().orElse(equipGrowList.get(equipGrowList.size() - 1));
        //System.out.println(equipGrows);
        //newEquipGrowList.add(equipGrow);
        //if(!equipGrow.getStartEquipId().equals(startId)){
        //    loop(startId, equipGrow.getStartEquipId(), equipList, equipGrowList,newEquipGrowList);
        //}
    }*/

    public static List<EquipGrow> getEquipGrowList(){
        List<EquipGrow> equipGrowList = new ArrayList<EquipGrow>();
        equipGrowList.add(new EquipGrow(1L,2L));
        equipGrowList.add(new EquipGrow(2L,3L));
        equipGrowList.add(new EquipGrow(3L,4L));
        equipGrowList.add(new EquipGrow(4L,5L));
        equipGrowList.add(new EquipGrow(5L,6L));
        equipGrowList.add(new EquipGrow(6L,7L));
        equipGrowList.add(new EquipGrow(7L,8L));
        equipGrowList.add(new EquipGrow(8L,9L));
        equipGrowList.add(new EquipGrow(9L,10L));
        equipGrowList.add(new EquipGrow(10L,11L));
        equipGrowList.add(new EquipGrow(11L,12L));
        equipGrowList.add(new EquipGrow(12L,13L));
        equipGrowList.add(new EquipGrow(13L,14L));
        equipGrowList.add(new EquipGrow(14L,15L));

        equipGrowList.add(new EquipGrow(16L,17L));
        equipGrowList.add(new EquipGrow(17L,18L));
        equipGrowList.add(new EquipGrow(18L,19L));
        equipGrowList.add(new EquipGrow(19L,20L));
        equipGrowList.add(new EquipGrow(20L,21L));
        equipGrowList.add(new EquipGrow(21L,22L));
        equipGrowList.add(new EquipGrow(22L,23L));
        equipGrowList.add(new EquipGrow(23L,24L));
        equipGrowList.add(new EquipGrow(24L,25L));
        equipGrowList.add(new EquipGrow(25L,26L));
        equipGrowList.add(new EquipGrow(26L,27L));
        equipGrowList.add(new EquipGrow(27L,28L));
        equipGrowList.add(new EquipGrow(28L,29L));
        equipGrowList.add(new EquipGrow(29L,30L));

        equipGrowList.add(new EquipGrow(12L,23L));
        equipGrowList.add(new EquipGrow(15L,26L));
        return equipGrowList;
    }

    /**
     *
     * @return
     */
    public static List<Equip> getEquipList(boolean flag){
        List<Equip> equipList = new ArrayList<Equip>(){{
            add(new Equip(1L,"晨辉星1段",0L));
            add(new Equip(2L,"晨辉星2段",1L));
            add(new Equip(3L,"晨辉星3段",2L));
            add(new Equip(4L,"晨辉星4段",3L));
            add(new Equip(5L,"晨辉星5段",4L));
            add(new Equip(6L,"晨辉星6段",5L));
            add(new Equip(7L,"晨辉星7段",6L));
            add(new Equip(8L,"晨辉星8段",7L));
            add(new Equip(9L,"晨辉星9段",8L));
            add(new Equip(10L,"晨辉星10段",9L));
            add(new Equip(11L,"晨辉星11段",10L));
            add(new Equip(12L,"晨辉星12段",11L));
            add(new Equip(13L,"晨辉星13段",12L));
            add(new Equip(14L,"晨辉星14段",13L));
            add(new Equip(15L,"晨辉星15段",14L));

            add(new Equip(16L,"金雷星1段",0L));
            add(new Equip(17L,"金雷星2段",16L));
            add(new Equip(18L,"金雷星3段",17L));
            add(new Equip(19L,"金雷星4段",18L));
            add(new Equip(20L,"金雷星5段",19L));
            add(new Equip(21L,"金雷星6段",20L));
            add(new Equip(22L,"金雷星7段",21L));
            add(new Equip(23L,"金雷星8段",22L));
            add(new Equip(24L,"金雷星9段",23L));
            add(new Equip(25L,"金雷星10段",24L));
            add(new Equip(26L,"金雷星11段",25L));
            add(new Equip(27L,"金雷星12段",26L));
            add(new Equip(28L,"金雷星13段",27L));
            add(new Equip(29L,"金雷星14段",28L));
            add(new Equip(30L,"金雷星15段",29L));

            if(flag){
                add(new Equip(26L,"金雷星11段",15L));
                add(new Equip(23L,"金雷星8段",12L));
            }

        }};
        return equipList;
    }
}
