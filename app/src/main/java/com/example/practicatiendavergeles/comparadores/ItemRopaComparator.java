package com.example.practicatiendavergeles.comparadores;



import com.example.practicatiendavergeles.Item.ItemRopa;

import java.util.Comparator;

public class ItemRopaComparator implements Comparator<ItemRopa> {
    @Override
    public int compare(ItemRopa o1, ItemRopa o2) {
        double sort = o1.compareTo(o2);

        return (int) sort;
    }
}
