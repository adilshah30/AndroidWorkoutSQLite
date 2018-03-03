package com.adilshah.adil.androidworkoutsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LiteRegisterActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_register);

        final EditText etFullname = (EditText) findViewById(R.id.etFullname);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etpassword);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = etFullname.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                String age = etAge.getText().toString();


                //Insert user into database

                user u = new user();

                u.setFullname(fullname);
                u.setUsername(username);
                u.setPassword(password);
                u.setEmail(email);
                u.setAge(age);

                Boolean registerMsg = dbHelper.registerUser(u);

                if(registerMsg){
                    /// If register Successfull

                    Toast toastMsg =  Toast.makeText(LiteRegisterActivity.this, "Register Successful", Toast.LENGTH_SHORT);
                    toastMsg.show();

                    Intent loginIntent = new Intent(LiteRegisterActivity.this, LiteLoginActivity.class);
                    LiteRegisterActivity.this.startActivity(loginIntent);

                }else{
                    /// If register unsuccessful

                    Log.d("Request Reached", String.valueOf(registerMsg));
                    Toast toastMsg =  Toast.makeText(LiteRegisterActivity.this, "Not Successful", Toast.LENGTH_SHORT);
                    toastMsg.show();

                }




            }
        });

    }
}
