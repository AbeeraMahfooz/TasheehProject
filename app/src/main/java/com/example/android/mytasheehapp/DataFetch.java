package com.example.android.mytasheehapp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DataFetch extends AppCompatActivity {

    boolean flag = true;
    ArrayList<String> wordslist = (ArrayList<String>) getIntent().getSerializableExtra("key");
    String OneWord = wordslist.get(0);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(DataFetch.this, OneWord, Toast.LENGTH_SHORT).show();
    }
}
