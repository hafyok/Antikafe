package com.example.antikafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.antikafe.DI.ServiceLocator;
import com.example.antikafe.databinding.FragmentRoomsBinding;

public class MainActivity extends AppCompatActivity {
    /*RoomsDatabase db = RoomsDatabase.getDatabase(this);
    LiveData<List<Rooms>> roomsLiveData = db.roomSDAO().getAll();*/
    FragmentRoomsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceLocator.init(getApplicationContext());

        /*RoomsDatabase db = RoomsDatabase.getDatabase(getApplicationContext());

        RoomsDao roomsDao = db.roomSDAO();
        List<Rooms> rooms = (List<Rooms>) roomsDao.getAll();
        Toast.makeText(this, rooms.toString(), Toast.LENGTH_SHORT).show();

        List<String> data = new ArrayList<String>();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("DLKJD");
*/

        //ServiceLocator.init(getApplicationContext());

        /*ServiceLocator.getInstance().getRepository().getAllRoomS().observe(this, new Observer<List<Rooms>>() {
            @Override
            public void onChanged(List<Rooms> rooms) {
                Toast.makeText(MainActivity.this, rooms.toString(), Toast.LENGTH_LONG).show();
            }
        });*/

    }
}