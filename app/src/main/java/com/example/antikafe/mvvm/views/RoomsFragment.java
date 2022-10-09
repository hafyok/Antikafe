package com.example.antikafe.mvvm.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.MutableLiveData;

import com.example.antikafe.R;
import com.example.antikafe.databinding.ActivityMainBinding;
import com.example.antikafe.mvvm.viewModels.RoomsViewModel;


public class RoomsFragment extends ListFragment {
    private RoomsViewModel mViewModel;
    private MutableLiveData<String> changingRooms;
    ActivityMainBinding binding;

    String data[] = new String[]{"one", "two", "three", "four"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //*binding = ActivityMainBinding.inflate(inflater, container, false);
        //View v = binding.getRoot();

        //binding.currenciesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        /*binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });*/

        return inflater.inflate(R.layout.fragment_rooms, null);

    }
}