package admin.maarula.admin.maarula.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import admin.maarula.admin.maarula.Models.CourseDetail;
import admin.maarula.admin.maarula.R;

public class CourseDetailAdapter extends RecyclerView.Adapter<CourseDetailAdapter.MyCourseViewHolder> {

    Context mContext;
    List<CourseDetail> mData;

    public CourseDetailAdapter(Context mContext, List<CourseDetail> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyCourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_cast, viewGroup, false);
        return new MyCourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseViewHolder castViewHolder, int position) {

        Glide.with(mContext).load(mData.get(position).getImg_link()).into(castViewHolder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyCourseViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public MyCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_cast);
        }
    }
}
