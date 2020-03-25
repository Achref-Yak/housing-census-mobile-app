package com.snit.snitressenement;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;


import com.snit.snitressenement.ui.main.Adapters.MissionPagerAdpater;

    // Fiche
public class MissionActivity extends AppCompatActivity {

    public ViewPager vp;
    public String TF;
    public TextView mPage;
    public int dotscount;
    public String Page;
    LinearLayout sliderDotspanel;
    public ImageView[] dots;
    public MissionPagerAdpater missionPagerAdpater;
    public FloatingActionButton fab, fab1, fab2;
    public Animation fabOpen, fabClose, rotateForward,rotateBackward;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();

        /*findViewById(R.id.pink_icon).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });*/


        TF = extras.getString("TF");
        System.out.println("TF : "+ TF);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mission_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        fab =  findViewById(R.id.fabAdd);
        fab1 =  findViewById(R.id.fabImage);
        fab2 =  findViewById(R.id.fabGallery);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });
        missionPagerAdpater = new MissionPagerAdpater(this, getSupportFragmentManager(),TF);
        vp = findViewById(R.id.mission_view_pager);
        vp.setAdapter(missionPagerAdpater);
        mPage = findViewById(R.id.pageTitle);
        sliderDotspanel = (LinearLayout) findViewById(R.id.dotsSider);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                String page = "Fiche Technique";
                switch (position){
                    case 0:
                        page = "Fiche Technique";
                        break;
                    case 1:
                        page = "Etat";
                        break;
                    case 2:
                        page = "Descriptif General";
                        break;
                    case 3:
                        page = "Proprietaires";
                        break;
                }
              mPage.setText(page);
            }
        });
         dotscount = missionPagerAdpater.getCount();
        dots = new ImageView[dotscount];

        for (int i= 0; i<dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.dotd));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);


        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dota));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dotd));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dota));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });










    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.primary_menu, menu);
            return true;
        }
        private void animateFab()
        {

            if(isOpen){
                fab.startAnimation(rotateBackward);
                fab1.startAnimation(fabClose);
                fab2.startAnimation(fabClose);
                fab1.setClickable(false);
                fab1.setClickable(false);
                isOpen=false;
            }
            else {
                fab.startAnimation(rotateForward);
                fab1.startAnimation(fabOpen);
                fab2.startAnimation(fabOpen);
                fab1.setClickable(true);
                fab1.setClickable(true);
                isOpen=true;
            }
        }


}
