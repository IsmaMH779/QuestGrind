package com.example.questgrind.attributes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questgrind.R;
import com.example.questgrind.databinding.FragmentAttributesBinding;
import com.example.questgrind.databinding.FragmentDailyQuestBinding;
import com.example.questgrind.viewModel.ViewModel;

public class AttributesFragment extends Fragment {

    private FragmentAttributesBinding binding;
    private ViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAttributesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // obtener el ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(ViewModel.class);

        viewModel.getPlayer().observe(getViewLifecycleOwner(), player -> {
            binding.playerName.setText(player.getName());
            binding.playerLevel.setText(String.valueOf(player.getLevel()));
        });

    }
}