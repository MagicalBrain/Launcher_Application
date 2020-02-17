package com.example.a37487.launcher_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Launcher_Activity extends AppCompatActivity {

    public static int Skip_Flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_);

        //隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //隐藏标题栏
        getSupportActionBar().hide();

        Button Skip = (Button) findViewById(R.id.Skip);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Skip_Flag = 1;
                Intent Main=new Intent(getApplicationContext(),MainActivity.class);//启动MainActivity
                startActivity(Main);
                finish();//关闭当前活动
            }
        });

        //创建子线程
        final Thread myThread=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(5000);//使程序休眠五秒
                    Intent it=new Intent(getApplicationContext(),MainActivity.class);//启动MainActivity
                    startActivity(it);

                    finish();//关闭当前活动
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程
    }
}
