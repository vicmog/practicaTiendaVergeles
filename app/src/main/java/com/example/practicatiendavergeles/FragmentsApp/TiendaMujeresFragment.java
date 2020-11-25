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

import com.example.practicatiendavergeles.Item.ItemRopa;
import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.RecyclerViewAdapter.RecyclerViewAdapter;
import com.example.practicatiendavergeles.comparadores.ItemRopaComparator;
import com.example.practicatiendavergeles.comparadores.ItemRopaComparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiendaMujeresFragment extends Fragment {

    private List<ItemRopa>items;
    private TypedArray arrayImagenes;
    private Resources res;
    private View v;
    private Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tienda_mujeres, container, false);

        setHasOptionsMenu(true);
        toolbar = view.findViewById(R.id.miToolbarMujeres);
        ((AppCompatActivity) this.getActivity()).setSupportActionBar(toolbar); //cargar menu en toolbar fragments.
        toolbar.inflateMenu(R.menu.menu);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(getActivity(), R.id.fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();


        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        toolbar.setTitle("");

        v=view;
        res = view.getResources();
        arrayImagenes = res.obtainTypedArray(R.array.imagenes_ropa_mujer);



        cargaArrays();
        cargaReciclerView();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.PrecioAlto:cargaArrays();
            Collections.sort(items,new ItemRopaComparator2());
            cargaReciclerView();

                break;
            case R.id.PrecioBajo:cargaArrays();
                Collections.sort(items,new ItemRopaComparator());
                cargaReciclerView();
                break;
            case R.id.PrecioSinRelevancia:cargaArrays();
            cargaReciclerView();
                break;
        }



        return true;
    }

    private void cargaReciclerView() {
        RecyclerView miRecicler = v.findViewById(R.id.miRecyclerMujeres);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items,v,getActivity(),'m');
        miRecicler.setAdapter(adapter);
        miRecicler.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @SuppressLint("ResourceType")
    private void cargaArrays() {
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