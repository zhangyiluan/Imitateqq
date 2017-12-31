package com.imitateqq.net;

import com.imitateqq.tools.Config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by MiracleWong on 2015/7/4.
 */
public class Login {
    public Login(String phone, String code, final SuccessCallback successCallback, final FailCallback failCallback) {
        new NetConnection(Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);
                    switch (obj.getInt(Config.KEY_STATUS)) {
                        case Config.RESULT_STATUS_SUCCESS:
                            if (successCallback != null){
                                successCallback.onSuccess(obj.getString(Config.KEY_TOKEN));
                            }
                            break;
                        default:
                            if (failCallback != null){
                                failCallback.onFail();
                            }
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetConnection.FailCallback() {
            @Override
            public void onFail() {
                if (failCallback != null){
                    failCallback.onFail();
                }
            }
        }, Config.KEY_ACTION, Config.ACTION_LOGIN,Config.KEY_PHONE_NUM,phone,Config.KEY_CODE,code);
    }
    public static interface SuccessCallback{
        void onSuccess(String token);
    }

    public static interface FailCallback{
        void onFail();
    }
}
