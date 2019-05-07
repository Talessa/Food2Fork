package com.talessa.food2fork.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talessa.food2fork.R;
import com.talessa.food2fork.RecetasViewModel;
import com.talessa.food2fork.model.Receta;

import java.util.List;


public class RecetasListFragment extends Fragment {

    private RecetasViewModel ViewModel;
    private RecyclerView recyclerView;
    private RecetaListAdapter recetaListAdapter;
    public RecetasListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recetas_list, container, false);

        recyclerView = view.findViewById(R.id.recetaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recetaListAdapter = new RecetaListAdapter();
        recyclerView.setAdapter(recetaListAdapter);

        ViewModel = ViewModelProviders.of(this).get(RecetasViewModel.class);
        ViewModel.getRecetas().observe(this, new Observer<List<Receta>>() {
            @Override
            public void onChanged(@Nullable List<Receta> recetas) {
                recetaListAdapter.recetaList = recetas;
                for(Receta receta:recetas){
                    Log.e("RECETAS", receta.title);
                }
                recetaListAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
