package me.buck.musicdemo.api.bean;

import com.google.gson.Gson;

public class HttpResult {
    private static Gson gson = new Gson();

    private int code;
    private String msg;

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

    public boolean isSuccess() {
        return code == 200;
    }

    public String toJson() {
        return gson.toJson(this);
    }

}
