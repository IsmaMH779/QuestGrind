package com.example.questgrind.attributes;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.questgrind.R;
import com.example.questgrind.dailyQuest.QuestAdapter;
import com.example.questgrind.databinding.FragmentAttributesBinding;
import com.example.questgrind.databinding.FragmentDailyQuestBinding;
import com.example.questgrind.viewModel.AppViewModel;

public class AttributesFragment extends Fragment {

    private FragmentAttributesBinding binding;
    private AppViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAttributesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // configurar recyclerview
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // obtener el ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        viewModel.getPlayer().observe(getViewLifecycleOwner(), player -> {
            binding.playerName.setText(player.getName());
            binding.playerLevel.setText(String.valueOf("Lvl " + player.getLevel()));

            int currentXP = player.getXp();
            int maxXP = player.getXpToNextLevel();
            binding.xpBar.setMax(maxXP);
            binding.xpBar.setProgress(currentXP);

            AttributesAdapter adapter = new AttributesAdapter(viewModel, position -> {
                viewModel.addLevelToAttribute(position);
            });

            binding.recyclerView.setAdapter(adapter);

            if (player.getAviableSkillPoints() > 0) {
                binding.aviablePointsText.setText("Puntos disponibles: " + String.valueOf(player.getAviableSkillPoints()));
            } else {
                binding.aviablePointsText.setText("Puntos disponibles: 0");
            }
        });

    }
}