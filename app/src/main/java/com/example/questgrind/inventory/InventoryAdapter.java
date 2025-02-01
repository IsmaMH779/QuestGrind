package com.example.questgrind.inventory;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questgrind.R;

import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {

    private List<Item> items;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public InventoryAdapter(List<Item> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public InventoryAdapter.InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryAdapter.InventoryViewHolder holder, int position) {
        Item item = items.get(position);

        holder.name.setText(item.getName());

        // color del rango en base al rango
        switch (item.getRank()) {
            case "S":
                holder.rank.setText(item.getRank());
                holder.rank.setTextColor(Color.parseColor("#FF0000"));
                holder.rank.setShadowLayer(10,0,0, Color.parseColor("#FF0000"));
                break;
            case "A":
                holder.rank.setText(item.getRank());
                holder.rank.setTextColor(Color.parseColor("#c802fd"));
                holder.rank.setShadowLayer(10,0,0, Color.parseColor("#c802fd"));
                break;
            case "B":
                holder.rank.setText(item.getRank());
                holder.rank.setTextColor(Color.parseColor("#0094cf"));
                holder.rank.setShadowLayer(10,0,0, Color.parseColor("#0094cf"));
                break;
            case "C":
                holder.rank.setText(item.getRank());
                holder.rank.setTextColor(Color.parseColor("#ffffff"));
                holder.rank.setShadowLayer(10,0,0, Color.parseColor("#ebebeb"));
                break;
        }
        holder.image.setImageResource(item.getImage());

        // Click en el item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class InventoryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, rank;
        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.itemName);
            rank = itemView.findViewById(R.id.itemRank);
            image = itemView.findViewById(R.id.itemImage);
        }
    }
}
