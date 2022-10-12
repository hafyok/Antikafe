package com.example.antikafe.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.antikafe.Database.Dao.RoomsDao;
import com.example.antikafe.mvvm.models.Rooms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Rooms.class}, version = 1)
public abstract class RoomsDatabase extends RoomDatabase {

    private static final Rooms[] rooms = {
            new Rooms("Комната отдыха"),
            new Rooms("Коворкинг")
    };

    public abstract RoomsDao roomSDAO();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomsDatabase instance = null;

    public static RoomsDatabase getDatabase(final Context context){
        if (instance == null){
            synchronized (RoomsDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomsDatabase.class,
                                    "rooms_database.db")
                            .addCallback(new Callback(){
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db){
                                    super.onCreate(db);

                                    RoomsDatabase.databaseWriteExecutor.execute(() -> {
                                        instance.roomSDAO().insertAll(rooms);
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        //Toast.makeText(context, rooms.toString(), Toast.LENGTH_LONG).show();
        return instance;
    }

}
