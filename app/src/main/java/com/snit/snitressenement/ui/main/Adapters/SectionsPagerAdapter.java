package com.snit.snitressenement.ui.main.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.Fragments.Missions;
import com.snit.snitressenement.ui.main.Fragments.Missions_traite;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private static String fragmentPara ="EDIT";

    public String fragValue="0";

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
                case 0 :

                    fragment = Missions.newInstance("0","0");
                    break;
                case 1 :
                    fragment = Missions_traite.newInstance("1","0");
                    break;




        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }
}