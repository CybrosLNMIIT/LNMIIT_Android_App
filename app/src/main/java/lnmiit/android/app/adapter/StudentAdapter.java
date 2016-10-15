package lnmiit.android.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class StudentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();

    public StudentAdapter(FragmentManager fm)
    {
        super(fm);
    }

    /**
     * adding all fragments to a list
     * @param fragment fragment
     * @param title1 title of the fragment
     */
    public void addFragments(Fragment fragment,String title1)
    {
        fragments.add(fragment);
        title.add(title1);
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}