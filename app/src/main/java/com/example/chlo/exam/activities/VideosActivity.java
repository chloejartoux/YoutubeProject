package com.example.chlo.exam.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chlo.exam.Constants;
import com.example.chlo.exam.R;
import com.example.chlo.exam.adapters.VideosAdapter;
import com.example.chlo.exam.models.Videos;
import com.google.gson.Gson;


public class VideosActivity extends AppCompatActivity {


    private static final String VIDEOS_URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=";
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_videos);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView search = (SearchView) this.findViewById(R.id.searchView);

        search.setActivated(true);
        search.setQueryHint("Type your keyword here");
        search.onActionViewExpanded();
        search.setIconified(false);
        search.clearFocus();


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getVideos(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });







    }



    private void getVideos(String query) {

        String values = query.replace(' ', '+');
        StringRequest videosRequest = new StringRequest(VIDEOS_URL+values+"&type=video&key=" + Constants.API_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Videos videos = new Gson().fromJson(response, Videos.class);

                setAdapter(videos);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Videos", "Error");
            }


        });
        Volley.newRequestQueue(this).add(videosRequest);


    }
    private void setAdapter(Videos videos) {
        VideosAdapter adapter = new VideosAdapter(videos);
        recyclerView.setAdapter(adapter);
    }
}
