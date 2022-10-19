package com.example.antikafe.mvvm.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.antikafe.DI.ServiceLocator;
import com.example.antikafe.mvvm.models.Rooms;
import com.example.antikafe.mvvm.repository.RoomsRepository;

import java.util.List;

public class RoomsViewModel extends AndroidViewModel {

    private RoomsRepository mRepository;
    private LiveData<List<Rooms>> mRooms;

    public RoomsViewModel(@NonNull Application application) {
        super(application);

        mRepository = ServiceLocator.getInstance().getRepository();
        mRooms = mRepository.getAllRoomS();
        
    }

    public LiveData<List<Rooms>> getRooms(){
        return mRooms;
    }

}
