/*
 * Pradyot Prakash
 *
 * Copyright (c)
 *
 * This software is the confidential and proprietary information of
 * 3Embed Technologies
 */

package com.example.a3embed.recyclerview.EmployeeDetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.a3embed.recyclerview.R;

/**
 * EmployeeDetails.java
 * Details of Particular
 * Employees Showed Here
 *
 * @version 1.0 06 Dec 2018
 * @author Pradyot Prakash
 */

public class EmployeeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        TextView nameView;          // Employee Name TextView
        TextView idView;            // Employee Id TextView
        TextView ageViewValue;      // Employee Age TextView
        TextView branchView;        // Employee Branch TextView

        nameView = findViewById(R.id.nameTv);
        idView = findViewById(R.id.idView);
        ageViewValue = findViewById(R.id.ageView);
        branchView = findViewById(R.id.branchView);

        nameView.setText(String.format("Name: %s", getIntent().getStringExtra("employeeName")));
        idView.setText(String.format("iD: %s", getIntent().getStringExtra("employeeId")));
        ageViewValue.setText(String.format("Age: %s", getIntent().getStringExtra("employeeAge")));
        branchView.setText(String.format("Branch: %s", getIntent().getStringExtra("employeeBranch")));

    }
}
