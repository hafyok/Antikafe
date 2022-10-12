package com.example.antikafe.adapters.viewHolders;

import android.widget.RadioButton;

import androidx.recyclerview.widget.RecyclerView;

import com.example.antikafe.databinding.RoomElementBinding;

public class RoomsViewHolder extends RecyclerView.ViewHolder{

    RadioButton radioButton;

    public RoomsViewHolder(RoomElementBinding el) {
        super(el.getRoot());
        radioButton = el.rButton;
    }

    public RadioButton getRadioButton(){
        return radioButton;
    }
}