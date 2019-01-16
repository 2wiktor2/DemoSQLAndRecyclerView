package com.wiktor.demosqlandrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;

    ArrayList<HistoryModel> listOfModels;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        dbHelper = new DBHelper(this);
        listOfModels = dbHelper.getData();

        Adapter adapter = new Adapter(listOfModels);

        myRecyclerView = findViewById(R.id.rv_container);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(adapter);



       // Adapter adapter = new Adapter(list);
     //   myRecyclerView.setAdapter(adapter);
    }
}
