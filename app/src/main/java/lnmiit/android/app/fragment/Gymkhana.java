package lnmiit.android.app.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import lnmiit.android.app.R;
import lnmiit.android.app.adapter.FacultyAdapter;
import lnmiit.android.app.model.FacultyDetails;
/**
 * Created by Chanpreet on 15/10/16.
 */
public class Gymkhana extends Fragment {

    private RecyclerView recyclerView;
    private FacultyAdapter adapter;
    private List<FacultyDetails> list;
    private String imageUrl[], name[], designation[], email[], phone[];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gymkhana, container, false);

        imageUrl = getResources().getStringArray(R.array.links);
        name = getResources().getStringArray(R.array.gymkhana);
        designation = getResources().getStringArray(R.array.designation);
        email = getResources().getStringArray(R.array.gymkhana_email);
        phone = getResources().getStringArray(R.array.gymkhana_contact);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_gymkhana);

        list = new ArrayList<>();
        adapter = new FacultyAdapter(getContext(), list);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
        } else {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
            recyclerView.setLayoutManager(mLayoutManager);
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadFacultyDetails();

        return view;
    }

    /**
     * This method is used for storing Gymkhana
     * details in an arraylist
     */
    private void loadFacultyDetails() {
        for (int i = 0; i < imageUrl.length; i++) {
            list.add(new FacultyDetails(name[i], designation[i], imageUrl[i], email[i], phone[i]));
        }
        adapter.notifyDataSetChanged();
    }
}

