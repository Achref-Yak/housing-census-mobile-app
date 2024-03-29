package com.snit.snitressenement.ui.main.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.snit.snitressenement.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ficheTechnique.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ficheTechnique#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ficheTechnique extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Button imB;
    public Button vlB;
    public Button grB;
    public String Page = "Fiche Technique";
    public boolean imbBool = false;

    private OnFragmentInteractionListener mListener;

    public ficheTechnique() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ficheTechnique.
     */
    // TODO: Rename and change types and number of parameters
    public static ficheTechnique newInstance(String param1, String param2) {
        ficheTechnique fragment = new ficheTechnique();
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
        View view = inflater.inflate(R.layout.fiche_technique, container, false);
         imB = view.findViewById(R.id.imB);
        vlB = view.findViewById(R.id.vbB);
        grB = view.findViewById(R.id.grB);

        imB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    vlB.setEnabled(true);
                    grB.setEnabled(true);
                    imB.setEnabled(false);
            }
        });


        vlB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlB.setEnabled(false);
                imB.setEnabled(true);
                grB.setEnabled(true);
            }
        });

        grB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imB.setEnabled(true);
                vlB.setEnabled(true);
                grB.setEnabled(false);
            }
        });







        return view;
    };

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public String getPageTitle(){
        return Page;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
