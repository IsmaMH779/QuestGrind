package com.example.questgrind.inventory;

import com.example.questgrind.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsRepository {
    private List<Item> items;

    public ItemsRepository() {
        items = new ArrayList<>();

        items.add(new Item("Daga del novato", R.drawable.daga_peq, "C", "+5 Fuerza", "Afilado: 5% de daño extra."));
        items.add(new Item("Armadura basica", R.drawable.armadura_basica, "B", "+5 Vitalidad", "Coraje: +10% de vida adicional."));
        items.add(new Item("Sable de fuego", R.drawable.sable_afilado, "A", "+25 Fuerza", "Golpe Ígneo: 5% de la vida del enemigo como daño extra"));
        items.add(new Item("Katana legendaria", R.drawable.katana_legendaria, "S", "+70 Fuerza", "Filo legendario: 70% crit. \n\nDesgarrador: aplica sangrado [10%] vida del objetivo."));
    }

    public List<Item> getItemsRepositoryList() {
        return items;
    }

}
