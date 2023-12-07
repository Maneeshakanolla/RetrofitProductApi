package com.example.retrofitproductapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitproductapi.adapter.ProductAdapter;
import com.example.retrofitproductapi.model.ProductModel;
import com.example.retrofitproductapi.model.Rating;
import com.example.retrofitproductapi.service.GetProductDataService;
import com.example.retrofitproductapi.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<ProductModel> productModels;
    RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetProduct();
    }


    public Object GetProduct() {
        GetProductDataService getProductDataService = RetrofitInstance.getService();
        Call<Rating> call = getProductDataService.getResult();
        call.enqueue(new Callback<Rating>() {
            @Override
            public void onResponse(Call<Rating> call, Response<Rating> response) {
                Rating rating=response.body();

                if(rating!= null && rating.getRate() !=null){
                    productModels = (ArrayList<ProductModel>) rating.getResult();

                    for(ProductModel c: productModels){
                        Log.i("TAG", ""+c.getTitle());


                    }

                    ViewData();
                }

            }

            @Override
            public void onFailure(Call<Rating> call, Throwable t) {

            }

        });
    return productModels;

    }

    private void ViewData() {

        recyclerView = findViewById(R.id.recyclerView);
        productAdapter = new ProductAdapter(productModels);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);
    }

}
