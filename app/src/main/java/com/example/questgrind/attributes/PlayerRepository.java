package com.example.questgrind.attributes;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.questgrind.dataBase.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerRepository {
    private PlayerDao playerDao;
    private LiveData<Player> player;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public PlayerRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        playerDao = db.playerDao();
        player = playerDao.getPlayer();

        executorService.execute(() -> {
            if (playerDao.getPlayerSync() == null) {
                playerDao.insert(new Player());
            }
        });
    }

    public LiveData<Player> getPlayer() {
        return player;
    }

    public void insert(Player player) {
        executorService.execute(() -> playerDao.insert(player));
    }

    public void update(Player player) {
        executorService.execute(() -> playerDao.update(player));
    }
}
