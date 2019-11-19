package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Runnable mRunnables;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_tx = findViewById(R.id.tx);
        Button btn_txs = findViewById(R.id.txs);
        ExecutorUtil.executorService().execute(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG","线程1");
            }
        });
        ExecutorUtil.executorService().execute(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG","线程2");
            }
        });

        btn_tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("TAG",ExecutorUtil.mExecutor.toString()+">>>"+ExecutorUtil.mExecutor.isShutdown());
                ExecutorUtil.executorService().shutdown();
            }
        });

        btn_txs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
