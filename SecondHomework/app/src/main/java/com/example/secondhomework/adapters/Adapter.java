package com.example.secondhomework.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondhomework.R;
import com.example.secondhomework.interfaces.OnCellClick;
import com.example.secondhomework.models.User;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {
    private ArrayList<User> users;
    private OnCellClick click;

    public Adapter(ArrayList<User> users, OnCellClick click) {
        this.users = users;
        this.click = click;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_cell, parent, false);

        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView id;
        private TextView createdAt;
        private TextView name;
        private TextView avatar;
        private TextView description;
        private ImageView image;
        private View view;

        public UserViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id);
            createdAt = view.findViewById(R.id.created_at);
            name = view.findViewById(R.id.name);
            avatar = view.findViewById(R.id.avatar);
            description = view.findViewById(R.id.description);
            image = view.findViewById(R.id.image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.onClick(getAdapterPosition());
                }
            });
        }

        public void bind(User user) {
            id.setText(user.getId());
            createdAt.setText(user.getCreatedAt());
            name.setText(user.getName());
            avatar.setText(user.getAvatar());
            description.setText(user.getDescription());

        }
    }
}
