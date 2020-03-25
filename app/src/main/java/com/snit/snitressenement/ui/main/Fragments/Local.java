package com.snit.snitressenement.ui.main.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.MissionData.LocalModel;
import com.snit.snitressenement.ui.main.Services.LocalService;
import com.snit.snitressenement.ui.main.Services.ServiceBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Local.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Local#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Local extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextView CodeLocal;
    public EditText CodeLocataire;
    public EditText Etage;
    public EditText Surface;
    public EditText Nlocal;
    public EditText NomLocataire;
    public EditText NatureDeLocal;
    public EditText Usage;
    public EditText ValeurDeLocal;
    public EditText NomDeFamilleOccupant;


    public RadioButton CuisineOui;
    public RadioButton CuisineNon;
    public RadioButton SalleEauOui;
    public RadioButton SalleEauNon;

    public RadioButton Garage;
    public RadioButton Buand;
    public RadioButton Cave;

    public RadioButton Terrain;
    public RadioButton Cours;
    public RadioButton Terras;



    private OnFragmentInteractionListener mListener;

    public Local() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Local.
     */
    // TODO: Rename and change types and number of parameters
    public static Local newInstance(String param1, String param2) {
        Local fragment = new Local();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.local, container, false);

        CodeLocal = (TextView) view.findViewById(R.id.CodeLocal);
        CodeLocataire = (EditText) view.findViewById(R.id.CodeLocataire);
        Etage = (EditText) view.findViewById(R.id.EtageV);
        Surface = (EditText) view.findViewById(R.id.Surface);
        Nlocal = (EditText) view.findViewById(R.id.NmbrLocal);
        NomLocataire = (EditText) view.findViewById(R.id.NomLocataire);
        NatureDeLocal = (EditText) view.findViewById(R.id.NatureLocal);
        NomDeFamilleOccupant = (EditText) view.findViewById(R.id.NbrdeFamille);
        Usage = (EditText) view.findViewById(R.id.Usage);
        ValeurDeLocal = (EditText) view.findViewById(R.id.ValeurLocal);
        CuisineOui = (RadioButton) view.findViewById(R.id.OuiR);
        CuisineNon = (RadioButton) view.findViewById(R.id.NonR);
        SalleEauOui = (RadioButton) view.findViewById(R.id.Oui2R);
        SalleEauNon = (RadioButton) view.findViewById(R.id.Non2R);
        Terrain = (RadioButton) view.findViewById(R.id.TerrinR);
        Garage = (RadioButton) view.findViewById(R.id.GarageR);
        Cave = (RadioButton) view.findViewById(R.id.CaveR);
        Buand  = (RadioButton) view.findViewById(R.id.BuanR);
        Terras = (RadioButton) view.findViewById(R.id.TerrasR);
        Cours = (RadioButton) view.findViewById(R.id.CoursR);



        // HANDLE EclarageNaturelSpinner INPUT
        final Spinner EclarageNaturelSpinner = (Spinner) view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.fb, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        EclarageNaturelSpinner.setAdapter(adapter);


        // HANDLE MoyenChauffage INPUT
        final Spinner MoyenChauffageSpinner = (Spinner) view.findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.si, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        MoyenChauffageSpinner.setAdapter(adapter1);

        // HANDLE HumiditeSpinner INPUT
        final Spinner Ventilation = (Spinner) view.findViewById(R.id.spinner3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.si, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        Ventilation.setAdapter(adapter2);

        // HANDLE HumiditeSpinner INPUT
        final Spinner HumiditeSpinner = (Spinner) view.findViewById(R.id.spinner4);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getContext(),
                R.array.li, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        HumiditeSpinner.setAdapter(adapter3);




        LocalService LocalService = ServiceBuilder.buildService(LocalService.class);
        Call<LocalModel> LocalCall = LocalService.getLocal();

        LocalCall.enqueue(new Callback<LocalModel>() {
            @Override
            public void onResponse(Call<LocalModel> request, Response<LocalModel> response) {
                //EclarageNaturelSpinner GET
                switch (response.body().getEclarage()){
                    case "Faible":
                        EclarageNaturelSpinner.setSelection(0);
                        break;
                    case "Bon":
                        EclarageNaturelSpinner.setSelection(1);
                        break;
                }
                //MoyenChauffageSpinner GET
                switch (response.body().getMoyenChaufage()){
                    case "Faible":
                        MoyenChauffageSpinner.setSelection(0);
                        break;
                    case "Bon":
                        MoyenChauffageSpinner.setSelection(1);
                        break;
                }
                //Ventilation GET
                switch (response.body().getVentilation()){
                    case "Suffisant":
                        Ventilation.setSelection(0);
                        break;
                    case "insuffisant":
                        Ventilation.setSelection(1);
                        break;
                }
                //Humidite GET
                switch (response.body().getHumidite()){
                    case "Suffisant":
                        HumiditeSpinner.setSelection(0);
                        break;
                    case "insuffisant":
                        HumiditeSpinner.setSelection(1);
                        break;
                }

                switch (response.body().getCuisine())
                {
                    case "Oui":
                        CuisineOui.setChecked(true);
                        break;
                    case "Non":
                        CuisineNon.setChecked(false);
                        break;
                }
                switch (response.body().getSalleEau())
                {
                    case "Oui":
                        SalleEauOui.setChecked(true);
                        break;
                    case "Non":
                        SalleEauNon.setChecked(false);
                        break;
                }
                switch (response.body().getBatis())
                {
                    case "Garage":
                        Garage.setChecked(true);
                        break;
                    case "Buand":
                        Buand.setChecked(true);
                        break;
                    case "Cave":
                        Cave.setChecked(true);
                        break;

                }
                switch (response.body().getNonBatis())
                {
                    case "Terrain":
                        Terrain.setChecked(true);
                        break;
                    case "Cours":
                        Cours.setChecked(true);
                        break;
                    case "Terras":
                        Terras.setChecked(true);
                        break;
                }


                CodeLocal.setText("CodeLocal : "+response.body().getCodeLocal());
                CodeLocataire.setText(response.body().getCodeLocataire());
                Etage.setText(response.body().getEtage());
                Surface.setText(response.body().getSurface());
                Nlocal.setText(response.body().getNlocal());
                NomLocataire.setText(response.body().getNomLocataire());
                Usage.setText(response.body().getUsage());
                ValeurDeLocal.setText(response.body().getValeurDeLocation());
                NomDeFamilleOccupant.setText(response.body().getNomDeFamilleOccupant());




            }
            @Override
            public void onFailure(Call<LocalModel> call, Throwable t) {
                System.out.println("errorrr");
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
}
