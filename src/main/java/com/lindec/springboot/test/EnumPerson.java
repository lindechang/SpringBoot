package com.lindec.springboot.test;

/**
 * 枚举类
 * Created by lindec on 2016/3/31.
 */
public enum EnumPerson {

    NULL(0, "null"),

    NEW(1, "新建"),

    COMMIT(2, "推送中"),

    PUSHED(3, "已推送"),

    FAILED(4, "推送失败"),

    DELETE(5, "删除");

    private int value;

    private String desc;

    EnumPerson(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static EnumPerson getByIntValue(int status) {
        for (EnumPerson vendorContentStatus : EnumPerson.values()) {
            if (vendorContentStatus.getValue() == status) {
                return vendorContentStatus;
            }
        }
        return NULL;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

//    public static void main(String[] args) {
//        EnumPerson enumPerson = getByIntValue(2);
//        System.out.println(enumPerson.getDesc());
//    }

}
