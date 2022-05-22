package com.finalproject.stodaextracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    // Remember this! Instantiate ConnectionClass
    ConnectionClass connectionClass;

    TextView btnCreate;
    EditText txUsername;
    EditText txPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCreate = findViewById(R.id.btnCreate);
        txUsername = findViewById(R.id.txUsername);
        txPassword = findViewById(R.id.txPassword);
        btnLogin = findViewById(R.id.btnLogin);

        // Remember this! Instantiate ConnectionClass
        connectionClass = new ConnectionClass();
        connectionClass.CONN();

        btnLogin.setOnClickListener(view -> {
            getAllUsername();
        });
    }

    public void getAllUsername() {
        try {
            Statement statement = connectionClass.CONN().createStatement();
            // Query for your database, carefully UPPERCASE and undercase
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AKUN");
            //Example for INSERT
//            String contohUsername = "Nicolas";
//            String contohPassword = "nicolas";

            try {
//            ResultSet resultSet = statement.executeQuery("INSERT INTO AKUN VALUES (" + contohUsername + "," + contohPassword + ")");
            } catch (Exception e) {
            }

            List<Username> listUsername = new ArrayList<Username>();
            while (resultSet.next()) {
                // Filled the data that want to populate
                Username newUsername = new Username(resultSet.getString("username"), resultSet.getString("password"));
                listUsername.add(newUsername);
            }
            connectionClass.CONN().close(); // threading issue, please close it after use it!

            // Populate data here
            for (int i = 0; i < listUsername.size(); i++) {
                if (txUsername.getText().toString().equals(listUsername.get(i).nama)) {
                    if (txPassword.getText().toString().equals(listUsername.get(i).password)) {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

class Username {
    String nama;
    String password;

    Username(String name, String pass) {
        this.nama = name;
        this.password = pass;
    }
}