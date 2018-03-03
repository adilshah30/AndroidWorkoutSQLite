package com.adilshah.adil.androidworkoutsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LiteLoginActivity extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_login);


        final EditText etUsername=  (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView linkRegister = (TextView) findViewById(R.id.linkRegister);

        linkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LiteLoginActivity.this , LiteRegisterActivity.class);
                LiteLoginActivity.this.startActivity(registerIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                String authenticatePassword = dbHelper.authenticateLogin(username);

                if (authenticatePassword.equals(password)){

                    Intent dashboardIntent = new Intent(LiteLoginActivity.this, DashboardActivity.class);
                    dashboardIntent.putExtra("username", username);
                    LiteLoginActivity.this.startActivity(dashboardIntent);

                }else{

                    Toast toastMsg = Toast.makeText(LiteLoginActivity.this, "Username and password doesn't match", Toast.LENGTH_SHORT );
                    toastMsg.show();
                }


            }
        });

    }
}
