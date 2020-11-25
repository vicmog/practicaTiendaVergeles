package com.example.practicatiendavergeles.FragmentsApp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practicatiendavergeles.R;

public class InicioFragment extends Fragment {

private Button btHombres,btMujeres;
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
        btHombres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            navController.navigate(R.id.tiendaHombresFragment);
            }
        });
        btMujeres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.tiendaMujeresFragment);
            }
        });
    }
}