package com.example.exercise;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;

    EditText edemail, edpassword;

    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignIn);

        edemail = findViewById(R.id.EdEmail);

        edpassword = findViewById(R.id.edPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edemail.getText().toString();

                password = edpassword.getText().toString();

                String email = "admin@mail.com";

                String pass = "123";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);

                        i.putExtras(b);

                        startActivity(i);
                    } else {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}