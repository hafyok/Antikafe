package com.example.antikafe.mvvm.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

//import com.example.antikafe.com.example.antikafe.Database.MapConverter;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

@Entity
public class Rooms {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo
    private int id;

    @NotNull
    @ColumnInfo
    private String nameRoom;

    @NotNull
    @ColumnInfo
    private String forWhat;

    @NotNull
    @ColumnInfo
    private int price;


    public Rooms(@NotNull String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom){
        this.nameRoom = nameRoom;
    }

    public String getForWhat(){
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}
