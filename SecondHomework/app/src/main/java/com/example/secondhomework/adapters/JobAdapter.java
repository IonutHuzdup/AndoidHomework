package com.example.secondhomework.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondhomework.R;
import com.example.secondhomework.models.Job;

import java.util.ArrayList;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private ArrayList<Job> jobs;

    public JobAdapter(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.job_cell, parent, false);
        JobAdapter.JobViewHolder jobViewHolder = new JobAdapter.JobViewHolder(view);
        return jobViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobs.get(position);
        holder.bind(job);
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    class JobViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView companyId;
        private TextView createdAt;
        private TextView name;
        private TextView description;
        private View view;

        public JobViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.job_id);
            companyId = view.findViewById(R.id.job_company_id);
            createdAt = view.findViewById(R.id.job_created_at);
            name = view.findViewById(R.id.job_name);
            description = view.findViewById(R.id.job_description);

        }

        public void bind(Job job) {
            id.setText(job.getId());
            companyId.setText(job.getCompanyId());
            createdAt.setText(job.getCreatedAt());
            name.setText(job.getName());
            description.setText(job.getDescription());

        }
    }
}
