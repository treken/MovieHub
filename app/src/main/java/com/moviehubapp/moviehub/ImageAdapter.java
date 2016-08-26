package com.moviehubapp.moviehub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by TeeJay on 8/10/2016.
 */
public class ImageAdapter extends
        RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final String LOG_TAG = ImageAdapter.class.getSimpleName();

    private Context mContext;
    private List<Movie> data;

    public ImageAdapter(Context mContext, List data) {

        this.mContext = mContext;
        this.data = data;

    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder viewHolder, int position) {

        Movie movie = data.get(position);

        ImageView moviePoster = viewHolder.poster;
        moviePoster.setImageBitmap(data.get(position).getmMoviePosterBitmap());

        TextView movieId = viewHolder.id;
        movieId.setText(String.valueOf(movie.getmMovieId()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        View singlePosterLayout = inflater.inflate(R.layout.single_poster_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(singlePosterLayout);

        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView poster;
        public TextView id;

        public ViewHolder(View itemView) {
            super(itemView);

            poster = (ImageView) itemView.findViewById(R.id.imageview_single_poster);
            id = (TextView) itemView.findViewById(R.id.textview_movie_id);
        }

    }
}