package com.example.questgrind.inventory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questgrind.R;
import com.example.questgrind.databinding.FragmentDailyQuestBinding;
import com.example.questgrind.databinding.FragmentInventoryBinding;
import com.example.questgrind.viewModel.AppViewModel;

public class InventoryFragment extends Fragment {
    private AppViewModel viewModel;
    private RecyclerView recyclerView;
    private FragmentInventoryBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentInventoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerViewInventory);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        viewModel.getItems().observe(getViewLifecycleOwner(), items -> {
            InventoryAdapter adapter = new InventoryAdapter(items, item -> {
                ItemFragment dialog = ItemFragment.newInstance(item);
                dialog.show(getParentFragmentManager(), "ItemDetailDialog");
            });
            recyclerView.setAdapter(adapter);
        });
    }

}