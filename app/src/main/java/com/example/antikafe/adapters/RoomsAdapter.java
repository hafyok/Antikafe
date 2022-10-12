package com.example.antikafe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.antikafe.adapters.viewHolders.RoomsViewHolder;
import com.example.antikafe.databinding.RoomElementBinding;
import com.example.antikafe.mvvm.views.RoomsFragment;


import java.util.List;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsViewHolder> {

    private final List<String> rooms;
    private final RoomsFragment roomsFragment;

    public RoomsAdapter(RoomsFragment roomsFragment, List<String> rooms){
        this.roomsFragment = roomsFragment;
        this.rooms = rooms;
    }
    @NonNull
    @Override
    public RoomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RoomElementBinding el = RoomElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RoomsViewHolder(el);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomsViewHolder holder, int position) {
        holder.getRadioButton().setText(rooms.get(position));
        holder.getRadioButton().setChecked(roomsFragment.getChangingRooms().getValue().equals(rooms.get(position)));
        holder.getRadioButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roomsFragment.getChangingRooms().setValue(rooms.get(position));
                Toast.makeText(view.getContext(), "dismiss", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }
}
