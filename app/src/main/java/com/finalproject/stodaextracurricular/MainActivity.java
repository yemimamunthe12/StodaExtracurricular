package com.finalproject.stodaextracurricular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnexit;
    Button btnChoir;
    Button btnFutsal;
    Button btnModel;
    Button btnPramuka;
    Button btnModernDance;
    ImageView btnLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnexit = (Button) findViewById(R.id.button1);
        btnChoir= (Button) findViewById(R.id.Choir);
        btnFutsal = (Button) findViewById(R.id.Futsal);
        btnModel = (Button) findViewById(R.id.Model);
        btnPramuka = (Button) findViewById(R.id.Pramuka);
        btnModernDance = (Button) findViewById(R.id.ModernDance);
        btnLogo = (ImageView) findViewById(R.id.Logo);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

        btnChoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent hal2 = new Intent(MainActivity.this, Padus.class);
//                startActivity(hal2);
            }
        });

        btnFutsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent hal2 = new Intent(MainActivity.this, Futsal.class);
//                startActivity(hal2);
            }
        });

        btnModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent hal2 = new Intent(MainActivity.this, Model.class);
//                startActivity(hal2);
            }
        });

        btnPramuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent hal2 = new Intent(MainActivity.this, Pramuka.class);
//                startActivity(hal2);
            }
        });

        btnModernDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent hal2 = new Intent(MainActivity.this, ModernDance.class);
//                startActivity(hal2);
            }
        });

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.smasantothomas2medan.sch.id/")));
            }
        });

    }
}