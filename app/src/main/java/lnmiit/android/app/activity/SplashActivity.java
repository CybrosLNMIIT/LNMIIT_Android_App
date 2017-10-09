package lnmiit.android.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import lnmiit.android.app.R;

public class SplashActivity extends AppCompatActivity {

    ImageView splashImage;
    Animation anim;
    ProgressBar progressBar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        splashImage = (ImageView)findViewById(R.id.splash_screen_image);
        progressBar = (ProgressBar)findViewById(R.id.splash_progress_bar);
        anim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_transition);
        splashImage.setAnimation(anim);
        progressBar.setAnimation(anim);

        i=0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            public void run() {

                if (i++ < 5) {
                    progressBar.setProgress(i*20);
                    handler.postDelayed(this, 600);
                }
                else {
                    Intent intent = new Intent("lnmiit.android.app.main");
                    startActivity(intent);
                    finish();
                }
            }
        };
        handler.post(runnable);

    }
}
