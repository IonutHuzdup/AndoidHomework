package com.example.secondhomework.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondhomework.R;
import com.example.secondhomework.interfaces.OnCellClick;
import com.example.secondhomework.models.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private ArrayList<Employee> employees;
    private OnCellClick click;

    public EmployeeAdapter(ArrayList<Employee> employees, OnCellClick click) {
        this.employees = employees;
        this.click = click;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.employee_cell, parent, false);
       EmployeeViewHolder employeeViewHolder = new EmployeeViewHolder(view);
        return employeeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView jobId;
        private TextView createdAt;
        private TextView name;
        private TextView avatar;
        private TextView phone;
        private View view;

        public EmployeeViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.employee_id);
            jobId = view.findViewById(R.id.employee_job_id);
            createdAt = view.findViewById(R.id.employee_created_at);
            name = view.findViewById(R.id.employee_name);
            avatar = view.findViewById(R.id.employee_avatar);
            phone = view.findViewById(R.id.employee_phone);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onClick(getAdapterPosition());
                }
            });
        }

        public void bind(Employee employee) {
            id.setText(employee.getId());
            jobId.setText(employee.getJobId());
            createdAt.setText(employee.getCreatedAt());
            name.setText(employee.getName());
            avatar.setText(employee.getAvatar());
            phone.setText(employee.getPhone());
        }
    }
}
