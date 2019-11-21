package com.example.mydemo.modle.fragment;

import com.example.mydemo.GoldListener;

public class LoginFragment {
    public GoldListener mGoldDoubleListener;


    public void setGoldDoubleListener(GoldListener mGoldDoubleListener) {
        this.mGoldDoubleListener = mGoldDoubleListener;
        Listtener();
    }

    private void Listtener(){
        mGoldDoubleListener.onFetchGoldFail("222");
    }


}
