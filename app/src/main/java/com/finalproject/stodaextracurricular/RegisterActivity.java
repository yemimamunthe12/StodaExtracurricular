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

    EditText txUnameReg;
    EditText txPassReg;
    EditText txConfPass;
    Button btnRegister;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txUnameReg = findViewById(R.id.txUnameReg);
        txPassReg = findViewById(R.id.txPassReg);
        txConfPass = findViewById(R.id.txConfPass);
        btnRegister = findViewById(R.id.btnRegister);
        tvRegister = findViewById(R.id.tvRegister);

        // Remember this! Instantiate ConnectionClass
        connectionClass = new ConnectionClass();
        connectionClass.CONN();

        btnRegister.setOnClickListener(view -> {
            getAllUsername();
        });
    }

    public void getAllUsername() {
        try {
            Statement statement = connectionClass.CONN().createStatement();
            String username = "Nicolas";
            String password = "nicolas";
            // Query for your database, carefully UPPERCASE and undercase
            ResultSet resultSet = statement.executeQuery("INSERT INTO AKUN VALUES (" + username + "," + password + ")");

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