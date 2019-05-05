package com.example.onlineshopping;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Register extends Fragment {

    EditText fullName,email,uName,pass,cPass,pn;
    Button btnRegister;
    String rUsername,rPassword,rCPass,checkPass,checkCPass;
    SharedPreferences sharedPreferencesRegister;
    SharedPreferences.Editor editorRegister;



    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_register, container, false);
        fullName=view.findViewById(R.id.inputFullName);
        email=view.findViewById(R.id.inputEmail);
        uName=view.findViewById(R.id.inputUName);
        pass=view.findViewById(R.id.inputPass);
        cPass=view.findViewById(R.id.inputCPassword);
        pn=view.findViewById(R.id.inputPN);
        btnRegister=view.findViewById(R.id.register);

        sharedPreferencesRegister=this.getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        editorRegister=sharedPreferencesRegister.edit();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPass=pass.getText().toString();
                checkCPass=cPass.getText().toString();
                if(TextUtils.isEmpty(fullName.getText().toString()))
                {
                    fullName.setError("Please enter full name");
                    fullName.requestFocus();
                }
                else if(TextUtils.isEmpty(email.getText().toString()))
                {
                    email.setError("Please enter email");
                    email.requestFocus();
                }
                else if(TextUtils.isEmpty(uName.getText().toString()))
                {
                    uName.setError("Please enter username");
                    uName.requestFocus();
                }
                else if(TextUtils.isEmpty(pass.getText().toString()))
                {
                    pass.setError("Please enter password");
                    pass.requestFocus();
                }
                else if(TextUtils.isEmpty(cPass.getText().toString()))
                {
                    cPass.setError("Please re-enter password");
                    cPass.requestFocus();
                }
                else if(TextUtils.isEmpty(pn.getText().toString()))
                {
                    pn.setError("Please enter phone number");
                    pn.requestFocus();
                }
                else if(!checkPass.equals(checkCPass))
                {
                    Toast.makeText(getActivity(), "Passwords don't match ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    rUsername=uName.getText().toString();
                    rPassword=pass.getText().toString();
                    rCPass=cPass.getText().toString();
                    Toast.makeText(getActivity(), "Registered successfully. Now you login form login page", Toast.LENGTH_SHORT).show();
                    editorRegister.putString("NEW_USERNAME",rUsername);
                    editorRegister.putString("NEW_PASSWORD",rPassword);
                    editorRegister.commit();

                    fullName.setText("");
                    email.setText("");
                    uName.setText("");
                    pass.setText("");
                    cPass.setText("");
                    pn.setText("");
                }

            }
        });




        return view;
    }

}
