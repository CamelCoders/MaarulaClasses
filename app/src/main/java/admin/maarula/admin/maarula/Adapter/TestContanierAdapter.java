package admin.maarula.admin.maarula.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Models.TestContainer;
import admin.maarula.admin.maarula.Models.TestContainerChild;
import admin.maarula.admin.maarula.R;

public class TestContanierAdapter extends RecyclerView.Adapter<TestContanierAdapter.MyViewHolder> {
    private final ArrayList<TestContainer> testContainerArrayList;
    public Context cxt;

    public TestContanierAdapter(ArrayList<TestContainer> exampleList, Context context) {
        this.testContainerArrayList = exampleList;
        this.cxt = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_container_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return testContainerArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        TestContainer currentItem = testContainerArrayList.get(position);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);
        holder.testMainTitle.setText(currentItem.getTestMainTitle());
        ArrayList<TestContainerChild> arrayList = new ArrayList<>();

        // added the first child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("NIMCET TARGET 2021")) {
            arrayList.add(new TestContainerChild("Model Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 6", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("Model Test Paper 7", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }

        // added in second child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("BHU TARGET 2021")) {
            arrayList.add(new TestContainerChild("BHU Model Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("BHU Model Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("BHU Model Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("BHU Model Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("BHU Model Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }

        // added in third child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("JNU TARGET 2021")) {
            arrayList.add(new TestContainerChild("JNU Model Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("JNU Model Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("JNU Model Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("JNU Model Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("JNU Model Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }

        // added in fourth child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("REASONING TARGET 2021")) {
            arrayList.add(new TestContainerChild("REASONING Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("REASONING Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("REASONING Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("REASONING Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("REASONING Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }

        // added in fifth child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("COMPUTER TARGET 2021")) {
            arrayList.add(new TestContainerChild("COMPUTER Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("COMPUTER Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("COMPUTER Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("COMPUTER Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("COMPUTER Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }

        // added in sixth child row
        if (testContainerArrayList.get(position).getTestMainTitle().equals("MATH TARGET NIMCET")) {
            arrayList.add(new TestContainerChild("MATH Test Paper 1", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("MATH Test Paper 2", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("MATH Test Paper 3", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("MATH Test Paper 4", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
            arrayList.add(new TestContainerChild("MATH Test Paper 5", "3 hours 15 minutes", testContainerArrayList.get(position).isAttempted()));
        }


        TestContanierChildAdapter childRecyclerViewAdapter = new TestContanierChildAdapter(arrayList, holder.childRecyclerView.getContext());
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView testMainTitle;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            testMainTitle = itemView.findViewById(R.id.mainTextViewTitle);
            childRecyclerView = itemView.findViewById(R.id.rv_child);
        }
    }
}