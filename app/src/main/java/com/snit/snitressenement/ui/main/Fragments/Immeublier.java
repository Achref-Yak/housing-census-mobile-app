package com.snit.snitressenement.ui.main.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import 	android.widget.EditText;
import android.widget.ListView;
import 	android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.Adapters.PropListAdapter;
import com.snit.snitressenement.ui.main.Adapters.GalleryAdapter;
import com.snit.snitressenement.ui.main.MissionData.ImmeubleModel;
import com.snit.snitressenement.ui.main.MissionData.ImmeublierDataManager;
import com.snit.snitressenement.ui.main.MissionData.PropListData;

import com.snit.snitressenement.ui.main.MissionData.Proprietaire;

import java.util.ArrayList;


public class Immeublier extends Fragment implements AjouterPropDialog.OnInputSelected, CalendarDialog.Date1Listner, CalendarAqDialog.Date2Listner,CalendarTransDialog.Date3Listner{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";


    private Button btnCapture;
    private Button date1;
    private Button date2;
    private Button date3;
    private ImageView imgCapture;
    private static final int Image_Capture_Code = 1;

    private ArrayList<String> mImageUrls = new ArrayList<>();

    GPSTracker gps;





    Button submitButton;
    Button AjouterProp;

    //Identifiant
    public TextView mTF;
    TextView mCodeImmeuble;
    TextView mEtat;

    //Adresse
    EditText mGouv;
    TextView mLon;
    TextView mLat;

    //Fiche Technique
    EditText mNbrOrdre;
    RadioGroup mCategorie;
    RadioGroup mPlan;
    EditText mNbrEtage;
    EditText mNbrLocal;

    //ETAT

    //PROP
    TextView mDate1;
    TextView mDate2;
    TextView mDate3;

    EditText midentV;
    EditText mNatioV;

    //Descriptif general
    RadioGroup mDescGen;
    PropListAdapter propAdapter;


    FragmentManager fragmentManager;

    Button btnShowLocation;
    Bundle bundle;






    // TODO: Rename and change types of parameters
    public String Edit = "0";
    private String TF;


    ArrayList PropList;

    private OnFragmentInteractionListener mListener;

