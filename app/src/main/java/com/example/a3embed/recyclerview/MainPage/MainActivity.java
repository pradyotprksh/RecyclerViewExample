/*
 * Pradyot Prakash
 *
 * Copyright (c)
 *
 * This software is the confidential and proprietary information of
 * 3Embed Technologies
 */

package com.example.a3embed.recyclerview.MainPage;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.a3embed.recyclerview.R;
import com.example.a3embed.recyclerview.MainPage.RecyclerView.Adapter.EmployeeAdapter;
import com.example.a3embed.recyclerview.MainPage.RecyclerView.Model.EmployeeModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * MainActivity.java
 * Main Class
 *
 * @version 1.0 06 Dec 2018
 * @author Pradyot Prakash
 */

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private List<EmployeeModel> employeeModels;     // EmployeeModel List Variable
    private EmployeeAdapter employeeAdapter;        // EmployeeAdapter Variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView employeeView = findViewById(R.id.main_recyclerview);                           // RecyclerView For Employee
        Button sort = findViewById(R.id.sort);                                                      // Sort Button

        employeeModels = new ArrayList<>();
        employeeAdapter = new EmployeeAdapter(employeeModels, this);
        employeeView.setHasFixedSize(true);
        employeeView.setLayoutManager(new LinearLayoutManager(this));
        employeeView.setAdapter(employeeAdapter);
        employeeModels.clear();

        employeeView.setNestedScrollingEnabled(true);

        addValue();

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortRecyclerView();
            }
        });
    }

    /**
     * <h>sortRecyclerView()</h>
     * <p>Sort RecyclerView based on branch</p>
     */
    private void sortRecyclerView() {
        Collections.sort(employeeModels, new Comparator<EmployeeModel>() {
            @Override
            public int compare(EmployeeModel o1, EmployeeModel o2) {
                return o1.getBranch().compareTo(o2.getBranch());
            }
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                employeeAdapter.notifyDataSetChanged();
            }
        });
    }


    /**
     * <h>addValue()</h>
     * <p>Add Value to RecyclerView</p>
     */
    private void addValue() {

        EmployeeModel employeeModel2 = new EmployeeModel("11", "DEF", "CS", 21);    //Employee Object
        EmployeeModel employeeModel8 = new EmployeeModel("17", "VWX", "CS", 27);    //Employee Object
        EmployeeModel employeeModel6 = new EmployeeModel("15", "PQR", "CS", 25);    //Employee Object
        EmployeeModel employeeModel9 = new EmployeeModel("18", "YZA", "CS", 28);    //Employee Object
        EmployeeModel employeeModel3 = new EmployeeModel("12", "GHI", "CS", 22);    //Employee Object

        EmployeeModel employeeModel1 = new EmployeeModel("10", "ABC", "ME", 20);    //Employee Object
        EmployeeModel employeeModel4 = new EmployeeModel("13", "JKL", "ME", 23);    //Employee Object
        EmployeeModel employeeModel5 = new EmployeeModel("14", "MNO", "ME", 24);    //Employee Object
        EmployeeModel employeeModel7 = new EmployeeModel("16", "STU", "ME", 26);    //Employee Object
        EmployeeModel employeeMode20 = new EmployeeModel("19", "BCD", "ME", 27);    //Employee Object

        EmployeeModel employeeMode21 = new EmployeeModel("20", "EFG", "EEE", 28);   //Employee Object
        EmployeeModel employeeMode22 = new EmployeeModel("21", "HIJ", "EEE", 29);   //Employee Object
        EmployeeModel employeeMode23 = new EmployeeModel("22", "KLM", "EEE", 30);   //Employee Object
        EmployeeModel employeeMode24 = new EmployeeModel("23", "NOP", "EEE", 31);   //Employee Object
        EmployeeModel employeeMode25 = new EmployeeModel("24", "QRS", "EEE", 32);   //Employee Object

        employeeModels.add(new EmployeeModel("CS"));
        employeeModels.add(employeeModel2);
        employeeModels.add(employeeModel8);
        employeeModels.add(employeeModel6);
        employeeModels.add(employeeModel9);
        employeeModels.add(employeeModel3);
        employeeModels.add(new EmployeeModel("ME"));
        employeeModels.add(employeeModel1);
        employeeModels.add(employeeModel4);
        employeeModels.add(employeeModel5);
        employeeModels.add(employeeModel7);
        employeeModels.add(employeeMode20);
        employeeModels.add(new EmployeeModel("EEE"));
        employeeModels.add(employeeMode21);
        employeeModels.add(employeeMode22);
        employeeModels.add(employeeMode23);
        employeeModels.add(employeeMode24);
        employeeModels.add(employeeMode25);

        employeeAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // If came from same REQUEST_CODE
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    String name = data.getStringExtra("name");                                // New Name
                    String age = data.getStringExtra("age");                                  // New Age
                    String id = data.getStringExtra("id");                                    // New Id
                    String branch = data.getStringExtra("branch");                            // New Branch
                    String position = data.getStringExtra("position");                        // Position

                    EmployeeModel newEmployee = new EmployeeModel(id, name, branch, Integer.parseInt(age));
                    employeeModels.set(Integer.parseInt(position), newEmployee);

                    employeeAdapter.notifyDataSetChanged();

                }
            }
        }

    }
}
