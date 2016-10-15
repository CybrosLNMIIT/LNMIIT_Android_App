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
public class Council extends Fragment {
        private RecyclerView recyclerView;
        private ArrayList<CouncilFestDetail> list = new ArrayList();
        private RecyclerView.Adapter adapter;
        private String councilName[];
        private String councilDesscription[];
        private LinearLayoutManager linearLayoutManager;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View councilView = inflater.inflate(R.layout.fragment_council, container, false);
            recyclerView = (RecyclerView) councilView.findViewById(R.id.recycle_council);
            councilName = getResources().getStringArray(R.array.council);
            councilDesscription =getResources().getStringArray(R.array.description);

            adapter = new CouncilFestAdapter(getActivity().getApplicationContext(),list);
            linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
            loadCouncilDetails();
            return councilView;
        }

    /**
     * This method is used for storing Council
     * details in an arraylist
     */
    private void loadCouncilDetails() {
        for (int i = 0; i < councilName.length; i++) {
            list.add(new CouncilFestDetail(councilName[i], councilDesscription[i]));
        }
        adapter.notifyDataSetChanged();
    }

    }

