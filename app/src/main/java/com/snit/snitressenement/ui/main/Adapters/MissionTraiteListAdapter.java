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

public class MissionTraiteListAdapter  extends ArrayAdapter<Mission> {
    private Context mContext;
    int mResource;

    public MissionTraiteListAdapter(@NonNull Context context, int resource, @NonNull List<Mission> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*String TF = getItem(position).getTF();
        String Immeuble = getItem(position).getCodeImmeuble();
        String gov = getItem(position).getGov();

        Mission mission = new Mission(TF,Immeuble,1,gov);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvTF = (TextView) convertView.findViewById(R.id.TFV);
        TextView tvImmeublier = (TextView) convertView.findViewById(R.id.CIV);
        TextView tvgov = (TextView) convertView.findViewById(R.id.govV);

        tvTF.setText(TF);
        tvImmeublier.setText(Immeuble);
        tvgov.setText(gov);*/

        return convertView;
    }
}
