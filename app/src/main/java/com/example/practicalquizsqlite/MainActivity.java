package com.example.practicalquizsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    Button btnInsert, btnRetrieve;
    ListView lv;
    ArrayList<School> al;
    ArrayAdapter<School> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        lv = findViewById(R.id.lv);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertSchool(et1.getText().toString(),et2.getText().toString());
                dbh.close();

            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //ToDo
                DBHelper dbh = new DBHelper(MainActivity.this);
                al = dbh.getSchools();
                dbh.close();
                aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,al);
                lv.setAdapter(aa);
            }
        });
    }

}