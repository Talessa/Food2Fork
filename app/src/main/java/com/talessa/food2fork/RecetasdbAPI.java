package com.talessa.food2fork;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecetasdbAPI {
    @GET("/api/search")
    Call<RecetasListFragment> getRecetas();

}
