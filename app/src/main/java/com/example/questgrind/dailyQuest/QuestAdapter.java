package com.example.questgrind.dailyQuest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.questgrind.R;
import com.example.questgrind.viewModel.AppViewModel;

import java.util.List;

public class QuestAdapter extends RecyclerView.Adapter<QuestAdapter.QuestViewHolder> {
    private final List<Quest> questList;
    private final AppViewModel viewModel;

    public QuestAdapter(List<Quest> questList, AppViewModel viewModel) {
        this.questList = questList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public QuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quest, parent, false);
        return new QuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestViewHolder holder, int position) {
        Quest quest = questList.get(position);
        holder.titleTextView.setText(quest.getTitle());
        holder.completedCheckBox.setChecked(quest.getCompleted());

        // si la tarea esta completada deshabilita el checkbox
        holder.completedCheckBox.setEnabled(!quest.getCompleted());

        // Manejar la interaccion de los checkbox
        holder.completedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                viewModel.updateQuest(quest.getId(), true);

                // Deshabilita el checkbox para evitar cambios
                holder.completedCheckBox.setEnabled(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questList.size();
    }

    static class QuestViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        CheckBox completedCheckBox;

        public QuestViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            completedCheckBox = itemView.findViewById(R.id.checkBoxCompleted);
        }
    }
}
