package com.sneha.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserHolder> {

    private final ArrayList<User> users;
    private final Context context;
    private final OnUserClickListener onUserClickListener;

    public UsersAdapter(ArrayList<User> users, Context context, OnUserClickListener onUserClickListener) {
        this.users = users;
        this.context = context;
        this.onUserClickListener = onUserClickListener;
    }

    interface OnUserClickListener {
        void onUserClicked(int position);
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_row_holder, parent, false);

        return new UserHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.txtUsername.setText(users.get(position).getUsername());
        Glide.with(context).load(users.get(position).getProfilePicture()).error(R.drawable.ic_profilr).placeholder(R.drawable.ic_profilr).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        TextView txtUsername;
        ImageView imageView;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(view -> onUserClickListener.onUserClicked(getAdapterPosition()));
            txtUsername = itemView.findViewById(R.id.txtUsername);
            imageView = itemView.findViewById(R.id.img_pro);
        }
    }
}