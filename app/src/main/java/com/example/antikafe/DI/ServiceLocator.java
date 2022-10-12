package com.example.antikafe.DI;

import android.content.Context;

import com.example.antikafe.mvvm.repository.RoomsRepository;

public class ServiceLocator {

    private static ServiceLocator serviceLocator;

    private RoomsRepository mRoomsRepository;


    private Context context;

    private ServiceLocator(Context context) {
        serviceLocator = this;

        mRoomsRepository = new RoomsRepository(context);
        //mNetworkLogic = new NetworkLogic();
    }



    public static ServiceLocator getInstance() {
        return serviceLocator;
    }

    public static void init (Context context){
        serviceLocator = new ServiceLocator(context);
        //Toast.makeText(context, ServiceLocator.getInstance().mRoomsRepository.toString(), Toast.LENGTH_LONG).show();
    }

    public RoomsRepository getRepository() {
        return mRoomsRepository;
    }


   /* public NetworkLogic getNetworkLogic() {
        return mNetworkLogic;
    }*/
}
