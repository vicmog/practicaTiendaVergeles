package com.example.practicatiendavergeles.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.practicatiendavergeles.Item.ItemRopa;

import java.util.ArrayList;
import java.util.List;

public class miViewModel extends ViewModel {

    private final MutableLiveData<ItemRopa>item = new MutableLiveData<ItemRopa>();
    private  List<ItemRopa> listaCesta;
    private char modo;

    public void setItem(ItemRopa i){
        item.setValue(i);

    }
    public void setModo(char i){
        modo=i;

    }
    public char getModo(){
        return modo;
    }
    public ItemRopa getItem(){
        return item.getValue();
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
