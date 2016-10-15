package lnmiit.android.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lnmiit.android.app.R;
import lnmiit.android.app.adapter.CouncilFestAdapter;
import lnmiit.android.app.model.CouncilFestDetail;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class Fest extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<CouncilFestDetail> list = new ArrayList<>();
    private String festName[];
    private String festDescription[];
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View festView = inflater.inflate(R.layout.fragment_fest, container, false);
        recyclerView = (RecyclerView) festView.findViewById(R.id.recycle_fest);
        festName = getResources().getStringArray(R.array.fest_name);
        festDescription = getResources().getStringArray(R.array.fest_des);

        adapter = new CouncilFestAdapter(getActivity().getApplicationContext(),list);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        loadFestDetails();
        return festView;
    }
    /**
     * This method is used for storing Fest
     * details in an arraylist
     */
    private void loadFestDetails() {
        for (int i = 0; i < festDescription.length; i++) {
            list.add(new CouncilFestDetail(festName[i], festDescription[i]));
        }
        adapter.notifyDataSetChanged();
    }
}
