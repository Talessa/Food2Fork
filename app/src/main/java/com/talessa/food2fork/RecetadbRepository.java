package com.talessa.food2fork;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.talessa.food2fork.api.RecetasdbAPI;
import com.talessa.food2fork.api.RecetasdbModule;
import com.talessa.food2fork.model.Receta;
import com.talessa.food2fork.model.SearchResult;
import com.talessa.food2fork.view.RecetasListFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecetadbRepository {

    static RecetasdbAPI recetasdbAPI;


    public  RecetadbRepository(){
        recetasdbAPI = RecetasdbModule.getAPI();
    }

    public LiveData<List<Receta>> getRecetas(){
        final MutableLiveData<List<Receta>> lista = new MutableLiveData<>();

        recetasdbAPI.getRecetas().enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
             lista.setValue(response.body().recipes);
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
            }
        });
        return lista;
    }

}
