package com.example.mydemo;

public interface GoldListener {

    void onFetchGoldSuccess(int gold,String msg);

    void onFetchGoldFail(String errMsg);
}