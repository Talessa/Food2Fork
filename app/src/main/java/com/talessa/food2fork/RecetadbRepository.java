package com.talessa.food2fork;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecetadbRepository {

    RecetasdbAPI recetasdbAPI;

    public RecetadbRepository(){
        recetasdbAPI = RecetasdbModule.getAPI();
    }

    public LiveData<List<Receta>> getRecetas(){
        final MutableLiveData<List<Receta>> lista = new MutableLiveData<>();

        recetasdbAPI.getRecetas().enqueue(new Callback<RecetasListFragment>() {
            @Override
            public void onResponse(Call<RecetasListFragment> call, Response<RecetasListFragment> response) {
                lista.setValue(response.body().resultado);
            }

            @Override
            public void onFailure(Call<RecetasListFragment> call, Throwable t) {

            }
        });
        return lista;
    }

}
