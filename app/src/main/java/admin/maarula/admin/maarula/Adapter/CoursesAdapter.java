package admin.maarula.admin.maarula.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import admin.maarula.admin.maarula.Interface.CoursesItemClickListener;
import admin.maarula.admin.maarula.Models.Courses;
import admin.maarula.admin.maarula.R;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyViewHolder> {

    Context context;
    List<Courses> mData;
    CoursesItemClickListener coursesItemClickListener;

    public CoursesAdapter(Context context, List<Courses> mData, CoursesItemClickListener listener) {
        this.context = context;
        this.mData = mData;
        coursesItemClickListener = listener;
    }


    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {


        myViewHolder.TvTitle.setText(mData.get(i).getTitle());
        myViewHolder.ImgMovie.setImageResource(mData.get(i).getThumbnail());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private final TextView TvTitle;
        private final ImageView ImgMovie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TvTitle = itemView.findViewById(R.id.item_item_course_img_title);
            ImgMovie = itemView.findViewById(R.id.item_course_img);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    coursesItemClickListener.onCourseClick(mData.get(getAdapterPosition()), ImgMovie);
                }
            });
        }
    }
}
