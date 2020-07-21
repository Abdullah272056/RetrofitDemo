package com.example.retrofitdemousingrealapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient2 {
    @GET("continents/{id}")
    Call<OurMainDataClass2> getData(@Path  ("id")int id,@Query("api_token") String token);
}
