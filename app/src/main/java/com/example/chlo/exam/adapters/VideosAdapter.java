package com.example.chlo.exam.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chlo.exam.R;
import com.example.chlo.exam.models.Videos;
import com.example.chlo.exam.viewholders.VideosViewHolder;

/**
 * Created by Chloe on 17/03/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosViewHolder> {

    private final Videos videos;

    public VideosAdapter(Videos videos) {
        this.videos = videos;
    }

    @Override
    public VideosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false);
        return new VideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosViewHolder holder, int position) {
        holder.bind(videos.getItems().get(position));
    }

    @Override
    public int getItemCount() {
        return videos != null ? videos.getItems().size() : 0;
    }
}
