package lnmiit.android.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import lnmiit.android.app.R;

/* Created on 9th October 2017 */

public class SplashActivity extends AppCompatActivity {

    ImageView splashImage;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        splashImage = (ImageView)findViewById(R.id.splash_screen_image);
        anim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_transition);
        splashImage.setAnimation(anim);

        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent("lnmiit.android.app.main");
                    startActivity(intent);
                    finish();
                }
            }

        };splash.start();

    }
}
