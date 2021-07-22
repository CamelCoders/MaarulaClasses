package admin.maarula.admin.maarula.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Adapter.LiveClassSliderAdapter;
import admin.maarula.admin.maarula.Models.LiveClassSlider;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;
import admin.maarula.admin.maarula.Utils.ViewAnimation;
import admin.maarula.admin.maarula.databinding.FragmentExploreBinding;

public class ExploreFragment extends Fragment {
    TextView greetings;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<LiveClassSlider> liveClassSliders;
    FragmentExploreBinding binding;
    private ImageButton bt_toggle_text, bt_toggle_text2, bt_toggle_text3;
    private View lyt_expand_text, lyt_expand_text2, lyt_expand_text3;
    private NestedScrollView nested_scroll_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        initViews(view);
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
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.liveVideoClassesRecycler.setLayoutManager(layoutManager);
        prepareSLider();
        return view;
    }

    private void prepareSLider() {
        liveClassSliders = new ArrayList<>();
        liveClassSliders.add(new LiveClassSlider("Image1", "https://youtu.be/6hC-UxeoO7g", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.ytimg.com%2Fvi%2F1syC9FQY52U%2Fmaxresdefault.jpg&imgrefurl=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3D1syC9FQY52U&tbnid=im9OeYzsRZMMaM&vet=12ahUKEwi3wZaO25nxAhVZhEsFHYu4BYYQMygCegUIARCeAQ..i&docid=-0H7kbCGINWRgM&w=1280&h=720&itg=1&q=maarula%20youtube&ved=2ahUKEwi3wZaO25nxAhVZhEsFHYu4BYYQMygCegUIARCeAQ"));
        liveClassSliders.add(new LiveClassSlider("Image1", "https://youtu.be/9PkxD6xxvpo", "data:image/jpeg;base64,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"));
        liveClassSliders.add(new LiveClassSlider("Image1", "https://youtu.be/DN76mJYWAGo", "data:image/jpeg;base64,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"));
        LiveClassSliderAdapter adapter = new LiveClassSliderAdapter(liveClassSliders, getContext());
        binding.liveVideoClassesRecycler.setAdapter(adapter);
    }

    private void initViews(View view) {
        greetings = (TextView) view.findViewById(R.id.greetings);
        bt_toggle_text = (ImageButton) view.findViewById(R.id.bt_toggle_text);
        bt_toggle_text2 = (ImageButton) view.findViewById(R.id.bt_toggle_text2);
        bt_toggle_text3 = (ImageButton) view.findViewById(R.id.bt_toggle_text3);
        lyt_expand_text = (View) view.findViewById(R.id.lyt_expand_text);
        lyt_expand_text2 = (View) view.findViewById(R.id.lyt_expand_text2);
        lyt_expand_text3 = (View) view.findViewById(R.id.lyt_expand_text3);
        nested_scroll_view = (NestedScrollView) view.findViewById(R.id.nested_scroll_view);
        lyt_expand_text.setVisibility(View.GONE);
        lyt_expand_text2.setVisibility(View.GONE);
        lyt_expand_text3.setVisibility(View.GONE);
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
}