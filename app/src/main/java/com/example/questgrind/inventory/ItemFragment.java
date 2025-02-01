package com.example.questgrind.inventory;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.questgrind.R;

public class ItemFragment extends DialogFragment {

    private static final String ARG_ITEM_NAME = "item_name";
    private static final String ARG_ITEM_IMAGE = "item_image";
    private static final String ARG_ITEM_RANK = "item_rank";
    private static final String ARG_ITEM_ATTRIBUTES = "item_attributes";
    private static final String ARG_ITEM_PASSIVE = "item_passive";

    public static ItemFragment newInstance(Item item) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_NAME, item.getName());
        args.putInt(ARG_ITEM_IMAGE, item.getImage());
        args.putString(ARG_ITEM_RANK, item.getRank());
        args.putString(ARG_ITEM_ATTRIBUTES, item.getAttribute());
        args.putString(ARG_ITEM_PASSIVE, item.getPassive());
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_item, null);

        TextView name = view.findViewById(R.id.detail_item_name);
        TextView rank = view.findViewById(R.id.detail_item_rank);
        TextView attributes = view.findViewById(R.id.detail_item_attributes);
        TextView passive = view.findViewById(R.id.detail_item_passive);
        ImageView image = view.findViewById(R.id.detail_item_image);

        if (getArguments() != null) {
            name.setText(getArguments().getString(ARG_ITEM_NAME));
            rank.setText(getArguments().getString(ARG_ITEM_RANK));
            setRankColor(rank);
            attributes.setText(getArguments().getString(ARG_ITEM_ATTRIBUTES));
            passive.setText(getArguments().getString(ARG_ITEM_PASSIVE));
            image.setImageResource(getArguments().getInt(ARG_ITEM_IMAGE));
        }

        return new AlertDialog.Builder(requireContext())
                .setView(view).create();
    }


    private void setRankColor(TextView rank) {
        // color del rango en base al rango
        switch (getArguments().getString(ARG_ITEM_RANK)) {
            case "S":
                rank.setTextColor(Color.parseColor("#FF0000"));
                rank.setShadowLayer(10,0,0, Color.parseColor("#FF0000"));
                break;
            case "A":
                rank.setTextColor(Color.parseColor("#c802fd"));
                rank.setShadowLayer(10,0,0, Color.parseColor("#c802fd"));
                break;
            case "B": ;
                rank.setTextColor(Color.parseColor("#0094cf"));
                rank.setShadowLayer(10,0,0, Color.parseColor("#0094cf"));
                break;
            case "C":
                rank.setTextColor(Color.parseColor("#ffffff"));
                rank.setShadowLayer(10,0,0, Color.parseColor("#ebebeb"));
                break;
        }
    }
}
