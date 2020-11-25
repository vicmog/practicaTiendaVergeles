package com.example.practicatiendavergeles.RecyclerViewAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicatiendavergeles.Item.ItemRopa;
import com.example.practicatiendavergeles.R;
import com.example.practicatiendavergeles.ViewModel.miViewModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ItemRopa>items;
    private View vista;
    private Activity activity;
    private char modo;


    public RecyclerViewAdapter(List<ItemRopa> items, View vista,Activity acti,char m) {
        this.items = items;
        this.vista = vista;
        this.activity = acti;
        this.modo=m;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(vista);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    final NavController navController = Navigation.findNavController(vista);
    holder.precio.setText(items.get(position).getPrecio()+"");
    holder.foto.setImageDrawable(items.get(position).getImagen());
    holder.descripcion.setText(items.get(position).getDescripcion());
    holder.parent_layout.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
                miViewModel miViewModel = new ViewModelProvider((ViewModelStoreOwner) activity).get(com.example.practicatiendavergeles.ViewModel.miViewModel.class);
                miViewModel.setItem(items.get(position));
                miViewModel.setModo(modo);
                navController.navigate(R.id.fragmentElementoRopa);
        }
    });

    }


    @Override
    public int getItemCount() {

        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

     ImageView foto;
     TextView descripcion;
     TextView precio;
     ConstraintLayout parent_layout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        foto = itemView.findViewById(R.id.imgRopa);
        descripcion = itemView.findViewById(R.id.tvDescripcion);
        precio = itemView.findViewById(R.id.tvPrecio);
        parent_layout = itemView.findViewById(R.id.clLayout);

    }
}

}
