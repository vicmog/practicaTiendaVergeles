package com.example.practicatiendavergeles.FragmentsApp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.ViewModel.miViewModel;

public class InicioFragment extends Fragment {

private Button btHombres,btMujeres;
private miViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btHombres = view.findViewById(R.id.btHombres);
        btMujeres = view.findViewById(R.id.btMujeres);
        viewModel = new ViewModelProvider(getActivity()).get(miViewModel.class);
        btHombres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            viewModel.setModo('h');
            navController.navigate(R.id.tiendaFragment);
            }
        });
        btMujeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            viewModel.setModo('m');
            navController.navigate(R.id.tiendaFragment);

            }
        });
    }
}