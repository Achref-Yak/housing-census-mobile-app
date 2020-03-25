package com.snit.snitressenement.ui.main.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.snit.snitressenement.MainActivity;
import com.snit.snitressenement.MissionActivity;
import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.Adapters.MissionListAdapter;
import com.snit.snitressenement.ui.main.MissionData.Mission;
import com.snit.snitressenement.ui.main.MissionData.MissionDataManager;
import com.snit.snitressenement.ui.main.MissionData.MissionListData;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Missions.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Missions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Missions extends Fragment implements Mission.GestionMission {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    RadioGroup radioGroup;
    RadioButton radioButton;

    private OnFragmentInteractionListener mListener;

    public Missions() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Missions.
     */
    // TODO: Rename and change types and number of parameters
    public static Missions newInstance(String param1, String param2) {
        Missions fragment = new Missions();
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
        ListView mMissionListView = (ListView) view.findViewById(R.id.listView);
        Context context = container.getContext();


        List<Mission> missions = new ArrayList<>();
        // SETTING UP THE ADAPTER
        MissionListAdapter adapter = new MissionListAdapter(context, R.layout.mission_adapter_view, missions);
        mMissionListView.setAdapter(adapter);


        // GETTING THE MISSION DATA
        MissionDataManager missionDataManager = new MissionDataManager(adapter);


        missions=  missionDataManager.getInstance().getMissions();



        mMissionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Evaluer(parent, position);
            }
        });


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


    public void UpdateAdapter(MissionListAdapter adapter){
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Evaluer(AdapterView<?> parent, int position) {
        // Get the selected item text from ListView
        Mission selectedItem = (Mission) parent.getItemAtPosition(position);
        String TF = selectedItem.getTF();

        Intent i = new Intent(getActivity(), MissionActivity.class);
        i.putExtra("TF", TF);
        startActivity(i);
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
