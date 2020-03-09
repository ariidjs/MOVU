package com.enjelari.movu.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enjelari.movu.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.)
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
