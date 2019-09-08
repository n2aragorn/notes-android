package com.vmk.solutions.nazgul.notes;

import android.content.Intent;
import android.os.Bundle;

import com.vmk.solutions.nazgul.notes.notes.NotesActivity;
import com.vmk.solutions.nazgul.notes.util.Constants;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        runSplash();
    }

    private void runSplash() {
        final Runnable splash = new Runnable() {
            @Override
            public void run() {

                boolean userLogger = prefs.getPref(Constants.prefs_user);

                Intent intent;

                if (userLogger){
                    intent = new Intent(SplashActivity.this, NotesActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(splash);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000);
    }
}
