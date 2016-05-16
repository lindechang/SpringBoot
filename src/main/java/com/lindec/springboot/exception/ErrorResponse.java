package com.lindec.springboot.exception;

/**
 * Created by iCoderc on 2015/12/1.
 */
public class ErrorResponse {
    private int code;
    private String desc;
    private long timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String desc) {
        super();
        this.code = code;
        this.desc = desc;
        this.timestamp = System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
