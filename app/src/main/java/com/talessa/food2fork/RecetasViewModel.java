package com.talessa.food2fork;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.talessa.food2fork.model.Receta;

import java.util.List;

public class RecetasViewModel extends AndroidViewModel {
    private RecetadbRepository recetadbRepository;

    public RecetasViewModel(@NonNull Application application) {
        super(application);
        recetadbRepository = new RecetadbRepository();
    }

    public LiveData<List<Receta>> getRecetas(){
        return recetadbRepository.getRecetas();
    }
}