package com.example.mydemo.modle.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mydemo.GoldListener;
import com.example.mydemo.R;
import com.example.mydemo.modle.fragment.LoginFragment;

public class Main2Activity extends AppCompatActivity implements GoldListener {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loginFragment = new LoginFragment();
        loginFragment.setGoldDoubleListener(this);
        Log.e("TAG","XXX");
     }

    @Override
    public void onFetchGoldSuccess(int gold, String msg) {
        Log.e("TAG",">>>");
    }

    @Override
    public void onFetchGoldFail(String errMsg) {
        Log.e("TAG","<<<");

    }
}
