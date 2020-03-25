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
import com.snit.snitressenement.ui.main.MissionData.Proprietaire;

import java.util.List;

public class PropListAdapter extends ArrayAdapter<Proprietaire> {
    private  static final String TAG = "PropListAdapter";
    private Context mContext;
    int mResource;

    public PropListAdapter(@NonNull Context context, int resource, @NonNull List<Proprietaire> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String ident = getItem(position).getIdentite();
        String natio = getItem(position).getNationalite();
        String quot = getItem(position).getQuotePar();
        //Proprietaire propr = new Proprietaire(ident,natio,quot);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

       /* final TextView tvIdent = (TextView) convertView.findViewById(R.id.IdeVal);
        final TextView tvNatio = (TextView) convertView.findViewById(R.id.NatVal);
        final TextView tvQuo = (TextView) convertView.findViewById(R.id.QuoVal);

        tvIdent.setText(ident);
        tvNatio.setText(natio);
        tvQuo.setText(quot);*/

        return convertView;
    }
}
