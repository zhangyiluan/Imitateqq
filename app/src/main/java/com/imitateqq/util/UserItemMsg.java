package com.imitateqq.util;

import java.util.ArrayList;
import java.util.List;

public class UserItemMsg {
    private int avatar_img;
    private int iconID;
    private String username;
    private String sign;
    private String state;
    public static List<UserItemMsg> userItemMsgList = new ArrayList<>();

    public UserItemMsg(int avatar_img, int iconID,String username, String sign, String state) {
        this.avatar_img = avatar_img;
        this.iconID = iconID;
        this.username = username;
        this.sign = sign;
        this.state = state;

    }

    public UserItemMsg() {

    }

    public int getAvatar_img() {
        return avatar_img;
    }

    public void setAvatar_img(int avatar_img) {
        this.avatar_img = avatar_img;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
