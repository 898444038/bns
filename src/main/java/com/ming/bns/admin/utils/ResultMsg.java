package com.ming.bns.admin.utils;

public class ResultMsg {

    private enum ResultType{
        SUCCESS(1,"SUCCESS","操作成功"),
        FAILED(0,"FAILED","操作失败"),
        ERROR(-1,"ERROR","系统异常"),
        AUTH(403,"拒绝访问","没有访问权限");
        private int code;
        private String name;
        private String desc;
        ResultType(int code,String name ,String desc){
            this.code = code;
            this.name = name;
            this.desc = desc;
        }
        public int getCode() {return code;}
        public String getName() {return name;}
        public String getDesc() {return desc;}
    }

    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //操作成功
    public static ResultMsg success(String msg, Object data) {
        return new ResultMsg(ResultType.SUCCESS.code,msg,data);
    }
    /*public static ResultMsg success(String msg) {
        return success(msg,null);
    }*/
    public static ResultMsg success(Object data) {
        return success(ResultType.SUCCESS.desc,data);
    }
    public static ResultMsg success() {
        return success(ResultType.SUCCESS.desc,null);
    }
    //操作失败
    public static ResultMsg failed(String msg, Object data) {
        return new ResultMsg(ResultType.FAILED.code,msg,data);
    }
    public static ResultMsg failed(String msg) {
        return failed(msg,null);
    }
    public static ResultMsg failed() {
        return failed(ResultType.FAILED.desc,null);
    }
    //系统异常
    public static ResultMsg error(String msg, Object data) {
        return new ResultMsg(ResultType.ERROR.code,msg,data);
    }
    public static ResultMsg error(String msg) {
        return error(msg,null);
    }
    public static ResultMsg error() {
        return error(ResultType.ERROR.desc,null);
    }

    public static ResultMsg auth() {
        return new ResultMsg(ResultType.AUTH.code,ResultType.AUTH.name,ResultType.AUTH.desc);
    }
    public static ResultMsg auth(String msg) {
        return new ResultMsg(ResultType.AUTH.code,msg,ResultType.AUTH.desc);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
