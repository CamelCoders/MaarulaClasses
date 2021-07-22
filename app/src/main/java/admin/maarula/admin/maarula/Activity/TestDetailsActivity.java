package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Adapter.FlexboxAdapter;
import admin.maarula.admin.maarula.R;

public class TestDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> arrayList = new ArrayList<>();
    FlexboxAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);
        recyclerView = findViewById(R.id.quesRecycler);
        initArray();
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
        layoutManager.setAlignItems(AlignItems.CENTER);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FlexboxAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);
    }

    private void initArray() {
        for (int i = 1; i <= 30; i++) {
            arrayList.add("Q" + i);
        }
    }
}