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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicatiendavergeles.Item.ItemRopa;
import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.ViewModel.miViewModel;

public class FragmentElementoRopa extends Fragment {
    private miViewModel viewModel;
    private ImageView imagen;
    private TextView descripcion ;
    private TextView precio ;
    private Button btComprar;

    private char modo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elemento_ropa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = view.findViewById(R.id.mitoolbarElemento);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        toolbar.setTitle("");


        viewModel = new ViewModelProvider(getActivity()).get(miViewModel.class);

        ItemRopa item = viewModel.getItem();
        

        imagen = view.findViewById(R.id.imgElementoRopa);
        descripcion = view.findViewById(R.id.tvDescripcionElementoRopa);
        precio = view.findViewById(R.id.tvPrecioElementoRopa);

        imagen.setImageDrawable(item.getImagen());
        descripcion.setText(item.getDescripcion());
        precio.setText(item.getPrecio()+"");

        btComprar = view.findViewById(R.id.btComprar);


        btComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModel.getListaCesta()==null){
                    viewModel.createListaCesta();
                    viewModel.insertListaCesta(item);
                }else{
                    boolean comprado = false;

                    for (int i = 0; i < viewModel.getListaCesta().size() ; i++) {
                        if(viewModel.getListaCesta().get(i).getDescripcion().equals(item.getDescripcion())){
                            comprado = true;
                        }
                    }
                    if (!comprado){
                        viewModel.insertListaCesta(item);
                    }

                }


                    navController.navigate(R.id.inicioFragment);

                  




            }
        });


    }
}