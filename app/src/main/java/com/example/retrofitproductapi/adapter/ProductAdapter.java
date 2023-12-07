package com.example.retrofitproductapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitproductapi.R;
import com.example.retrofitproductapi.model.ProductModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<ProductModel>  productModelArrayList ;

    RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    public ProductAdapter(ArrayList<ProductModel> productModelList) {
        this.productModelArrayList = productModelList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_item,parent,false);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.textView.setText(productModelArrayList.get(position).getTitle());
      //  holder.textView1.setText(productModelArrayList.get(position).getPrice().toString());
        holder.textView2.setText(productModelArrayList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return productModelArrayList.size();
    }


    // View Holder

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView1,textView2;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.title);
            textView1=itemView.findViewById(R.id.price);
            textView2=itemView.findViewById(R.id.description);
        }
    }
}