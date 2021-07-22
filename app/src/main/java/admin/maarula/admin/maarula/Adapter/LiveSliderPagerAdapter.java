package admin.maarula.admin.maarula.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import admin.maarula.admin.maarula.Models.LiveClassSliders;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;

public class LiveSliderPagerAdapter extends PagerAdapter {

    private final Context mContext;
    private final List<LiveClassSliders> mList;


    public LiveSliderPagerAdapter(Context mContext, List<LiveClassSliders> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slide_item, null);


        ImageView slideImg = slideLayout.findViewById(R.id.slide_img);
        ImageView isLive = slideLayout.findViewById(R.id.is_live);
        TextView slideText = slideLayout.findViewById(R.id.slide_title);
        FloatingActionButton playBtn = slideLayout.findViewById(R.id.floatingActionButton);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, MoviePlayerActivity.class);
//                mContext.startActivity(intent);
                AppConfig.showwCustomToast((Activity) mContext, "", "Play");
            }
        });
        slideImg.setImageResource(mList.get(position).getImage());
        slideText.setText(mList.get(position).getTitle());
        if (mList.get(position).isLive()) {
            isLive.setVisibility(View.VISIBLE);
        } else {
            isLive.setVisibility(View.INVISIBLE);
        }

        container.addView(slideLayout);
        return slideLayout;


    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
