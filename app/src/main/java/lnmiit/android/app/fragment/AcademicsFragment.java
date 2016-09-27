package lnmiit.android.app.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import lnmiit.android.app.R;
import lnmiit.android.app.adapter.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcademicsFragment extends Fragment {

    Toolbar tb;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    public AcademicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_academics, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewpagr);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new UG_fragmnt(),"UG");
        viewPagerAdapter.addFragment(new PG_fragmnt(),"PG");
        viewPagerAdapter.addFragment(new Scholars_fragmnt(),"LNM Scholars");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;

    }

}
