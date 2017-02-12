package com.example.asususer.srunasatlogger1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view) {


        Button registerUser = (Button) findViewById(R.id.registerButton);

        if (view.getId() == R.id.registerButton) {
            EditText usernameET = (EditText) findViewById(R.id.UserName);
            EditText passwordET = (EditText) findViewById(R.id.password);
            EditText confirmPasswordET = (EditText) findViewById(R.id.ConfirmPassword);
            EditText firstnameET = (EditText) findViewById(R.id.FirstName);
            EditText lastnameET = (EditText) findViewById(R.id.LastName);
            EditText emailET = (EditText) findViewById(R.id.Email);
            EditText genderET = (EditText) findViewById(R.id.Gender);
            EditText kantoorET = (EditText) findViewById(R.id.Kantoor);
            EditText adresET = (EditText) findViewById(R.id.Adres);
            EditText phoneET = (EditText) findViewById(R.id.Phone);

            String username = usernameET.getText().toString();
            String password = passwordET.getText().toString();
            String confirmpassword = confirmPasswordET.getText().toString();
            String firstname = firstnameET.getText().toString();
            String lastname = lastnameET.getText().toString();
            String email = emailET.getText().toString();
            String gender = genderET.getText().toString();
            String kantoor = kantoorET.getText().toString();
            String adres = adresET.getText().toString();
            String phone = phoneET.getText().toString();


            if (!passwordET.equals(confirmPasswordET)) {
                Toast.makeText(getApplicationContext(), "Wachtwoorden komen niet overeen", Toast.LENGTH_SHORT).show();
                return;
            } else

            {
                User user = new User();
                user.setUserName(username);
                user.setPassword(password);
                user.setConfirmPassword(confirmpassword);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setEmail(email);
                user.setGender(gender);
                user.setKantoor(kantoor);
                user.setAdres(adres);
                user.setPhone(phone);

                helper.insertUser(user);
            }

        }

    }
}