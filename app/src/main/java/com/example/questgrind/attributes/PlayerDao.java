package com.example.questgrind.attributes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PlayerDao {
    @Insert
    void insert(Player player);

    @Update
    void update(Player player);

    @Query("SELECT * FROM player LIMIT 1")
    LiveData<Player> getPlayer();

    @Query("SELECT * FROM player LIMIT 1")
    Player getPlayerSync();
}
