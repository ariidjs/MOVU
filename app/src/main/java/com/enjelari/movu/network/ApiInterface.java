package com.enjelari.movu.network;

import com.enjelari.movu.model.Responses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/now_playing")
    Call<Responses> getNowPlaying(@Query("api_key") String apiKey);
//    @GET("genre/movie/list")
//    Call<GenresResponse> getGenre(@Query("api_key") String apiKey);
}
