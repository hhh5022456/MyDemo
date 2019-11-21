package com.example.mydemo.modle.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.sdk.GameTimeListener;

public class SDKActivity extends AppCompatActivity   {
    public GameTimeListener gameTimeListener;

    public void setGameTimeListener(GameTimeListener mGameTimeListener) {
        this.gameTimeListener = mGameTimeListener;
    }
    public interface GameTimeListener {
        void GameTimeOnListener(int  time);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdk);

        SDKActivity sdkActivity=new SDKActivity();

        if (gameTimeListener!=null){
            gameTimeListener.GameTimeOnListener(500);
        }else {
            Toast.makeText(SDKActivity.this,"囧",Toast.LENGTH_SHORT).show();

        }

        sdkActivity.setGameTimeListener(new GameTimeListener() {
            @Override
            public void GameTimeOnListener(int time) {
                Toast.makeText(SDKActivity.this,""+time,Toast.LENGTH_SHORT).show();
            }
        });




    }


}
