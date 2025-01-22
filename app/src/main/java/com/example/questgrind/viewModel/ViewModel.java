package com.example.questgrind.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.questgrind.dailyQuest.Quests;

import java.util.concurrent.Executor;

public class ViewModel extends AndroidViewModel {

    Executor executor;

    Quests quest;

    public ViewModel(@NonNull Application application) {
        super(application);
    }

}
