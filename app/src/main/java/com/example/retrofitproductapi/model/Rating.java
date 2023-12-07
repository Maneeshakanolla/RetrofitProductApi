package com.example.retrofitproductapi.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Generated("jsonschema2pojo")
public class Rating {

    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("result")
    @Expose
    private List<ProductModel> result;
    @SerializedName("extra")
    @Expose
    private List<Object> extra;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductModel> getResult() {
        return result;
    }

    public void setResult(List<ProductModel> result) {
        this.result = result;
    }

    public List<Object> getExtra() {
        return extra;
    }

    public void setExtra(List<Object> extra) {
        this.extra = extra;
    }
}