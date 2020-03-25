package com.snit.snitressenement.ui.main.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;


import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.MissionData.MissionListData;
import com.snit.snitressenement.ui.main.Adapters.MissionTraiteListAdapter;


public class Missions_traite  extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RadioGroup radioGroup;
    RadioButton radioButton;

    private Missions_traite.OnFragmentInteractionListener mListener;

    public Missions_traite() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Missions_traite newInstance(String param1, String param2) {
        Missions_traite fragment = new Missions_traite();
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
        View view = inflater.inflate(R.layout.fragment_missions, container, false);
        ListView mMissionTraiteListView = (ListView) view.findViewById(R.id.listView);

        /*
        ArrayList missionTraitList = new MissionListData().getMissionDoneData();
        Context context = container.getContext();


        // SETTING THE ADAPTER
        MissionTraiteListAdapter adapter = new MissionTraiteListAdapter(context, R.layout.mission_traite_adapter_view, missionTraitList);
        mMissionTraiteListView.setAdapter(adapter);
*/





        /*RadioGroup radioGroup = (RadioGroup) container.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radio_one:
                        // switch to fragment 1
                        break;
                    case R.id.radio_two:
                        // Fragment 2
                        break;
                    case R.id.radio_three:
                        // Fragment 2
                        break;
                }
            }
        });*/


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
