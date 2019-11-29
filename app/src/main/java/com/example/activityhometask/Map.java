package com.example.activityhometask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map extends AppCompatActivity {
    public TextView textView;
    public Button toCatalog;
    public Button toAccount;
    public Button toSearch;
    private static final String SAVED_FIRST_STRING = "FIRST_STRING";
    private static final String SAVED_SECOND_STRING = "SECOND_STRING";
    private static final String SAVED_PARCELABLE = "OBJECT";
    private TestModel testModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        textView = findViewById(R.id.map_textview);
        toSearch = findViewById(R.id.button_MapToSearch);
        toAccount = findViewById(R.id.button_MapToAcc);
        toCatalog = findViewById(R.id.button_MapToCat);
        Random rand = new Random();
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        int arrEnd = rand.nextInt(8)+1;
        for(int i =0;i<arrEnd;i++){
            firstList.add(String.valueOf(rand.nextInt(593)));
            secondList.add(String.valueOf(rand.nextInt(593)));
        }
        testModel = new TestModel(String.valueOf(rand.nextInt(593)),
                String.valueOf(rand.nextInt(593)),
                firstList,
                secondList);
        textView.setText("Map: " + testModel.getFirstString() + "  " + testModel.getSecondString());
        toAccount.setOnClickListener(this::onAccountClick);
        toSearch.setOnClickListener(this::onSearchClick);
        toCatalog.setOnClickListener(this::onCatalogClick);
    }
    private void onAccountClick(View view){
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
    }
    private void onSearchClick(View view){
        Intent intent = new Intent(this, Search.class);
        startActivity(intent);
    }
    private void onCatalogClick(View view){
        Intent intent = new Intent(this, CatalogMain.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_FIRST_STRING, testModel.getFirstString());
        outState.putString(SAVED_SECOND_STRING, testModel.getSecondString());
        outState.putParcelable(SAVED_PARCELABLE, testModel);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        textView.setText("Map: " +
                savedInstanceState.getString(SAVED_FIRST_STRING) +
                "  " +
                savedInstanceState.getString(SAVED_SECOND_STRING));
        testModel = savedInstanceState.getParcelable(SAVED_PARCELABLE);
        super.onRestoreInstanceState(savedInstanceState);
    }

}
