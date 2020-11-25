package com.example.practicatiendavergeles.ViewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.practicatiendavergeles.Item.ItemRopa;

import java.util.ArrayList;
import java.util.List;

public class miViewModel extends androidx.lifecycle.ViewModel {

    private final MutableLiveData<ItemRopa> selected = new MutableLiveData<ItemRopa>();
    private  List<ItemRopa> listaCesta;
    private char modo;

    public void setItem(ItemRopa i){
        selected.setValue(i);

    }
    public void setModo(char i){
        modo=i;

    }
    public char getModo(){
        return modo;
    }
    public ItemRopa getItem(){
        return selected.getValue();
    }

    public void createListaCesta(){
        listaCesta = new ArrayList<>();

    }
    public void insertListaCesta(ItemRopa item){
        listaCesta.add(item);

    }
    public List<ItemRopa> getListaCesta(){

        return listaCesta;
    }

}
