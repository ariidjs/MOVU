package com.enjelari.movu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.enjelari.movu.BuildConfig;
import com.enjelari.movu.R;
import com.enjelari.movu.model.Movies;

import java.util.ArrayList;
import java.util.List;

import me.grantland.widget.AutofitHelper;
import me.grantland.widget.AutofitTextView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private Context context;
    private List<Movies> moviesList = new ArrayList<>();

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public void setMoviesList(List<Movies> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final Movies movies = moviesList.get(holder.getAdapterPosition());
        String img_url = BuildConfig.IMG_URL + movies.getPosterPath();
        Glide.with(context).load(img_url).apply(new RequestOptions().override(350,550))
                .into(holder.img_movie);
        holder.tv_title.setText(movies.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        AutofitTextView tv_title;
        ImageView img_movie;
        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_movie = itemView.findViewById(R.id.img_movie);
            AutofitHelper.create(tv_title);
        }
    }
}
