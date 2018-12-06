/*
 * Pradyot Prakash
 *
 * Copyright (c)
 *
 * This software is the confidential and proprietary information of
 * 3Embed Technologies
 */

package com.example.a3embed.recyclerview.MainPage.RecyclerView.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a3embed.recyclerview.EditEmployeeDetails.EditEmployeeDetails;
import com.example.a3embed.recyclerview.EmployeeDetails.EmployeeDetails;
import com.example.a3embed.recyclerview.MainPage.RecyclerView.Model.EmployeeModel;
import com.example.a3embed.recyclerview.R;

import java.util.List;

/**
 * EmployeeAdapter.java
 * Employees RecyclerView Adapter
 *
 * @version 1.0 06 Dec 2018
 * @author Pradyot Prakash
 */

public class EmployeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int REQUEST_CODE = 100;
    private List<EmployeeModel> employeeModels;     // Employee Model List Variable
    private Context context;                        // Context Variable

    private static final int TYPE_HEADER = 0;       // Header View Type
    private static final int TYPE_ITEM = 1;         // Not Header View Type

    /** EmployeeAdapter Constructor */
    public EmployeeAdapter(List<EmployeeModel> employeeModels, Context context) {
        this.employeeModels = employeeModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i == TYPE_HEADER)
        {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.header_cell, viewGroup, false);                   // HeaderType ViewHolder
            return  new VHHeader(v);
        }
        else if(i == TYPE_ITEM)
        {
            View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.employee_layout
                                , viewGroup, false);                                    // Not HeaderType ViewHolder
            return new ViewHolder(view);
        }
        throw new RuntimeException("there is no type that matches the type " + i + " + make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        final int position = i;
        if(holder instanceof VHHeader)
        {
            VHHeader VHheader = (VHHeader)holder;                       // Header Object
            EmployeeModel currentItem;                                  // Current Employee Object
            currentItem = employeeModels.get(position);
            VHheader.txtTitle.setText(currentItem.getBranch());
        }
        else if(holder instanceof ViewHolder)
        {
            final EmployeeModel currentItem = employeeModels.get(position);                         // Employee list
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.ageViewValue.setText(String.valueOf(currentItem.getAge()));
            viewHolder.branchView.setText(currentItem.getBranch());
            viewHolder.idView.setText(currentItem.getId());
            viewHolder.nameView.setText(currentItem.getName());

            viewHolder.employeeDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EmployeeDetails.class);                     // Intent To EmployeeDetails
                    intent.putExtra("employeeName", currentItem.getName());
                    intent.putExtra("employeeId", currentItem.getId());
                    intent.putExtra("employeeAge", String.valueOf(currentItem.getAge()));
                    intent.putExtra("employeeBranch", currentItem.getBranch());
                    context.startActivity(intent);
                }
            });

            viewHolder.editB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EditEmployeeDetails.class);                 // Intent To EditEmployeeDetails
                    intent.putExtra("employeeName", currentItem.getName());
                    intent.putExtra("employeeId", currentItem.getId());
                    intent.putExtra("employeeAge", String.valueOf(currentItem.getAge()));
                    intent.putExtra("employeeBranch", currentItem.getBranch());
                    intent.putExtra("position", "" + position);
                    ((Activity) context).startActivityForResult(intent, REQUEST_CODE);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {

        // If row is 6 then return header type
        if (position % 6 == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return employeeModels.size();
    }

    /** Header ViewHolder */
    class VHHeader extends RecyclerView.ViewHolder{

        TextView txtTitle;      // Header textView

        /** Header Constructor */
        VHHeader(View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtHeader);
        }
    }

    /** Cell ViewHolder */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;                  // View Variable
        private TextView nameView;          // Name TextView
        private TextView idView;            // Id TextView
        private TextView ageViewValue;      // Age TextView
        private TextView branchView;        // Branch TextView
        private Button employeeDetails;     // Details Button
        private Button editB;

        /** Cell ViewHolder Constructor */
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            nameView = view.findViewById(R.id.nameTv);
            idView = view.findViewById(R.id.idView);
            ageViewValue = view.findViewById(R.id.ageView);
            branchView = view.findViewById(R.id.branchView);
            employeeDetails = view.findViewById(R.id.employeeDetails);
            editB = view.findViewById(R.id.editB);
        }
    }
}
