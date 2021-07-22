package admin.maarula.admin.maarula.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Models.LiveClassSlider;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.databinding.VideoSliderItemBinding;


public class LiveClassSliderAdapter extends RecyclerView.Adapter<LiveClassSliderAdapter.MyViewHolder> {

    ArrayList<LiveClassSlider> liveClassSliderArrayList;
    Context context;

    public LiveClassSliderAdapter(ArrayList<LiveClassSlider> liveClassSliderArrayList, Context context) {
        this.context = context;
        this.liveClassSliderArrayList = liveClassSliderArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(VideoSliderItemBinding.inflate(li));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.tvName.setText(liveClassSliderArrayList.get(position).name + "");

        liveClassSliderArrayList.get(position).slide_no = (position + 1) + "/" + liveClassSliderArrayList.size() + "";
        holder.binding.tvSlideNumber.setText(liveClassSliderArrayList.get(position).slide_no + "");
        //Setting Image before loading view
        String imageUrl = liveClassSliderArrayList.get(position).img_thumb + "";
        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_play).error(R.drawable.logo);

        Glide.with(context).load(imageUrl).apply(options).into(holder.binding.imageView);
        holder.binding.imageView.setVisibility(View.VISIBLE);
        try {
            final String uriPath = liveClassSliderArrayList.get(position).video_url;
            holder.binding.videoView.setVideoPath(uriPath);
            holder.binding.videoView.requestFocus();
            holder.binding.videoView.start();
            holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Log.d("inside", "onPrepared");
                    holder.binding.videoView.seekTo(0);
                    mp.setLooping(true);
                    mp.setVolume(0, 0); //== to mute volume
                    //mp.setVolume(1,1);
                    mp.start();
                    holder.binding.imageView.setVisibility(View.GONE);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return liveClassSliderArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        VideoSliderItemBinding binding;

        MyViewHolder(VideoSliderItemBinding videoSliderItem) {
            super(videoSliderItem.getRoot());
            binding = videoSliderItem;
        }
    }
}
