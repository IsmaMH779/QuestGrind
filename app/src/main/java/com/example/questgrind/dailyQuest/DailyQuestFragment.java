package com.example.questgrind.dailyQuest;

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
import com.example.questgrind.databinding.FragmentDailyQuestBinding;
import com.example.questgrind.viewModel.AppViewModel;

public class DailyQuestFragment extends Fragment {

    private FragmentDailyQuestBinding binding;
    private AppViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDailyQuestBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // configurar el Recycler view
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // obtener el ViewModel
        viewModel = new ViewModelProvider(requireActivity()).get(AppViewModel.class);

        // observar los datos de la lista
        viewModel.getQuestList().observe(getViewLifecycleOwner(), quests -> {
            QuestAdapter adapter = new QuestAdapter(quests, viewModel);
            binding.recyclerView.setAdapter(adapter);
        });

        // observar los datos del boleano que determina si se han completado todas las misiones
        viewModel.getAllQuestsCompleted().observe(getViewLifecycleOwner(), isCompleted -> {
            if (isCompleted != null && isCompleted) {
                viewModel.giveXP();
                binding.completedInfo.setText("¡Felcidades has completado las misiones diarias de hoy!");
            } else {
                binding.completedInfo.setText("¡Atencion! - No hacer las misiones diarias ralentizara tu progreso.");
            }
        });
    }
}