package com.enjelari.movu.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.enjelari.movu.BuildConfig;
import com.enjelari.movu.R;
import com.enjelari.movu.adapters.MoviesAdapter;
import com.enjelari.movu.model.Movies;
import com.enjelari.movu.model.Responses;
import com.enjelari.movu.network.ApiInterface;
import com.enjelari.movu.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public RecyclerView recyclerMovie;
    private MoviesAdapter adapter;
    private List<Movies> moviesList;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerMovie = view.findViewById(R.id.rv_home);
        moviesList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerMovie.setLayoutManager(linearLayoutManager);
        adapter = new MoviesAdapter(getContext());
        recyclerMovie.setAdapter(adapter);
        loadMovies();

    }

    private void loadMovies(){
        ApiInterface server = RetrofitClient.getRetrofit().create(ApiInterface.class);
        Call<Responses> response = server.getNowPlaying(BuildConfig.API_KEY);
        response.enqueue(new Callback<Responses>() {
            @Override
            public void onResponse(Call<Responses> call, Response<Responses> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Movies> listMovie = response.body().getResults();
                        Log.d("Message", "Success : " +listMovie.toString());
                        moviesList.addAll(listMovie);
                        adapter.setMoviesList(moviesList);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Responses> call, Throwable t) {
//                Toast.makeText(getActivity(), "Error to connect : ", Toast.LENGTH_LONG).show();
                Log.d("Message","Error"+t.getMessage());
            }
        });
    }
}
