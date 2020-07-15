package com.ming.tools.generate.template.enable;

/**
 * Created by Administrator on 2020/4/15 0015.
 */

//@ConfigurationProperties(prefix = "hello")
public class GenerateProperties {

    private static final String MSG="world";
    private String msg=MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
