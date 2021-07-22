package admin.maarula.admin.maarula.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import admin.maarula.admin.maarula.Adapter.TestContanierAdapter;
import admin.maarula.admin.maarula.Models.TestContainer;
import admin.maarula.admin.maarula.R;

public class TestsFragment extends Fragment {
    ArrayList<TestContainer> parentModelArrayList = new ArrayList<>();
    private RecyclerView parentRecyclerView;
    private RecyclerView.Adapter ParentAdapter;
    private RecyclerView.LayoutManager parentLayoutManager;
    private CardView card_1, card_2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tests, container, false);

        card_1 = view.findViewById(R.id.card_1);
        card_2 = view.findViewById(R.id.card_2);
        parentRecyclerView = view.findViewById(R.id.testRecycler);
        parentModelArrayList.clear();
        parentModelArrayList.add(new TestContainer("NIMCET TARGET 2021", false));
        parentModelArrayList.add(new TestContainer("BHU TARGET 2021", false));
        parentModelArrayList.add(new TestContainer("JNU TARGET 2021", false));
        parentModelArrayList.add(new TestContainer("REASONING TARGET 2021", false));
        parentModelArrayList.add(new TestContainer("COMPUTER TARGET 2021", false));
        parentModelArrayList.add(new TestContainer("MATH TARGET NIMCET", false));
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager = new LinearLayoutManager(getContext());
        ParentAdapter = new TestContanierAdapter(parentModelArrayList, getContext());
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentRecyclerView.setAdapter(ParentAdapter);
        ParentAdapter.notifyDataSetChanged();
        card_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentModelArrayList.clear();
                parentModelArrayList.add(new TestContainer("NIMCET TARGET 2021", false));
                parentModelArrayList.add(new TestContainer("BHU TARGET 2021", false));
                parentModelArrayList.add(new TestContainer("JNU TARGET 2021", false));
                parentModelArrayList.add(new TestContainer("REASONING TARGET 2021", false));
                parentModelArrayList.add(new TestContainer("COMPUTER TARGET 2021", false));
                parentModelArrayList.add(new TestContainer("MATH TARGET NIMCET", false));
                parentRecyclerView.setHasFixedSize(true);
                parentLayoutManager = new LinearLayoutManager(getContext());
                ParentAdapter = new TestContanierAdapter(parentModelArrayList, getContext());
                parentRecyclerView.setLayoutManager(parentLayoutManager);
                parentRecyclerView.setAdapter(ParentAdapter);
                ParentAdapter.notifyDataSetChanged();
            }
        });
        card_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parentModelArrayList.clear();
                parentModelArrayList.add(new TestContainer("NIMCET TARGET 2021", true));
                parentModelArrayList.add(new TestContainer("BHU TARGET 2021", true));
                parentModelArrayList.add(new TestContainer("JNU TARGET 2021", true));
                parentRecyclerView.setHasFixedSize(true);
                parentLayoutManager = new LinearLayoutManager(getContext());
                ParentAdapter = new TestContanierAdapter(parentModelArrayList, getContext());
                parentRecyclerView.setLayoutManager(parentLayoutManager);
                parentRecyclerView.setAdapter(ParentAdapter);
                ParentAdapter.notifyDataSetChanged();
            }
        });
        //set the Categories for each array list set in the `ParentViewHolder`

        return view;
    }

}