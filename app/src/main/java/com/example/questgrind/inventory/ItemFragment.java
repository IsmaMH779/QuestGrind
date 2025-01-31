package com.example.questgrind.inventory;

import android.app.Dialog;
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
            attributes.setText(getArguments().getString(ARG_ITEM_ATTRIBUTES));
            passive.setText(getArguments().getString(ARG_ITEM_PASSIVE));
            image.setImageResource(getArguments().getInt(ARG_ITEM_IMAGE));
        }

        return new AlertDialog.Builder(requireContext())
                .setView(view)
                .setPositiveButton("Cerrar", (dialog, which) -> dismiss())
                .create();
    }
}
