package com.snit.snitressenement.ui.main.Fragments;
import com.snit.snitressenement.R;

import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;



public class AjouterPropDialog extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputSelected{
        void sendInputProp(String Ident,String Natio, String Quot);
    }
    public OnInputSelected mOnInputSelected;

    //widgets
    private EditText mIdentite, mNationalite, mQuotePart;
    private TextView mActionOk, mActionCancel;


    static AjouterPropDialog newInstance(int num) {
        AjouterPropDialog f = new AjouterPropDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prop_dialog, container, false);
        mActionOk = view.findViewById(R.id.AjouterDialogP);
        mActionCancel = view.findViewById(R.id.AnnulerDialogP);
        mIdentite = view.findViewById(R.id.IdeVal);
        mQuotePart = view.findViewById(R.id.QuoVal);
        mNationalite = view.findViewById(R.id.NatVal);


        mActionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: capturing input.");

                String Identite = mIdentite.getText().toString();
                String Nationalite = mNationalite.getText().toString();
                String QuotePart = mQuotePart.getText().toString();
                if(!Identite.equals("")& !Identite.equals("")& !Identite.equals("")){
//
//                    //Easiest way: just set the value.
//                    MainFragment fragment = (MainFragment) getActivity().getFragmentManager().findFragmentByTag("MainFragment");
//                    fragment.mInputDisplay.setText(input);



                    mOnInputSelected.sendInputProp(Identite,Nationalite,QuotePart);
                }


                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }
}
