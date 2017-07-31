package com.example.allinone.ui.main;

import android.databinding.ViewDataBinding;

import com.example.allinone.BR;
import com.example.allinone.R;
import com.example.allinone.ui.common.adapter.RecyclerBindingAdapter;
import com.example.allinone.model.CurrencyData;

/**
 * Created by katakin on 24/07/17.
 */

public class MainRecyclerBindingAdapter extends RecyclerBindingAdapter<CurrencyData> {

    public MainRecyclerBindingAdapter() {
        super(R.layout.recycler_item, BR.currency);
    }

    @Override
    public void onBindViewHolder(RecyclerBindingAdapter.BindingHolder holder, int position) {
        ViewDataBinding dataBinding = holder.getViewDataBinding();
        if (onItemClickListener != null) {
            dataBinding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
        dataBinding.setVariable(variableId, getItem(position));
    }
}
