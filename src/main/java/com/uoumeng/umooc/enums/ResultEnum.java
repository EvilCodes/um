package com.uoumeng.umooc.enums;

/**
 * Created by chenjun on 2017/4/12.
 * 使用枚举表述常量数据字典
 */
public enum ResultEnum {
    SUCCESS(1, "预约成功"),
    NO_NUMBER(0, "库存不足"),
    REPEAT_APPOINT(-1, "重复预约"),
    INNER_ERROR(-2, "系统异常");

    private int state;

    private String info;

    ResultEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

}
