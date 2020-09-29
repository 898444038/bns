package com.ming.bns.ppsg.controller;

import com.ming.bns.ppsg.entity.Level;
import com.ming.tools.bind.core.BindUtils;

public class Test {

    public static void main(String[] args) {
        Level level = new Level();
        level.setId(1L);
        BindUtils.getInstance().binding(level);
        level.setName("壮士1级");
        BindUtils.getInstance().change();
    }

}
