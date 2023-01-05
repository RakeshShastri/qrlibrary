package com.qrlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class StudentHome extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        lv = (ListView) findViewById(R.id.cart_contents);
        List<String> bookArr = new ArrayList<String>();
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            if (extras.containsKey("Book")) {
                String book = extras.getString("Book");
                bookArr.add(book);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bookArr);

                lv.setAdapter(arrayAdapter);
                //TextView text = findViewById(R.id.cart_contents);
                //text.setText(book);
            }
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.studentQR3:
                        Intent i = new Intent(StudentHome.this,QRScanner.class);
                        startActivity(i);
                        return true;
                    default: return true;
                }
            }
        });

    }
}