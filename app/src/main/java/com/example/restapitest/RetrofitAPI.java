package com.example.restapitest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("/test/titles")
    Call<List<String>> getTitles();

    @GET("/test")
    Call<List<Data>> getList();

}

