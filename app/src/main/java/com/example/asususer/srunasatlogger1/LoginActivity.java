package com.example.asususer.srunasatlogger1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.asususer.srunasatlogger1.R.id.password;
import static com.example.asususer.srunasatlogger1.R.id.username;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper  = new DatabaseHelper(this);

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }


    public void loginUser(View view) {



        if (view.getId() ==R.id.loginButton)
        {

            EditText usernameET = (EditText) findViewById(username);
            EditText passwordET = (EditText) findViewById(password);

            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();

            String Password = helper.searchpassword(password);
            if(password.equals(password)) {

                startActivity(new Intent(this, MainActivity.class));
            }

        } else {
            Toast.makeText(getApplicationContext(), "Uw gebruikersnaam of wachtwoord is onjuist!",
                    Toast.LENGTH_SHORT).show();

        }


    }

    public void Register(View view) {
        Button register = (Button) findViewById(R.id.registerButton);
        Intent intentRegister =new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intentRegister);

    }
}



