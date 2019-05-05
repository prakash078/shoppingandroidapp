package com.example.onlineshopping;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    EditText username,password;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String UName,Pass,RegisterUsername,RegisterPassword;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_login, container, false);

        username=view.findViewById(R.id.inputUsername);
        password=view.findViewById(R.id.inputPassword);
        btnLogin=view.findViewById(R.id.login);
        getActivity().setTitle("Online Clothing Shopping App");


        sharedPreferences=this.getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty((password.getText().toString())))
                {

                    UName=username.getText().toString();
                    Pass=password.getText().toString();

                    RegisterUsername=sharedPreferences.getString("NEW_USERNAME",UName);
                    RegisterPassword=sharedPreferences.getString("NEW_PASSWORD",Pass);
                    editor.commit();

                    if(UName.equals(RegisterUsername) && Pass.equals(RegisterPassword))
                    {
                        editor.putString("USERNAME",UName);
                        Intent dashboard=new Intent(getActivity(),Dashboard.class);
                        dashboard.putExtra("USERNAME",UName);
                        startActivity(dashboard);
                    }
                    else if(UName.equals("ashim") && Pass.equals("admin"))
                    {
                        editor.putString("USERNAME",UName);
                        Intent userDashboard=new Intent(getActivity(),admin_dashboard.class);
                        userDashboard.putExtra("USERNAME",UName);
                        startActivity(userDashboard);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
                if (TextUtils.isEmpty(username.getText().toString()))
                {
                    username.setError("Please enter username");
                    username.requestFocus();
                }
                else if(TextUtils.isEmpty(password.getText().toString()))
                {
                    password.setError("Please enter password");
                    password.requestFocus();
                }
            }
        });

        return view;
    }

}
