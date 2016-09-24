package lnmiit.android.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.android.app.R;
import lnmiit.android.app.adapter.FestAdapter;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class Fest extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View festView = inflater.inflate(R.layout.fragment_fest, container, false);
        recyclerView = (RecyclerView) festView.findViewById(R.id.recycle_fest);
        adapter = new FestAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return festView;
    }
}

