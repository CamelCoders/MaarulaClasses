package admin.maarula.admin.maarula.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import admin.maarula.admin.maarula.Models.ContentItem;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.ItemAnimation;

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context ctx;
    private List<ContentItem> items = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;
    private int animation_type = 0;
    private int lastPosition = -1;
    private boolean on_attach = true;

    public ContentAdapter(Context context, List<ContentItem> items, int animation_type) {
        this.items = items;
        ctx = context;
        this.animation_type = animation_type;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            view.titleMain.setText(items.get(position).getTitleMain());
            view.titleSub.setText(items.get(position).getTitleSub());
            setAnimation(view.itemView, position);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            ItemAnimation.animate(view, on_attach ? position : -1, animation_type);
            lastPosition = position;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, ContentItem obj, int position);
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public TextView titleMain, titleSub;

        public OriginalViewHolder(View v) {
            super(v);
            titleMain = (TextView) v.findViewById(R.id.titleMain);
            titleSub = (TextView) v.findViewById(R.id.titleSub);
        }
    }

}