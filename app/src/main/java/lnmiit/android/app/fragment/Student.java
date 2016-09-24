package lnmiit.android.app.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import lnmiit.android.app.R;
import lnmiit.android.app.adapter.StudentAdapter;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class Student extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView studentImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View x;
        x = inflater.inflate(R.layout.fragment_student, container, false);
        tabLayout = (TabLayout) x.findViewById(R.id.student_tab);
        viewPager = (ViewPager) x.findViewById(R.id.student_viewpager);
        studentImage = (ImageView) x.findViewById(R.id.student_image);
        Glide.with(getContext()).load("http://bit.ly/2ct7QkP").into(studentImage);
        StudentAdapter studentAdapter = new StudentAdapter(getChildFragmentManager());
        studentAdapter.addFragments(new Council(), "Councils");
        studentAdapter.addFragments(new Fest(), "Fest");
        studentAdapter.addFragments(new Gymkhana(), "Gymkhana");
        viewPager.setAdapter(studentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return x;
    }
}
