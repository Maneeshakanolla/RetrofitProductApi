package com.example.retrofitproductapi.service;

import com.example.retrofitproductapi.model.ProductModel;
import com.example.retrofitproductapi.model.Rating;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetProductDataService {
    @GET("product")
    Call<Rating> getResult();


}
