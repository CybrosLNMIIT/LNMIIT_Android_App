package lnmiit.android.app.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import lnmiit.android.app.R;
import lnmiit.android.app.fragment.AboutUsFragment;
import lnmiit.android.app.fragment.AcademicsFragment;
import lnmiit.android.app.fragment.AdministrationFragment;
import lnmiit.android.app.fragment.AdmissionsFragment;
import lnmiit.android.app.fragment.EmergencyFragment;
import lnmiit.android.app.fragment.FacultyFragment;
import lnmiit.android.app.fragment.HomeFragment;
import lnmiit.android.app.fragment.MapFragment;
import lnmiit.android.app.fragment.StudentFragment;

/* Created by Chanpreet
   on 11 August 2016
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ImageView imageView ;
    private CollapsingToolbarLayout collapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        imageView = (ImageView)findViewById(R.id.backdrop);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new HomeFragment();
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout_container, fragment);
            fragmentTransaction.commit();
        }
    }

    public  TabLayout getTabLayout(){
        return  tabLayout;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // TODO : Add Fragments for other branches
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Fragment fragment = null;

        int id = item.getItemId();
        if(id == R.id.home){
            collapsingToolbar.setVisibility(View.VISIBLE);
          fragment = new HomeFragment();
            getSupportActionBar().setTitle("LNMIIT");
            Glide.with(this).load(R.drawable.pic).into(imageView);
        } else if (id == R.id.academics) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new AcademicsFragment();
            getSupportActionBar().setTitle("Academics");
        } else if (id == R.id.admission) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new AdmissionsFragment();
            getSupportActionBar().setTitle("Admissions");
        } else if (id == R.id.placement) {
        } else if (id == R.id.administration) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new AdministrationFragment();
            getSupportActionBar().setTitle("Administration");
        } else if (id == R.id.faculty) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new FacultyFragment();
            getSupportActionBar().setTitle("Faculty");
        } else if (id == R.id.student) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new StudentFragment();
            Glide.with(this).load(R.drawable.student).into(imageView);
            getSupportActionBar().setTitle("Student");
        } else if (id == R.id.emergency) {
            collapsingToolbar.setVisibility(View.VISIBLE);
            fragment = new EmergencyFragment();
            getSupportActionBar().setTitle("Emergency");
        } else if (id == R.id.bus) {
        } else if (id == R.id.map) {
            collapsingToolbar.setVisibility(View.GONE);
            fragment= new MapFragment();
        } else if (id == R.id.dining) {
        } else if (id == R.id.gallery) {
        } else if (id == R.id.about) {
            fragment = new AboutUsFragment();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout_container, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
