package com.yoojieun.memoji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.yoojieun.memoji.utils.Utils;

/**
 * Created by yoojieun on 2015. 10. 27..
 */

public class SplashScreen extends Activity{

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.v("memoji", "handleMessage msg.what = "+ msg.what );
            if(msg.what == 100){
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Utils.log("@@@@Splash screen is started");

        mHandler.sendEmptyMessageDelayed(100,2000);

//        Thread timerThread = new Thread() {
//            public void run() {
//                try {
//                    sleep(3000);
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };
//        timerThread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeMessages(100);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
