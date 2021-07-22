package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;

import static admin.maarula.admin.maarula.Utils.AppConfig.bottomAnimation;
import static admin.maarula.admin.maarula.Utils.AppConfig.middleAnimation;
import static admin.maarula.admin.maarula.Utils.AppConfig.topAnimation;

public class SpalshActivity extends AppCompatActivity {
    private static final int SPLASH = 4000;
    View first, second, third, fourth, fifth, sixth;
    TextView appName, appTitle, appTitle2;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        AppConfig.setStatusBarColor(SpalshActivity.this, R.color.dark_color);
        initViews();
        AppConfig.initAnimation(SpalshActivity.this);
        setAnimations();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AppConfig.jumpTo(SpalshActivity.this, DashBoard.class, "slide");
            }
        }, SPLASH);
    }

    private void setAnimations() {
        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        appName.setAnimation(middleAnimation);
        appTitle.setAnimation(bottomAnimation);
        logo.setAnimation(middleAnimation);
    }

    private void initViews() {
        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);
        appName = findViewById(R.id.appName);
        appTitle = findViewById(R.id.appTitle);
        logo = findViewById(R.id.img_logo);
    }

}