    public Immeublier() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Immeublier newInstance(String TF) {
        Immeublier fragment = new Immeublier();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM2, TF);


        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            TF = getArguments().getString(ARG_PARAM2);

        }

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bundle = new Bundle();
        final View view = inflater.inflate(R.layout.missions_fiche, container, false);

        ImmeublierDataManager immeublierDataManager = new ImmeublierDataManager(TF);
        ImmeubleModel immeuble  = immeublierDataManager.getInstance().getImmeuble();
        System.out.println(immeuble);

        getImages(view);

        mDate1 = (TextView) view.findViewById(R.id.DateV1);
        mDate2 = (TextView) view.findViewById(R.id.DateV2);
        mDate3 = (TextView) view.findViewById(R.id.DateV3);



        btnCapture =(Button) view.findViewById(R.id.btnTakePicture);
        //imgCapture = (ImageView) view.findViewById(R.id.selectedImageView);
        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);
            }
        });


        fragmentManager = getActivity().getSupportFragmentManager();

        mTF = (TextView) view.findViewById(R.id.TFident);
        mCodeImmeuble =(TextView) view.findViewById(R.id.CodeImmIdent);
        mEtat = (TextView) view.findViewById(R.id.EtatIdent);

        AjouterProp = (Button) view.findViewById(R.id.AjouterProp);


        AjouterProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AjouterPropDialog dialog = new AjouterPropDialog();
                dialog.setTargetFragment(Immeublier.this, 1);
                dialog.show(fragmentManager, "AjouterPropDialog");
            }
        });

        date1 = (Button) view.findViewById(R.id.Date1);


        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CalendarDialog dialog = new CalendarDialog();
                dialog.setTargetFragment(Immeublier.this, 1);

                dialog.show(fragmentManager, "CalendarDialog");
            }
        });

        date2 = (Button) view.findViewById(R.id.Date2);


        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CalendarAqDialog dialog = new CalendarAqDialog();
                dialog.setTargetFragment(Immeublier.this, 1);

                dialog.show(fragmentManager, "CalendarAqDialog");
            }
        });

        date3 = (Button) view.findViewById(R.id.Date3);


        date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CalendarTransDialog dialog = new CalendarTransDialog();
                dialog.setTargetFragment(Immeublier.this, 1);

                bundle.putInt("DATE",3);
                dialog.setArguments(bundle);
                dialog.show(fragmentManager, "CalendarTransDialog");
            }
        });


        mTF.setText("fdsffsdf");
       /* FicheTechniqueService ficheTechService = ServiceBuilder.buildService(FicheTechniqueService.class);
        Call<FicheTechnique> ficheTech = ficheTechService.getFicheTech();

        ficheTech.enqueue(new Callback<FicheTechnique>() {
            @Override
            public void onResponse(Call<FicheTechnique> request, Response<FicheTechnique> response) {
                mNbrOrdre.setText(response.body().getNmbrOrdre());
                System.out.println(response.body().getCategorie());
                RadioButton Villa = (RadioButton) view.findViewById(R.id.VillaR);
                RadioButton Immeuble = (RadioButton) view.findViewById(R.id.ImmeubleR);
                RadioButton Garage = (RadioButton) view.findViewById(R.id.GarageR);
                switch (response.body().getCategorie())
                {
                    case "Immeuble" :
                        Immeuble.setChecked(true);
                        Villa.setChecked(false);
                        Garage.setChecked(false);
                        break;
                    case "Villa" :

                        Immeuble.setChecked(false);
                        Villa.setChecked(true);
                        Garage.setChecked(false);
                        break;
                    case "Garage":

                        Immeuble.setChecked(false);
                        Villa.setChecked(false);
                        Garage.setChecked(true);
                        break;
                }
                RadioButton Oui = (RadioButton) view.findViewById(R.id.OuiR);
                RadioButton Non = (RadioButton) view.findViewById(R.id.NonR);

                switch (response.body().getPlan())
                {
                    case "Oui" :

                        Oui.setChecked(true);
                        Non.setChecked(false);
                        break;
                    case "Non" :
                        Non.setChecked(true);
                        Oui.setChecked(false);
                        break;

                }

                mNbrEtage.setText(response.body().getNbrEtage());
                mNbrOrdre.setText(response.body().getNbrLocaux());


                //m.setText("TF : " +response.body().getTF());
                //mCodeImmeuble.setText("CodeImmeuble : " +response.body().getCodeImmeuble());
            }
            @Override
            public void onFailure(Call<FicheTechnique> call, Throwable t) {
                mEtat.setText(t.getMessage());
            }
        });*/


        //Handle Adresses
        mNbrOrdre = (EditText) view.findViewById(R.id.GouvV);
        mNbrEtage = (EditText) view.findViewById(R.id.codeMuniT);
        mNbrLocal = (EditText) view.findViewById(R.id.nbrLocal);
        //Handle input Categorie
        mCategorie   = (RadioGroup) view.findViewById(R.id.Categorie);

        mCategorie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                /*switch(checkedId) {
                    case R.id.ImmeubleR:
                        // switch to fragment 1
                        break;
                    case R.id.VillaR:
                        // Fragment 2
                        break;
                    case R.id.GarageR:
                        // Fragment 2
                        break;
                }*/
            }
        });



        //Handle Fiches Technique
        mGouv = (EditText) view.findViewById(R.id.GouvV);
        mLat = (TextView) view.findViewById(R.id.Lat);
        mLon = (TextView) view.findViewById(R.id.Lon);


        //mQuotPV = (EditText) view.findViewById(R.id.Quotepart);
        //midentV = (EditText) view.findViewById(R.id.identV);
        //mNatioV = (EditText) view.findViewById(R.id.NatioV);




        //Handle Submit Button
        submitButton = view.findViewById(R.id.Submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               System.out.println(mLon.getText());
            }
        });




        // HANDLING PROPRIETAIRE LIST

        ListView mPropListView = (ListView) view.findViewById(R.id.PropList);
        // GETTING THE MISSION DATA
        PropList = new PropListData().getPropData();
        final Context context = container.getContext();
        // SETTING UP THE ADAPTER
        propAdapter = new PropListAdapter(context, R.layout.proprietaire_adapter_view, PropList);
        mPropListView.setAdapter(propAdapter);

        btnShowLocation = (Button) view.findViewById(R.id.GPSB) ;


        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // create class object
                GPSTracker gps = new GPSTracker(context);
                if(gps.canGetLocation()){
                    final TextView Longitude = (TextView) view.findViewById(R.id.Lon);
                    final TextView Latitude = (TextView) view.findViewById(R.id.Lat);
                    final double mLat = gps.getLatitude();
                    final double mLong = gps.getLongitude();
                    Longitude.setText(String.valueOf(mLat)); // returns latitude
                    Latitude.setText(String.valueOf(mLong));
                }

            }

    });


        return view;
    }

    @Override
    public void onAqDateSelected(int year, int month, int day){
        final String FullDate = String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        mDate2.setText(FullDate);

    }
    @Override
    public void onAppDateSelected(int year, int month, int day){
        final String FullDate = String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        mDate1.setText(FullDate);

    }
    @Override
    public void onTrDateSelected(int year, int month, int day){
        final String FullDate = String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(day);
        mDate3.setText(FullDate);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Image_Capture_Code) {

                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imgCapture.setImageBitmap(bp);

        }
    }


    @Override
    public void sendInputProp(String Iden,String Nati, String Quopar) {
        Proprietaire m = new Proprietaire(Iden,Nati,Quopar);
        PropList.add(m);
        propAdapter.notifyDataSetChanged();

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    private void getImages(View view){


        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");


        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");


        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");


        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");

        initRecyclerView(view);

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void initRecyclerView(View view){

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        GalleryAdapter adapter = new GalleryAdapter(getContext(), mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
