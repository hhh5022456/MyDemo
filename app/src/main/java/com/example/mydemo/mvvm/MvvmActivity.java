package com.example.mydemo.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mydemo.R;
import com.example.mydemo.databinding.ActivityMvvmBinding;
import com.example.mydemo.modle.UserInfoBean;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        UserInfoBean userInfoBean=new UserInfoBean();
        userInfoBean.age="19";
        userInfoBean.name="韩爸爸";
        binding.setUser(userInfoBean);


    }
}
