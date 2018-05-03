package com.example.administrator.activitytest;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class FouthActivity extends AppCompatActivity {
    int[] imageIds=new int[]
            {       R.drawable.draw1,
                    R.drawable.draw2,
                    R.drawable.draw3,
                    R.drawable.draw4,

            };
    int currentImageId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fouth_layout);
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FouthActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        final ImageView show = (ImageView) findViewById(R.id.view1);
        final Handler myHandler=new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                if (msg.what==0x1233)
                    show.setImageResource(imageIds[currentImageId++%imageIds.length]);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x1233);
            }
        },0,1200);

    }
}
