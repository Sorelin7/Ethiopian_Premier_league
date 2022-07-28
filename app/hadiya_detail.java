package com.group_d.ethiopianpremierleague;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class hadiya_detail extends AppCompatActivity {

private Toolbar toolbar;
private ViewPager viewPager;
private TabLayout tabLayout;
private About_hadiya about;
private hadiya_matches matches;
private hadiya_squad squad;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ehiobunadetail);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab_layout);
        Resources resources =getResources();
        allocateactivitytitle(resources.getString(R.string.hadiya));
        about=new About_hadiya();
        squad= new hadiya_squad();
        matches= new hadiya_matches();
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragments(about,"");
        viewPagerAdapter.addFragments(matches,"");
        viewPagerAdapter.addFragments(squad,"");
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout.getTabAt(0).setText(resources.getString(R.string.about));
        tabLayout.getTabAt(1).setText(resources.getString(R.string.matches));
        tabLayout.getTabAt(2).setText(resources.getString(R.string.squad));

//        BadgeDrawable badgeDrawable= tabLayout.getTabAt(0).getOrCreateBadge();
//        badgeDrawable.setVisible(true);
//        badgeDrawable.setNumber(5);



    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments=new ArrayList<>();

        private List<String> fragmentTitles=new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        public void addFragments(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }
    protected void allocateactivitytitle(String titlestring)
    {
        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(titlestring);
        }
    }
}