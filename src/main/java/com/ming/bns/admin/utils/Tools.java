package com.ming.bns.admin.utils;

import java.util.Calendar;
import java.util.Date;

public class Tools {

    /**
     * 获取
     * @return
     */
    public static String getWeek() {
        String week = "";
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "7";//周日
        } else if (weekday == 2) {
            week = "1";//周一
        } else if (weekday == 3) {
            week = "2";//周二
        } else if (weekday == 4) {
            week = "3";//周三
        } else if (weekday == 5) {
            week = "4";//周四
        } else if (weekday == 6) {
            week = "5";//周五
        } else if (weekday == 7) {
            week = "6";//周六
        }
        return week;
    }


    public static void main(String[] args) {
        System.out.println(Tools.getWeek());
    }
}
