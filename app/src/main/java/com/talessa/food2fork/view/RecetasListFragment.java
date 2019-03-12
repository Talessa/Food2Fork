package com.talessa.food2fork.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.talessa.food2fork.R;


public class RecetasListFragment extends Fragment {
    public RecetasListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recetas_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recetaList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new RecetaListAdapter());

        api.getRecetas().observe(){
            recyclerview.list = recetas;
        }

        return view;
    }
}
