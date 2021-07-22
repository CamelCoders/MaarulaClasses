package admin.maarula.admin.maarula.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Activity.TestReportActivity;
import admin.maarula.admin.maarula.Models.TestContainerChild;
import admin.maarula.admin.maarula.R;
import admin.maarula.admin.maarula.Utils.AppConfig;

public class TestContanierChildAdapter extends RecyclerView.Adapter<TestContanierChildAdapter.MyViewHolder> {
    public ArrayList<TestContainerChild> testContainerChildArrayList;
    Context cxt;

    public TestContanierChildAdapter(ArrayList<TestContainerChild> arrayList, Context mContext) {
        this.cxt = mContext;
        this.testContainerChildArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_container_child_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TestContainerChild currentItem = testContainerChildArrayList.get(position);
        holder.testTitle.setText(currentItem.getTestTitle());
        holder.testDuration.setText(currentItem.getTestDuration());
        if (currentItem.isFromAttempted()) {
            holder.viewReport.setVisibility(View.VISIBLE);
            holder.attemptButton.setText("REATTEMPT");
            holder.testDuration.setText(currentItem.getTestDuration() + " Score: 80/80");
            holder.viewReport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppConfig.jumpTo((Activity) cxt, TestReportActivity.class, "fade");
                }
            });
        } else {
            holder.viewReport.setVisibility(View.INVISIBLE);
        }
        holder.attemptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.showConfirmDialog(cxt, "Instructions", "R.string.ConfirmationString");
            }
        });
    }

    @Override
    public int getItemCount() {
        return testContainerChildArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView testTitle;
        public TextView testDuration;
        public TextView attemptButton;
        public TextView viewReport;

        public MyViewHolder(View itemView) {
            super(itemView);
            testTitle = itemView.findViewById(R.id.testTitle);
            testDuration = itemView.findViewById(R.id.testDuration);
            attemptButton = itemView.findViewById(R.id.attemptButton);
            viewReport = itemView.findViewById(R.id.viewReport);
        }
    }
}
