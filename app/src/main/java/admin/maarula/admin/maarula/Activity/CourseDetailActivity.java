package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import admin.maarula.admin.maarula.Adapter.CourseDetailAdapter;
import admin.maarula.admin.maarula.Models.CourseDetail;
import admin.maarula.admin.maarula.R;

public class CourseDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CourseDetailAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        // ini views
        iniViews();
        //setup list cast
        setupRelatedCourse();
    }

    void setupRelatedCourse() {

        List<CourseDetail> mdata = new ArrayList<>();
        mdata.add(new CourseDetail("name", R.drawable.coursethumb));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb2));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb2));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb2));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb));
        mdata.add(new CourseDetail("name", R.drawable.coursethumb2));

        castAdapter = new CourseDetailAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    void iniViews() {
        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
//        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        // setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
    }
}