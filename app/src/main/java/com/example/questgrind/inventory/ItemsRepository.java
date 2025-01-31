package com.example.questgrind.inventory;

import com.example.questgrind.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    private List<Item> items;

    public ItemsRepository() {
        items = new ArrayList<>();

        items.add(new Item("Espada de Fuego", R.drawable.sword_fire, "S", "+10 Fuerza", "Golpe Ígneo: 5% de la vida del enemigo como daño extra"));
    }

    public List<Item> getItemsRepositoryList() {
        return items;
    }

}
