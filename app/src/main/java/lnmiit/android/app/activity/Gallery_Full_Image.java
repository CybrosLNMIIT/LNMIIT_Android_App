package lnmiit.android.app.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import lnmiit.android.app.R;
import lnmiit.android.app.fragment.GalleryFragment;

public class Gallery_Full_Image extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(GalleryFragment.ICONS[position]);

    }

}