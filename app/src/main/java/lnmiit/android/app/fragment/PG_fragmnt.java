package lnmiit.android.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PG_fragmnt extends Fragment {


    public PG_fragmnt() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pg_fragmnt, container, false);
    }

}
