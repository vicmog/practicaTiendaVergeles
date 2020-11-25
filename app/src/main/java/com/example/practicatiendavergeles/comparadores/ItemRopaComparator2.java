package com.example.practicatiendavergeles.comparadores;

import com.example.practicatiendavergeles.Item.ItemRopa;

import java.util.Comparator;

public class ItemRopaComparator2 implements Comparator<ItemRopa> {
    @Override
    public int compare(ItemRopa o1, ItemRopa o2) {
        return o1.compareTo2(o2);
    }
}
