package com.daon.onorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daon.onorder.Model.MenuModel;

public class ADPopupActivity extends AppCompatActivity {

    LinearLayout popuplayout;
    ImageView popupImage;
    private Download download;
    boolean is_t = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_d_popup);
        download = new Download();
        download.start();
        popuplayout = findViewById(R.id.ad_activity_layout);
        popuplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_t = false;
                finish();
            }
        });
        popupImage = findViewById(R.id.ad_activity_image);
        popupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_t = false;
                finish();

            }
        });
    }

    public class Download extends Thread {

        int count = 0;
        @Override
        public void run() {
            while (is_t) {
                count++;  // 작업스레드 값 증가.
                try {
                    Thread.sleep(1000);   // 1000ms, 즉 1초 단위로 작업스레드 실행
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 15){
                    (ADPopupActivity.this).runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            popupImage.setImageResource(R.drawable.ad1);
                        }
                    });
                }else if (count == 30){
                    count = 0;
                    (ADPopupActivity.this).runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            popupImage.setImageResource(R.drawable.ad2);
                        }
                    });
                }

            }

        }
    }
}