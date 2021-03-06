package about.tfad.fraggel.es.tfabout;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class aboutSwipe extends Activity implements ActionBar.TabListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_swipe);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
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
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment(){
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    View rootView = inflater.inflate(R.layout.fragment_team_swipe, container,
                            false);
                    rootView.findViewById(R.id.imageButtonLogo).setOnClickListener(this);
                    return rootView;
                case 2:
                    View rootView2 = inflater.inflate(R.layout.fragment_changelog_swipe, container,
                            false);
                    rootView2.findViewById(R.id.imageButtonRom).setOnClickListener(this);
                    return rootView2;

                case 3:
                    View rootView3 = inflater.inflate(R.layout.fragment_links_swipe, container,
                            false);
                    rootView3.findViewById(R.id.imageButtonLogo).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonFacebook).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonGoogle).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonRss).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonTwitter).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonWeb).setOnClickListener(this);
                    rootView3.findViewById(R.id.imageButtonYoutube).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewFacebook).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewGoogle).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewRss).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewTwitter).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewWeb).setOnClickListener(this);
                    rootView3.findViewById(R.id.textViewYoutube).setOnClickListener(this);
                    return rootView3;
                default:
                    return null;
            }
        }

        @Override
        public void onClick(View view) {
            int id=view.getId();
            String url =null;
            Intent i = new Intent(Intent.ACTION_VIEW);
            if(id==R.id.imageButtonLogo){
                url=getResources().getString(R.string.urlWeb);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonRom){
                url=getResources().getString(R.string.urlRom);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonFacebook || id==R.id.textViewFacebook){
                url=getResources().getString(R.string.urlFacebook);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonGoogle || id==R.id.textViewGoogle){
                url=getResources().getString(R.string.urlGoogle);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonRss || id==R.id.textViewRss){
                url=getResources().getString(R.string.urlRss);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonTwitter || id==R.id.textViewTwitter){
                url=getResources().getString(R.string.urlTwitter);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonWeb || id==R.id.textViewWeb){
                url=getResources().getString(R.string.urlWeb);
                i.setData(Uri.parse(url));
            }if(id==R.id.imageButtonYoutube || id==R.id.textViewYoutube){
                url=getResources().getString(R.string.urlYoutube);
                i.setData(Uri.parse(url));
            }
            startActivity(i);
        }
    }

}
