package com.example.mydemo.modle.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.bean.SqlBean;
import com.example.mydemo.sdk.GameTimeListener;
import com.example.mydemo.util.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SQLActivity extends AppCompatActivity {

    private static final String TABLE_NAMES = "TaskLists";
    private Button btn;
    private MyDatabaseHelper dbHelper;
    private Button cha;
    private SQLiteDatabase db;
    private List<SqlBean> mList;
    private Button dle;
    private Button car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        btn = findViewById(R.id.btn);
        cha = findViewById(R.id.btn1);
        dle = findViewById(R.id.btn2);
        car = findViewById(R.id.btn3);
        mList = new ArrayList<>();
        dbHelper = new MyDatabaseHelper(SQLActivity.this, "TaskLists.db", null, 1);




        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建TaskList数据库表
                dbHelper.getWritableDatabase();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                // 开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.execSQL("delete from TaskLists");
                db.insert("TaskLists", null, values); // 插入第一条数据
                Toast.makeText(SQLActivity.this, "添加数据", Toast.LENGTH_SHORT).show();
            }
        });


        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 查询Book表中所有的数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        Cursor cursor = db.query("TaskLists", null, null, null, null, null, null);
                        if (cursor.moveToFirst()) {
                            do {
                                // 遍历Cursor对象，取出数据并打印
                                String id = cursor.getString(cursor.getColumnIndex("id"));
                                String name = cursor.getString(cursor.getColumnIndex("name"));
                                String author = cursor.getString(cursor.getColumnIndex("author"));
                                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                                double price = cursor.getDouble(cursor.getColumnIndex("price"));

                                SqlBean sqlBean = new SqlBean();
                                sqlBean.setId(id);
                                sqlBean.setAuthor(author);
                                sqlBean.setName(name);
                                for (int i = 0; i < 3; i++) {
                                    mList.add(sqlBean);
                                }

                                Log.e("SQLActivity", "TaskList id is " + id);
                                Log.d("SQLActivity", "TaskList name is " + name);
                                Log.d("SQLActivity", "TaskList author is " + author);
                                Log.d("SQLActivity", "TaskList pages is " + pages);
                                Log.d("SQLActivity", "TaskList price is " + price);


                                if (!mList.isEmpty()) {
                                    for (int i = 0; i < mList.size(); i++) {

                                        String mId = mList.get(i).getId();
                                        String mAuthor = mList.get(i).getAuthor();
                                        String mName = mList.get(i).getName();

                                        Log.e("SQL", " >>>mId" + mId);
                                        Log.d("SQL", " >>>mAuthor" + mAuthor);
                                        Log.d("SQL", " >>>mName" + mName);
                                    }

                                } else {
                                    Log.w("mList", " >>>mList" + mList.size());

                                }
                            } while (cursor.moveToNext());
                        }
                        cursor.close();
                    }
                }).start();


            }
        });

        dle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("delete from TaskLists");
                //db.execSQL("delete from " + TABLE_NAMES);
            }
        });
    }
}
