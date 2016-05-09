package com.example.phamngoctuan.autocompletetext;

import android.app.Activity;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    ArrayList<String> languages;

    AutoCompleteTextView txtSearch;
    List<People> mList;
    PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languages = new ArrayList<>();
        languages.add("Android");
        languages.add("Java");
        languages.add("IOS");
        languages.add("SQL");
        languages.add("JBDC");
        languages.add("Web services");
        languages.add("Ajax");

        text = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        text1 = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);

        MyFilterArrayAdapter adapter = new MyFilterArrayAdapter(this, android.R.layout.simple_list_item_1, languages);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, languages);
        text.setAdapter(adapter);
        text.setThreshold(1);

        text1.setAdapter(adapter);
        text1.setThreshold(1);
        text1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

//        mList = retrievePeople();
//        txtSearch = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
//        txtSearch.setThreshold(1);
//        adapter = new PeopleAdapter(this, R.layout.activity_main, R.id.lbl_name, mList);
//        txtSearch.setAdapter(adapter);
    }

    private List<People> retrievePeople() {
        List<People> list = new ArrayList<People>();
        list.add(new People("James", "Bond", 1));
        list.add(new People("Jason", "Bourne", 2));
        list.add(new People("Ethan", "Hunt", 3));
        list.add(new People("Sherlock", "Holmes", 4));
        list.add(new People("David", "Beckham", 5));
        list.add(new People("Bryan", "Adams", 6));
        list.add(new People("Arjen", "Robben", 7));
        list.add(new People("Van", "Persie", 8));
        list.add(new People("Zinedine", "Zidane", 9));
        list.add(new People("Luis", "Figo", 10));
        list.add(new People("John", "Watson", 11));
        return list;
    }
}