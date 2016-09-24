package lnmiit.android.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.android.app.R;
import lnmiit.android.app.adapter.GymkhanaAdapter;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class Gymkhana extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View gymkhanaView = inflater.inflate(R.layout.fragment_council, container, false);
        recyclerView = (RecyclerView) gymkhanaView.findViewById(R.id.recycle_council);
        adapter = new GymkhanaAdapter(getContext());
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return gymkhanaView;
    }

}
