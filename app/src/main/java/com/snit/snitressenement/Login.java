package com.snit.snitressenement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends Activity {


    EditText inputUser;
    EditText inputPass;

    Button btnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);





        // Edit Text
        inputUser = (EditText) findViewById(R.id.user);
        inputPass = (EditText) findViewById(R.id.pass);
        btnLogin = (Button) findViewById(R.id.loginButton);



        // button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = inputUser.getText().toString();
                String pass = inputPass.getText().toString();
                // creating new product in background thread
                new LoginCredentials().execute(username,pass);
            }
        });


    }


    private class LoginCredentials extends AsyncTask<String, String, String> {
        protected String doInBackground(String... params) {


            CheckUser(params[0],params[1]);
            return null;
        }


        @Override
        protected void onPostExecute(String result) {

        };



        public void CheckUser(String User,String Pass){


                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

        }


    }

}