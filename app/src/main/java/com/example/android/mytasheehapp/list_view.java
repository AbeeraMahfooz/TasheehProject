package com.example.android.mytasheehapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class list_view extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.list);
        ArrayList<String> ayahlist = (ArrayList<String>) getIntent().getSerializableExtra("key");

        arrayAdapter = new ArrayAdapter<String>(list_view.this, android.R.layout.simple_list_item_1, ayahlist);
        listView.setAdapter(arrayAdapter);

    }
}
