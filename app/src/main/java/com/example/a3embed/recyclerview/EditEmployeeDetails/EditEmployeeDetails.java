/*
 * Pradyot Prakash
 *
 * Copyright (c)
 *
 * This software is the confidential and proprietary information of
 * 3Embed Technologies
 */

package com.example.a3embed.recyclerview.EditEmployeeDetails;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3embed.recyclerview.R;

/**
 * EditEmployeeDetails.java
 * Edit Details of Particular
 * Employees Showed Here
 *
 * @version 1.0 06 Dec 2018
 * @author Pradyot Prakash
 */

public class EditEmployeeDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_details);

        final String position;            // Position
        final EditText nameEt;            // Name Edit Text
        final EditText idEt;              // Id Edit Text
        final EditText branchEt;          // Branch Edit Text
        final EditText ageEt;             // Age Edit Text
        Button doneB;                     // Done Button

        nameEt = findViewById(R.id.nameEt);
        idEt = findViewById(R.id.idEt);
        branchEt = findViewById(R.id.branchEt);
        ageEt = findViewById(R.id.ageEt);
        doneB = findViewById(R.id.doneB);

        nameEt.setText(getIntent().getStringExtra("employeeName"));
        idEt.setText(getIntent().getStringExtra("employeeId"));
        ageEt.setText(getIntent().getStringExtra("employeeAge"));
        branchEt.setText(getIntent().getStringExtra("employeeBranch"));
        position = getIntent().getStringExtra("position");

        doneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(nameEt.getText().toString()) &&
                        !TextUtils.isEmpty(ageEt.getText().toString()) &&
                        !TextUtils.isEmpty(idEt.getText().toString()) &&
                        !TextUtils.isEmpty(branchEt.getText().toString())) {
                    Intent result = new Intent();
                    result.putExtra("name", nameEt.getText().toString());
                    result.putExtra("age", ageEt.getText().toString());
                    result.putExtra("id", idEt.getText().toString());
                    result.putExtra("branch", branchEt.getText().toString());
                    result.putExtra("position", position);
                    setResult(Activity.RESULT_OK, result);
                    finish();
                } else {
                    Toast.makeText(EditEmployeeDetails.this, "Don't Give Empty Value", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
