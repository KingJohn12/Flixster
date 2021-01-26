package com.example.flixster.Adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.items_movies, parent, false);
        return new Viewholder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder" + position);
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView Tvtitle;
        TextView tvOverview;
        ImageView IvPoster;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Tvtitle = itemView.findViewById(R.id.Tvtitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            IvPoster = itemView.findViewById(R.id.IvPoster);

        }

        public void bind(Movie movies) {
            Tvtitle.setText(movies.getTitle());
            tvOverview.setText(movies.getTitle());
            String ImageUrl;

            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            {
                ImageUrl = movies.getBackdropPath();
            }
            else
            {
                ImageUrl = movies.getPosterPath();
            }
            Glide.with(context).load(ImageUrl).into(IvPoster);
        }
    }
}