package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;

public class FromWhereActivity extends AppCompatActivity {
    ExtendedFloatingActionButton extendedFloatingActionButton;
    int checkedCard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_where);
        AppConfig.showwCustomToast(FromWhereActivity.this, "Long Press to select ", "Hey " + AppConfig.getGreetings());
        initToolbar();
        extendedFloatingActionButton = findViewById(R.id.extended_fab);
        MaterialCardView card_1 = findViewById(R.id.card_1);
        MaterialCardView card_2 = findViewById(R.id.card_2);
        MaterialCardView card_3 = findViewById(R.id.card_3);
        MaterialCardView card_4 = findViewById(R.id.card_4);
        MaterialCardView card_5 = findViewById(R.id.card_5);
        MaterialCardView card_6 = findViewById(R.id.card_6);
        MaterialCardView card_7 = findViewById(R.id.card_7);

        card_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_1.setChecked(!card_1.isChecked());
                if (card_1.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        card_2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_2.setChecked(!card_2.isChecked());
                if (card_2.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        card_3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_3.setChecked(!card_3.isChecked());
                if (card_3.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });

        card_4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_4.setChecked(!card_4.isChecked());
                if (card_4.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        card_5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_5.setChecked(!card_5.isChecked());
                if (card_5.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        card_6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_6.setChecked(!card_6.isChecked());
                if (card_6.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        card_7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                card_7.setChecked(!card_7.isChecked());
                if (card_7.isChecked())
                    checkedCard++;
                else
                    checkedCard--;
                return true;
            }
        });
        extendedFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedCard == 0) {
                    AppConfig.showwCustomToast(FromWhereActivity.this, "", "Please select");
                } else {
                    AppConfig.jumpTo(FromWhereActivity.this, InterestActivity.class, "slide");
                }
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("" + AppConfig.getGreetings() + ", Student");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

}