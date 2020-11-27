package com.example.practicatiendavergeles.FragmentsApp;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practicatiendavergeles.Item.ItemRopa;
import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.RecyclerViewAdapter.RecyclerViewAdapter;
import com.example.practicatiendavergeles.ViewModel.miViewModel;
import com.example.practicatiendavergeles.comparadores.ItemRopaComparator;
import com.example.practicatiendavergeles.comparadores.ItemRopaComparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TiendaFragment extends Fragment {
    private List<ItemRopa> items;
    private TypedArray arrayImagenes;
    private Resources res;
    private View v;
    private Button btFinalizar;
    private miViewModel viewModel;
    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tienda_hombres, container, false);

        setHasOptionsMenu(true);
        toolbar = view.findViewById(R.id.mitoolbarhombres);
        ((AppCompatActivity) this.getActivity()).setSupportActionBar(toolbar); //cargar menu en toolbar fragments.
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setTitle("");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        toolbar.setTitle("");

        viewModel = new ViewModelProvider(getActivity()).get(miViewModel.class);

        v=view;
        res = view.getResources();
        //array hombres
        btFinalizar = view.findViewById(R.id.btFinalizarHombres);
        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModel.getListaCesta()==null){
                    viewModel.createListaCesta();
                }

                navController.navigate(R.id.cestaFragment);

            }
        });


            if(viewModel.getModo()=='h'){
                cargaArraysHombres();
            }else{
                cargaArraysMujeres();
            }

        cargaReciclerView();

    }

    @Override
    public void onResume() {
        super.onResume();
        toolbar.setTitle("");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.PrecioAlto:
                if(viewModel.getModo()=='h'){
                    cargaArraysHombres();
                }else{
                    cargaArraysMujeres();
                }
                Collections.sort(items,new ItemRopaComparator2());
                cargaReciclerView();

                break;
            case R.id.PrecioBajo:
                if(viewModel.getModo()=='h'){
                    cargaArraysHombres();
                }else{
                    cargaArraysMujeres();
                }
                Collections.sort(items,new ItemRopaComparator());
                cargaReciclerView();
                break;
            case R.id.PrecioSinRelevancia:
                if(viewModel.getModo()=='h'){
                    cargaArraysHombres();
                }else{
                    cargaArraysMujeres();
                }
                cargaReciclerView();
                break;
        }



        return true;
    }

    private void cargaReciclerView() {
        RecyclerView miRecicler = v.findViewById(R.id.miRecyclerHombres);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items,v,getActivity(),'h');
        miRecicler.setAdapter(adapter);
        miRecicler.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @SuppressLint("ResourceType")
    private void cargaArraysHombres() {
        arrayImagenes = res.obtainTypedArray(R.array.imagenes_ropa_hombre);
        items = new ArrayList<>();
        ItemRopa itemAux1 = new ItemRopa("Camiseta casual blanca con el dibujo de un tres en raya.",29.99,arrayImagenes.getDrawable(0));
        ItemRopa itemAux2 = new ItemRopa("Camiseta azul del equipo de los Warriors con el numero 88.",16.77,arrayImagenes.getDrawable(1));
        ItemRopa itemAux3 = new ItemRopa("Camiseta blanca con lineas negras dispersas por ella.",10,arrayImagenes.getDrawable(2));
        ItemRopa itemAux4 = new ItemRopa("Pantalones verde pistacho de la marca Jordan",40.50,arrayImagenes.getDrawable(3));
        ItemRopa itemAux5 = new ItemRopa("Pantalones vaqueros azul marino",26.77,arrayImagenes.getDrawable(4));
        ItemRopa itemAux6 = new ItemRopa("Pantalones grises nike con el logo en los lados.",36.33,arrayImagenes.getDrawable(5));
        ItemRopa itemAux7 = new ItemRopa("Chaqueta azul celeste para vestir",136.27,arrayImagenes.getDrawable(6));
        ItemRopa itemAux8 = new ItemRopa("Chaqueta gris celeste para vestir",59.99,arrayImagenes.getDrawable(7));
        ItemRopa itemAux9 = new ItemRopa("Camisa rosa con puntos negros dispersos.",99.99,arrayImagenes.getDrawable(8));
        ItemRopa itemAux10 = new ItemRopa("Gafas marrones y negras con lentes color negras",20.50,arrayImagenes.getDrawable(9));
        ItemRopa itemAux11 = new ItemRopa("Gafas negras con lentes verdes para uso diario.",16.80,arrayImagenes.getDrawable(10));
        ItemRopa itemAux12= new ItemRopa("Gafas de tono azul y con lentes rojizas para uso diario",66.90,arrayImagenes.getDrawable(11));

        items.add(itemAux1);
        items.add(itemAux2);
        items.add(itemAux3);
        items.add(itemAux4);
        items.add(itemAux5);
        items.add(itemAux6);
        items.add(itemAux7);
        items.add(itemAux8);
        items.add(itemAux9);
        items.add(itemAux10);
        items.add(itemAux11);
        items.add(itemAux12);




    }
    @SuppressLint("ResourceType")
    private void cargaArraysMujeres() {
        arrayImagenes = res.obtainTypedArray(R.array.imagenes_ropa_mujer);
        items = new ArrayList<>();
        ItemRopa itemAux1 = new ItemRopa("Camiseta blanca con la palabra Monday incluida",29.99,arrayImagenes.getDrawable(0));
        ItemRopa itemAux2 = new ItemRopa("Camiseta de rayas blancas y negras corta",16.77,arrayImagenes.getDrawable(1));
        ItemRopa itemAux3 = new ItemRopa("Camiseta roja basica para el dia a dia",10,arrayImagenes.getDrawable(2));
        ItemRopa itemAux4 = new ItemRopa("Pantalones verde pistacho semi-cortos",40.50,arrayImagenes.getDrawable(3));
        ItemRopa itemAux5 = new ItemRopa("Pantalones rosas con un lazo",26.77,arrayImagenes.getDrawable(4));
        ItemRopa itemAux6 = new ItemRopa("Pantalones marron claro basicos",36.33,arrayImagenes.getDrawable(5));
        ItemRopa itemAux7 = new ItemRopa("Vestido negro para vestir",136.27,arrayImagenes.getDrawable(6));
        ItemRopa itemAux8 = new ItemRopa("Vestido militar casual para uso diario",59.99,arrayImagenes.getDrawable(7));
        ItemRopa itemAux9 = new ItemRopa("Vestido compuesto por jersey negro y falda de rosas rojas,para un usarlo en ocasiones importantes.",99.99,arrayImagenes.getDrawable(8));
        ItemRopa itemAux10 = new ItemRopa("Gafas negras con lentes color purpura,proteccion rayos uva",20.50,arrayImagenes.getDrawable(9));
        ItemRopa itemAux11 = new ItemRopa("Gafas marrones para uso diario,protegen de los rayos uva",16.80,arrayImagenes.getDrawable(10));
        ItemRopa itemAux12= new ItemRopa("Gafas de tono rojizo para uso diario,protegen de los rayos uva",66.90,arrayImagenes.getDrawable(11));

        items.add(itemAux1);
        items.add(itemAux2);
        items.add(itemAux3);
        items.add(itemAux4);
        items.add(itemAux5);
        items.add(itemAux6);
        items.add(itemAux7);
        items.add(itemAux8);
        items.add(itemAux9);
        items.add(itemAux10);
        items.add(itemAux11);
        items.add(itemAux12);
        //items ordenar



    }
}