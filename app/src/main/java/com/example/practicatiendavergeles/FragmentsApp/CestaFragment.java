package com.example.practicatiendavergeles.FragmentsApp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.practicatiendavergeles.Item.ItemRopa;
import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.RecyclerViewAdapter.RecyclerViewAdapterCesta;
import com.example.practicatiendavergeles.ViewModel.miViewModel;

import java.util.List;


public class CestaFragment extends Fragment {

    private miViewModel viewModel;
    private List<ItemRopa> items;
    private View v;
    private Button btFinalizar;
    private TextView tvPrecioSinIVA,tvPrecioTotal,tvIVA;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cesta, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = view.findViewById(R.id.mitoolbarCesta);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        toolbar.setTitle("");
        tvPrecioSinIVA = view.findViewById(R.id.tvPrecioSinIVA);
        tvPrecioTotal = view.findViewById(R.id.tvPrecioTotal);
        tvIVA = view.findViewById(R.id.tvIVA);
        btFinalizar = view.findViewById(R.id.btFinalizarAcabar);
        viewModel =new ViewModelProvider(getActivity()).get(miViewModel.class);
        items = viewModel.getListaCesta();
        v=view;
        
        calculaPrecios();
        cargaReciclerView();
        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.createListaCesta();
                navController.navigate(R.id.inicioFragment);
            }
        });


    }

    private void calculaPrecios() {
        Double precio = 0.0;
        for (int i = 0; i < items.size(); i++) {
            precio = precio +items.get(i).getPrecio();
        }
        Double iva =precio*0.21;
        Double preciototal = precio+iva;
        tvPrecioSinIVA.setText(precio+"");
        tvIVA.setText(iva+"");
        tvPrecioTotal.setText(preciototal+"");


    }

    private void cargaReciclerView() {
        RecyclerView miRecicler = v.findViewById(R.id.mirecyclerviewCesta);
        RecyclerViewAdapterCesta adapter = new RecyclerViewAdapterCesta(items,v,getActivity());
        miRecicler.setAdapter(adapter);
        miRecicler.setLayoutManager(new LinearLayoutManager(getActivity()));


    }
}