package com.example.antikafe.mvvm.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.antikafe.Database.Dao.RoomsDao;
import com.example.antikafe.Database.RoomsDatabase;
import com.example.antikafe.mvvm.models.Rooms;

import java.util.List;

public class RoomsRepository {
    private RoomsDao mRoomsDao;
    private LiveData<List<Rooms>> mAllRoomS;
    private Context context;

    public RoomsRepository(Context context) {
        this.context = context;
        RoomsDatabase db = RoomsDatabase.getDatabase(context);
        mRoomsDao = db.roomSDAO();
        mAllRoomS = mRoomsDao.getAll();

        //Toast.makeText(context, mAllRoomS.toString(), Toast.LENGTH_LONG).show();

    }

    public LiveData<List<Rooms>> getAllRoomS() {
        return mAllRoomS;
    }

    /*private void updateData(String fromCurrencyName) {
        for (Rooms rooms : mAllRoomS.getValue()) {
            if (currency.getName().equals(fromCurrencyName)) {
                ServiceLocator.getInstance().getNetworkLogic().getCurrencyValues(fromCurrencyName,
                        (currencyValues) -> {
                            currency.setCurrencyValue(currencyValues);
                            CurrenciesDatabase.databaseWriteExecutor.execute(() -> {
                                mCurrenciesDao.update(currency);
                            });
                        });
            }
        }
    }*/
}
