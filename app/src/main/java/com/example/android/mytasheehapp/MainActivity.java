package com.example.android.mytasheehapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String ayah;
    String keys;
    EditText ayahtext;
    EditText keywords;
    Button button;
    List<String> listOfWords;

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> matched = new ArrayList<String>();
    int counter = 0;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ayahtext = (EditText) findViewById(R.id.editInput);
        keywords = (EditText) findViewById(R.id.editInput2);
        button = (Button) findViewById(R.id.button1);
        

        names.add("happiest birthday to you");
        names.add("happy birthday to u");
        names.add("happiest birthday");
        names.add("congratulations to you");
        names.add("nothing in common");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ayah = ayahtext.getText().toString();
                keys = keywords.getText().toString();

                listOfWords = getWords(keys);
                flag = true;

                // String[] stockArr = new String[listOfWords.size()];
                // stockArr = listOfWords.toArray(stockArr);

                for (String s : listOfWords) {
                    String pattern = "\\b" + s.toLowerCase() + "\\b";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(ayah.toLowerCase());

                    if (m.find()) {
                        //continue to check other keywords in the ayah by user
                    } else {
                        Toast.makeText(MainActivity.this, "Aayh doesn't contain word " + s, Toast.LENGTH_SHORT).show();
                        flag = false;
                        break;
                    }
                }
                    if (flag) {
                        matched.clear();
                        for (String str : names) {
                            counter = 0;
                            for (String s1 : listOfWords) {
                                String pattern2 = "\\b" + s1.toLowerCase() + "\\b";
                                Pattern p1 = Pattern.compile(pattern2);
                                Matcher m1 = p1.matcher(str.toLowerCase());
                                //return m.find();
                                //break the loop if any keyword doesnt exist in the current ayah.
                                if (m1.find()) {
                                    //continue to check other keywords in the arraylist of ayah
                                    counter++;
                                } else break;

                            }
                            if (counter == listOfWords.size()) {
                                matched.add(str);
                            }
                        }
                        Intent i = new Intent(MainActivity.this, list_view.class);
                        i.putExtra("key", matched);
                        startActivity(i);

                }
            }
        });
    }

    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }
}
