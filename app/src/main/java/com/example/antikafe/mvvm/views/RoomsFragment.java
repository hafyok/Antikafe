package com.example.antikafe.mvvm.views;

import static java.util.stream.Collectors.toList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.antikafe.adapters.RoomsAdapter;
import com.example.antikafe.databinding.FragmentRoomsBinding;
import com.example.antikafe.mvvm.models.Rooms;
import com.example.antikafe.mvvm.viewModels.RoomsViewModel;

import java.util.ArrayList;
import java.util.List;


public class RoomsFragment extends Fragment {
    private RoomsViewModel mViewModel;
    private MutableLiveData<String> changingRooms;
    FragmentRoomsBinding binding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> data = new ArrayList<String>();
        data.add("A");
        data.add("B");
        data.add("C");

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);*/

        mViewModel = new ViewModelProvider(this).get(RoomsViewModel.class);
        changingRooms = mViewModel.getRoomsList();

        mViewModel.getRooms().observe(getViewLifecycleOwner(), rooms -> {
                    binding.roomsRecyclerView.setAdapter(
                            new RoomsAdapter(
                                    this,
                                    rooms.stream().map(Rooms::getNameRoom).collect(toList())
                            )
                    );
                }
        );

        /*mViewModel.getRooms().observe(getViewLifecycleOwner(), rooms -> {
            Toast.makeText(getContext(), rooms.stream().map(Rooms::getNameRoom).collect(toList()).toString(), Toast.LENGTH_SHORT).show();
                }
        );*/

        //Toast.makeText(getContext(), mViewModel.getRooms().toString(), Toast.LENGTH_SHORT).show();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRoomsBinding.inflate(inflater, container, false);
        View v = binding.getRoot();

        binding.roomsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //return inflater.inflate(R.layout.fragment_rooms, null);

        return v;
    }

    public MutableLiveData<String> getChangingRooms(){
        return changingRooms;
    }
}