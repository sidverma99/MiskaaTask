package com.example.mytask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetData {
    @GET("rest/v2/region/{region}")
    Call<List<Response>> getAllData(@Path("region") String region);
}
