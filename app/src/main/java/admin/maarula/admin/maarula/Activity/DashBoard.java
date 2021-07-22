package admin.maarula.admin.maarula.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import admin.maarula.admin.maarula.Fragments.Explore;
import admin.maarula.admin.maarula.Fragments.PlayFragment;
import admin.maarula.admin.maarula.Fragments.SyllabusFragment;
import admin.maarula.admin.maarula.Fragments.TestsFragment;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;

public class DashBoard extends AppCompatActivity {
    final Fragment fragment1 = new Explore();
    final Fragment fragment2 = new SyllabusFragment();
    final Fragment fragment3 = new PlayFragment();
    final Fragment fragment4 = new TestsFragment();
    final FragmentManager fm = getSupportFragmentManager();
    TextView search_text;
    Fragment active = fragment1;
    ImageButton bt_menu;
    LinearLayout my_dashboard, content, savedContent, settings, referFriend, help, aboutUs;
    boolean isNavigationHide = false;
    boolean isSearchBarHide = false;
    private BottomNavigationView navigation;
    private View search_bar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        search_text = findViewById(R.id.search_text);
        search_text.setText("NIMCET");
        initComponent();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();
        my_dashboard = findViewById(R.id.my_dashboard);
        content = findViewById(R.id.content);
        savedContent = findViewById(R.id.savedContent);
        aboutUs = findViewById(R.id.aboutUs);
        settings = findViewById(R.id.settings);
        referFriend = findViewById(R.id.referFriend);
        help = findViewById(R.id.help);
        bt_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initNavigationMenu();
            }
        });
        my_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, DashboardActivity.class, "fade");
            }
        });
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, ContentActivity.class, "fade");
            }
        });
        savedContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, SavedContentActivity.class, "fade");
            }
        });
        referFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, SettingsActivity.class, "fade");
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, HelpActivity.class, "fade");
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(DashBoard.this, AboutActivity.class, "fade");
            }
        });
    }

    private void initComponent() {
        search_bar = findViewById(R.id.search_bar);
        bt_menu = findViewById(R.id.bt_menu);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_explore:
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;
                    case R.id.navigation_syllabus:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;
                    case R.id.navigation_play:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                    case R.id.navigation_tests:
                        fm.beginTransaction().hide(active).show(fragment4).commit();
                        active = fragment4;
                        return true;
                    case R.id.navigation_more:
                        initNavigationMenu();
                        return true;
                }
                return false;
            }
        });
    }

    private void initNavigationMenu() {
        NavigationView nav_view = findViewById(R.id.nav_view);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(GravityCompat.END);
    }

    private void animateNavigation(final boolean hide) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return;
        isNavigationHide = hide;
        int moveY = hide ? (2 * navigation.getHeight()) : 0;
        navigation.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

    private void animateSearchBar(final boolean hide) {
        if (isSearchBarHide && hide || !isSearchBarHide && !hide) return;
        isSearchBarHide = hide;
        int moveY = hide ? -(2 * search_bar.getHeight()) : 0;
        search_bar.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

}