package lnmiitmadclub.lnmiit.fragments;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lnmiitmadclub.lnmiit.R;
import lnmiitmadclub.lnmiit.adapter.FacultyAdapter;
import lnmiitmadclub.lnmiit.model.FacultyDetails;


/**
 * Created by dexter on 21/8/16.
 */
public class FacultyFragment extends Fragment {

    private RecyclerView recyclerView ;
    private FacultyAdapter adapter;
    private List<FacultyDetails> facultyList;
    private String imageUrl[] , faculty_name[] , faculty_designation[] , faculty_email[] , faculty_phone[];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        /*
            getting the string array from string.xml for the cse faculty
         */
        imageUrl = getResources().getStringArray(R.array.cse_faculty_url);
        faculty_name = getResources().getStringArray(R.array.cse_faculty_name);
        faculty_designation = getResources().getStringArray(R.array.cse_faculty_designation);
        faculty_email = getResources().getStringArray(R.array.cse_faculty_email);
        faculty_phone = getResources().getStringArray(R.array.cse_faculty_contact);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        facultyList = new ArrayList<>();
        adapter = new FacultyAdapter(getContext(), facultyList);


        /*
        *   Conditional stmt to check for the orientation of mobile
        *   if orientation is landscape then show 3 items in grid
        *   otherwise show 2 items
         */
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        }else{
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        }


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadFacultyDetails();

        return view ;
    }

    private void loadFacultyDetails() {
        FacultyDetails a = null ;
        for(int i = 0 ; i < imageUrl.length ; i++){
            facultyList.add(new FacultyDetails(faculty_name[i], faculty_designation[i],imageUrl[i],faculty_email[i],faculty_phone[i]));
        }
        adapter.notifyDataSetChanged();
    }


    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
