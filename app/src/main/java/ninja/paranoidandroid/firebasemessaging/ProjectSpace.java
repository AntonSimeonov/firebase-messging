package ninja.paranoidandroid.firebasemessaging;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import ninja.paranoidandroid.firebasemessaging.fragment_tab.ChatFragment;
import ninja.paranoidandroid.firebasemessaging.fragment_tab.ProjectPlaningFragment;
import ninja.paranoidandroid.firebasemessaging.fragment_tab.TaskListFragment;

public class ProjectSpace extends AppCompatActivity implements ChatFragment.OnFragmentInteractionListener{


    //Log
    private final static String TAG = "ProjectSpace";

    //UI
    private SectionsPagerAdapter mSectionsPagerAdapter;

    //Firebase


    //Business
    private String mProjectKey;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_space);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        mProjectKey = getIntent().getStringExtra("PROJECT_KEY");
        Log.i("Project space", "cOMPANY Key is " + mProjectKey);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProjectSpace.this, AddTask.class);
                intent.putExtra("TASK_COMPANY_KEY", mProjectKey);
                startActivity(intent);

            }
        });

    }

    public String getmProjectKey() {
        return mProjectKey;
    }

    public void setmProjectKey(String mProjectKey) {
        this.mProjectKey = mProjectKey;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project_space, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return TaskListFragment.newInstance(position);
                case 1:
                    return ProjectPlaningFragment.newInstance(position);
                case 2:
                    return ChatFragment.newInstance(position);
                default:
                    break;
            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PROJECT TASKS";
                case 1:
                    return "PROJECT PLANS";
                case 2:
                    return "CHAT";
            }
            return null;
        }
    }
}
