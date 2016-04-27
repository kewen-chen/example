package com.kewen.example.util;

/**
 * Created by Administrator on 2016/4/26.
 */
public interface HttpCallbackListener {
    //响应成功时调用
    void onFinish(String response);
    //响应出错时调用
    void onError(Exception e);
}
