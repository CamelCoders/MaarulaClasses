package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;
import admin.maarula.admin.maarula.Utils.LoadingDialog;

public class InterestActivity extends AppCompatActivity {
    final LoadingDialog loadingDialog = new LoadingDialog(InterestActivity.this);
    ExtendedFloatingActionButton extendedFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        initToolbar();
        extendedFloatingActionButton = findViewById(R.id.extended_fab);
        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        AppConfig.jumpTo(InterestActivity.this, DashBoard.class, "fade");
                    }
                }, 5000);
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Please select your goals / ambitions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}