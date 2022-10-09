package com.example.antikafe.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.antikafe.mvvm.models.Rooms;

import java.util.List;

@Dao
public interface RoomsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Rooms rooms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Rooms[] rooms);

    @Query("DELETE FROM rooms")
    void deleteAll();

    @Update
    void update(Rooms rooms);

    @Query("SELECT * FROM rooms")
    LiveData<List<Rooms>> getAll();
}
