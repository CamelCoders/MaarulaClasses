package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import admin.maarula.admin.maarula.Adapter.ContentAdapter;
import admin.maarula.admin.maarula.Models.ContentItem;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.ItemAnimation;

public class SavedContentActivity extends AppCompatActivity {
    private final List<ContentItem> items = new ArrayList<>();
    private final int animation_type = ItemAnimation.BOTTOM_UP;
    private View parent_view;
    private RecyclerView recyclerView;
    private ContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_content);

        initToolbar();
        initComponent();
        setAdapter();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SAVED QP / NOTES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        items.add(new ContentItem("MATH Previous Year Paper", "year 3030"));
        items.add(new ContentItem("NIMCET Previous Year Paper", "year 3030"));
        items.add(new ContentItem("Reasoning Previous Year Paper", "year 3030"));
        items.add(new ContentItem("NIMCET Previous Year Paper", "year 3030"));
        items.add(new ContentItem("ENGLISH Previous Year Paper", "year 3030"));
        items.add(new ContentItem("NIMCET Previous Year Paper", "year 3030"));
        items.add(new ContentItem("COMPUTER Previous Year Paper", "year 3030"));
        items.add(new ContentItem("NIMCET Previous Year Paper", "year 3030"));
        items.add(new ContentItem("JNU Previous Year Paper", "year 3030"));
        items.add(new ContentItem("NIMCET Previous Year Paper", "year 3030"));
        items.add(new ContentItem("BHU Previous Year Paper", "year 3030"));
        //add items
    }

    private void setAdapter() {
        //set data and list adapter
        mAdapter = new ContentAdapter(this, items, animation_type);
        recyclerView.setAdapter(mAdapter);

    }
}