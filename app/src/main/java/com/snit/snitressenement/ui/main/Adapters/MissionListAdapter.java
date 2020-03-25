package com.snit.snitressenement.ui.main.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.snit.snitressenement.R;
import com.snit.snitressenement.ui.main.MissionData.Mission;

import java.util.List;

public class MissionListAdapter extends ArrayAdapter<Mission> {
    private  static final String TAG = "MissionListAdapter";
    private Context mContext;
    int mResource;

    public MissionListAdapter(@NonNull Context context, int resource, @NonNull List<Mission> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        System.out.println("adapter");

        String mTF = getItem(position).getTF();
        String mImmeuble = getItem(position).getCodeImmeuble();
        Integer etat = getItem(position).getEtat();
        String mAdresse = getItem(position).getAdresse();

        //Mission mission = new Mission(TF,Immeuble,etat,gov);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTF = (TextView) convertView.findViewById(R.id.TFV);
        TextView tvImmeublier = (TextView) convertView.findViewById(R.id.CIV);
        TextView Adresse = (TextView) convertView.findViewById(R.id.adresseV);

        tvTF.setText(mTF);
        tvImmeublier.setText(mImmeuble);
        Adresse.setText(mAdresse);

        return convertView;
    }


    public void UpdateAdapter(List<Mission> missions){
        addAll(missions);
        notifyDataSetChanged();
    }
}
