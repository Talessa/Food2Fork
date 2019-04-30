package com.talessa.food2fork.api;

import com.talessa.food2fork.model.SearchResult;
import com.talessa.food2fork.view.RecetasListFragment;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecetasdbAPI {
    @GET("/api/search")
    Call<SearchResult> getRecetas();
}
