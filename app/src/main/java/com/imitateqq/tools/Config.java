package com.imitateqq.tools;

import android.content.Context;
import android.content.SharedPreferences.Editor;

/**
 * Created by MiracleWong on 2015/7/3.
 */
public class Config {
//    public static final String SERVER_URL = "http://demo.eoeschool.com/api/v1/nimings/io";
//    public static final String SERVER_URL = "http://192.168.56.102:8090/TestServer/api.jsp";
    public static final String SERVER_URL = "http://10.91.92.79:80/TestServer/api.jsp";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_ACTION = "action";
    public static final String KEY_PHONE_NUM = "phone";
   // public static final String KEY_PHONE_MD5 = "phone_md5";
    public static final String KEY_STATUS = "status";
    public static final String KEY_CODE = "code" ;


    public static final int RESULT_STATUS_SUCCESS = 1;


    public static final String APP_ID = "com.imitateqq";
    public static final String CHARSET = "utf-8";
    public static final String ACTION_GET_CODE = "send_pass";
    public static final String ACTION_LOGIN = "login";



    // 获取到缓存的token
    public static String getCachedToken(Context context){
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_TOKEN, null);
    }

    public static void cacheToken(Context context, String token){
        Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN,token);
        e.commit();     // 提交
    }

    // 获取到缓存的PhoneNum
    public static String getCachedPhoneNum(Context context) {
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_PHONE_NUM, null);
    }

    public static void cachePhoneNum(Context context, String phoneNum) {
        Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_PHONE_NUM, phoneNum);
        e.commit();     // 提交
    }
}
