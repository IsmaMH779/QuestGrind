package com.example.questgrind.attributes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questgrind.R;
import com.example.questgrind.dailyQuest.QuestAdapter;
import com.example.questgrind.viewModel.AppViewModel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttributesAdapter extends RecyclerView.Adapter<AttributesAdapter.AttributeViewHolder> {

    private final String[] attributes = {"Vitality", "Strength", "Intelligence", "Agility", "Perception"};

    private AppViewModel viewModel;
    private final OnAddPointClickListener onAddPointClickListener;

    public interface OnAddPointClickListener {
        void onAddPointClick(int position);
    }

    public AttributesAdapter(AppViewModel viewModel, OnAddPointClickListener listener) {
        this.viewModel = viewModel;
        this.onAddPointClickListener = listener;
    }

    @NonNull
    @Override
    public AttributeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attribute, parent, false);
        return new AttributeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttributeViewHolder holder, int position) {
        // extraer el nombre del atributo
        String attribute = attributes[position];
        int value = 0;

        switch (position) {
            case 0: value = viewModel.getPlayer().getValue().getVitality(); break;
            case 1: value = viewModel.getPlayer().getValue().getStrength(); break;
            case 2: value = viewModel.getPlayer().getValue().getIntelligence(); break;
            case 3: value = viewModel.getPlayer().getValue().getAgility(); break;
            case 4: value = viewModel.getPlayer().getValue().getPerception(); break;
        }

        holder.attributeName.setText(attribute);
        holder.attributeValue.setText(String.valueOf(value));
        holder.addButton.setVisibility(viewModel.getPlayer().getValue().getAviableSkillPoints() > 0 ? View.VISIBLE : View.GONE);

        holder.addButton.setOnClickListener(v -> onAddPointClickListener.onAddPointClick(position));
    }

    @Override
    public int getItemCount() {
        return attributes.length;
    }

    static class AttributeViewHolder extends RecyclerView.ViewHolder {
        TextView attributeName, attributeValue;
        Button addButton;

        public AttributeViewHolder(@NonNull View itemView) {
            super(itemView);
            attributeName = itemView.findViewById(R.id.attributeName);
            attributeValue = itemView.findViewById(R.id.attributeValue);
            addButton = itemView.findViewById(R.id.addButton);
        }
    }
}

