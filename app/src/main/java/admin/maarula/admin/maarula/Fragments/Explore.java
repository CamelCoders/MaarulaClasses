package admin.maarula.admin.maarula.Fragments;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import admin.maarula.admin.maarula.Activity.CourseDetailActivity;
import admin.maarula.admin.maarula.Adapter.CoursesAdapter;
import admin.maarula.admin.maarula.Adapter.LiveSliderPagerAdapter;
import admin.maarula.admin.maarula.Adapter.SliderAdapter;
import admin.maarula.admin.maarula.Adapter.UpcomingLecturesAdapter;
import admin.maarula.admin.maarula.Interface.CoursesItemClickListener;
import admin.maarula.admin.maarula.Models.Courses;
import admin.maarula.admin.maarula.Models.LiveClassSliders;
import admin.maarula.admin.maarula.Models.SliderData;
import admin.maarula.admin.maarula.Models.UpcomingLectures;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;
import admin.maarula.admin.maarula.Utils.DataGenerator;
import admin.maarula.admin.maarula.Utils.ViewAnimation;

public class Explore extends Fragment implements CoursesItemClickListener {
    private final Handler sliderHandler = new Handler();
    public CoursesItemClickListener listener = new CoursesItemClickListener() {
        @Override
        public void onCourseClick(Courses courses, ImageView imageView) {
            Intent intent = new Intent(getContext(), CourseDetailActivity.class);
            // send movie information to deatilActivity
            intent.putExtra("title", courses.getTitle());
            intent.putExtra("imgURL", courses.getThumbnail());
            intent.putExtra("imgCover", courses.getCoverPhoto());
            // lets crezte the animation
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                    imageView, "sharedName");

            startActivity(intent, options.toBundle());
        }
    };
    TextView greetings;
    String url1 = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
    String url2 = "https://qphs.fs.quoracdn.net/main-qimg-8e203d34a6a56345f86f1a92570557ba.webp";
    String url3 = "https://bizzbucket.co/wp-content/uploads/2020/08/Life-in-The-Metro-Blog-Title-22.png";
    // we are creating array list for storing our image urls.
    ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
    SliderView sliderView;
    private ImageButton bt_toggle_text, bt_toggle_text2, bt_toggle_text3;
    private View lyt_expand_text, lyt_expand_text2, lyt_expand_text3;
    private NestedScrollView nested_scroll_view;
    private List<LiveClassSliders> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView courses;
    private View parent_view;
    private RecyclerView recyclerView;
    private UpcomingLecturesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_explore, container, false);
        initViews(view);
        parent_view = view.findViewById(android.R.id.content);
        greetings.setText("" + AppConfig.getGreetings() + ", Shivam");
        bt_toggle_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(bt_toggle_text);
            }
        });
        bt_toggle_text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(bt_toggle_text2);
            }
        });
        bt_toggle_text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSectionText(bt_toggle_text3);
            }
        });
        showLiveClasses();
        showCoursesList();
        showSlider();
        return view;
    }

    private void showSlider() {
        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
    }


    private void showLiveClasses() {
        // prepare a list of slides ..
        lstSlides = new ArrayList<>();
        lstSlides.add(new LiveClassSliders(R.drawable.thumb, "Slide Title \nmore text here", true));
        lstSlides.add(new LiveClassSliders(R.drawable.thumb2, "Slide Title \nmore text here", true));
        lstSlides.add(new LiveClassSliders(R.drawable.thumb, "Slide Title \nmore text here", false));
        lstSlides.add(new LiveClassSliders(R.drawable.thumb2, "Slide Title \nmore text here", true));
        LiveSliderPagerAdapter adapter = new LiveSliderPagerAdapter(getContext(), lstSlides);
        sliderpager.setAdapter(adapter);
        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);
    }

    private void initViews(View view) {
        sliderView = view.findViewById(R.id.slider);
        greetings = view.findViewById(R.id.greetings);
        bt_toggle_text = view.findViewById(R.id.bt_toggle_text);
        bt_toggle_text2 = view.findViewById(R.id.bt_toggle_text2);
        bt_toggle_text3 = view.findViewById(R.id.bt_toggle_text3);
        lyt_expand_text = view.findViewById(R.id.lyt_expand_text);
        lyt_expand_text2 = view.findViewById(R.id.lyt_expand_text2);
        lyt_expand_text3 = view.findViewById(R.id.lyt_expand_text3);
        courses = view.findViewById(R.id.courses);
        sliderpager = view.findViewById(R.id.slider_pager);
        indicator = view.findViewById(R.id.indicator);
        nested_scroll_view = view.findViewById(R.id.nested_scroll_view);
//        lyt_expand_text.setVisibility(View.GONE);
        lyt_expand_text2.setVisibility(View.GONE);
        lyt_expand_text3.setVisibility(View.GONE);
        recyclerView = view.findViewById(R.id.upcomingRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        List<UpcomingLectures> items = DataGenerator.getNewsData(getContext(), 10);

        //set data and list adapter
        mAdapter = new UpcomingLecturesAdapter(getContext(), items, R.layout.item_news_horizontal);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new UpcomingLecturesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, UpcomingLectures obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.title + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    private void showCoursesList() {
        List<Courses> lstCoursesList = new ArrayList<>();
        lstCoursesList.add(new Courses("Moana", R.drawable.coursethumb, R.drawable.thumb));
        lstCoursesList.add(new Courses("Black P", R.drawable.coursethumb2, R.drawable.thumb2));
        lstCoursesList.add(new Courses("The Martian", R.drawable.coursethumb, R.drawable.thumb));
        lstCoursesList.add(new Courses("The Martian", R.drawable.coursethumb2, R.drawable.thumb2));
        lstCoursesList.add(new Courses("The Martian", R.drawable.coursethumb, R.drawable.thumb));
        lstCoursesList.add(new Courses("The Martian", R.drawable.coursethumb2, R.drawable.thumb2));

        CoursesAdapter adapter = new CoursesAdapter(getContext(), lstCoursesList, listener);
        courses.setAdapter(adapter);
        courses.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

    }

    private void toggleSectionText(View view) {
        boolean show = toggleArrow(view);
        if (view == bt_toggle_text) {
            if (show) {
                ViewAnimation.expand(lyt_expand_text, new ViewAnimation.AnimListener() {
                    @Override
                    public void onFinish() {
                        AppConfig.nestedScrollTo(nested_scroll_view, lyt_expand_text);
                    }
                });
            } else {
                ViewAnimation.collapse(lyt_expand_text);
            }
        } else if (view == bt_toggle_text2) {
            if (show) {
                ViewAnimation.expand(lyt_expand_text2, new ViewAnimation.AnimListener() {
                    @Override
                    public void onFinish() {
                        AppConfig.nestedScrollTo(nested_scroll_view, lyt_expand_text2);
                    }
                });
            } else {
                ViewAnimation.collapse(lyt_expand_text2);
            }
        } else if (view == bt_toggle_text3) {
            if (show) {
                ViewAnimation.expand(lyt_expand_text3, new ViewAnimation.AnimListener() {
                    @Override
                    public void onFinish() {
                        AppConfig.nestedScrollTo(nested_scroll_view, lyt_expand_text3);
                    }
                });
            } else {
                ViewAnimation.collapse(lyt_expand_text3);
            }
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(90);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCourseClick(Courses courses, ImageView imageView) {
        // here we send movie information to detail activity
        // also we ll create the transition animation between the two activity

        Intent intent = new Intent(getContext(), CourseDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title", courses.getTitle());
        intent.putExtra("imgURL", courses.getThumbnail());
        intent.putExtra("imgCover", courses.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                imageView, "sharedName");

        startActivity(intent, options.toBundle());


        // i l make a simple test to see if the click works
        AppConfig.showwCustomToast(getActivity(), "item clicked : ", "" + courses.getTitle());
        // it works great


    }


    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem() < lstSlides.size() - 1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                    } else
                        sliderpager.setCurrentItem(0);
                }
            });

        }
    }

}
