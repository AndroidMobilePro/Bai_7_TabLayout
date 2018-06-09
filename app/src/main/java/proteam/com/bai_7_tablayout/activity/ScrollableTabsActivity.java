package proteam.com.bai_7_tablayout.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import proteam.com.bai_7_tablayout.R;
import proteam.com.bai_7_tablayout.fragments.Fragment1;
import proteam.com.bai_7_tablayout.fragments.Fragment10;
import proteam.com.bai_7_tablayout.fragments.Fragment2;
import proteam.com.bai_7_tablayout.fragments.Fragment3;
import proteam.com.bai_7_tablayout.fragments.Fragment4;
import proteam.com.bai_7_tablayout.fragments.Fragment5;
import proteam.com.bai_7_tablayout.fragments.Fragment6;
import proteam.com.bai_7_tablayout.fragments.Fragment7;
import proteam.com.bai_7_tablayout.fragments.Fragment8;
import proteam.com.bai_7_tablayout.fragments.Fragment9;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment1(), "ONE");
        adapter.addFrag(new Fragment2(), "TWO");
        adapter.addFrag(new Fragment3(), "THREE");
        adapter.addFrag(new Fragment4(), "FOUR");
        adapter.addFrag(new Fragment5(), "FIVE");
        adapter.addFrag(new Fragment6(), "SIX");
        adapter.addFrag(new Fragment7(), "SEVEN");
        adapter.addFrag(new Fragment8(), "EIGHT");
        adapter.addFrag(new Fragment9(), "NINE");
        adapter.addFrag(new Fragment10(), "TEN");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
