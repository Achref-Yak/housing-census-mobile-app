package com.snit.snitressenement.ui.main.Adapters;

import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.Fragments.ficheTechnique;
import com.snit.snitressenement.ui.main.Fragments.Etat;
import com.snit.snitressenement.ui.main.Fragments.proprietaires;
import com.snit.snitressenement.ui.main.Fragments.descG;
import com.snit.snitressenement.ui.main.Fragments.Gallery;
import com.snit.snitressenement.ui.main.Fragments.Missions_traite;

public class MissionPagerAdpater extends FragmentStatePagerAdapter  {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_3, R.string.tab_text_4,R.string.tab_text_5,R.string.tab_text_6};
    private final Context mContext;
    private String TF;
    public String page="dfs";
    public Fragment fragment;



    public MissionPagerAdpater(Context context, FragmentManager fm,String TF) {
        super(fm);
        mContext = context;
        this.TF = TF;

    }



    @Override
    public Fragment getItem(int position) {
         fragment = null;
        ViewPager viewPager;
        switch (position) {
            case 0 :

                page = "Fiche Technique";

                fragment = ficheTechnique.newInstance("","");

                break;
            case 1 :

                page = "Etat";
                fragment = Etat.newInstance("1","0");

                break;
            case 2 :

                page = "Description General";
                fragment = descG.newInstance("1","0");

                break;
            case 3 :
                page = "Proprietaires";
                fragment = proprietaires.newInstance("1","0");
                break;





        }

        return fragment;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 4;
    }

    public void updatePage(){
        notifyDataSetChanged();
    }
}
