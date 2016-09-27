package lnmiit.android.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import lnmiit.android.app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UG_fragmnt extends Fragment {
    TextView ece,cse,mme,cce,me;
    Button cce_butn,cse_butn,ece_butn,mme_butn,me_butn;


    public UG_fragmnt() {
        // Required empty public constructor

          }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ug_fragmnt, container, false);
        ece = (TextView) view.findViewById(R.id.about_ece);
        cce = (TextView) view.findViewById(R.id.about_cce);
        cse = (TextView) view.findViewById(R.id.about_cse);
        mme = (TextView) view.findViewById(R.id.about_mech);
        me = (TextView) view.findViewById(R.id.about_me);

        cce.setVisibility(View.GONE);
        ece.setVisibility(View.GONE);
        cse.setVisibility(View.GONE);
        mme.setVisibility(View.GONE);
        me.setVisibility(View.GONE);

        cce_butn = (Button) view.findViewById(R.id.b_cce);
        ece_butn = (Button) view.findViewById(R.id.b_ece);
        cse_butn = (Button) view.findViewById(R.id.b_cse);
        mme_butn = (Button) view.findViewById(R.id.b_mme);
        me_butn = (Button) view.findViewById(R.id.b_me);


        mme_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mme.setVisibility((mme.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

        cce_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cce.setVisibility((cce.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

        cse_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cse.setVisibility((cse.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });


        me_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                me.setVisibility((me.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });

        ece_butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ece.setVisibility((ece.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.VISIBLE);

            }
        });
        return view;


    }

}
