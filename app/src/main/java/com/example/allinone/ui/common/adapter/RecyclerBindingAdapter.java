package com.example.allinone.ui.common.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by katakin on 21/07/17.
 */

public class RecyclerBindingAdapter<T> extends BaseRecyclerAdapter<T, RecyclerBindingAdapter.BindingHolder> {

    protected int layoutId;
    protected int variableId;
    protected OnItemClickListener onItemClickListener;

    public RecyclerBindingAdapter(int layoutId, int variableId) {
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerBindingAdapter.BindingHolder holder, int position) {
        ViewDataBinding dataBinding = holder.getViewDataBinding();
        if (onItemClickListener != null) {
            dataBinding.getRoot().setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
        dataBinding.setVariable(variableId, getItem(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected class BindingHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BindingHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.binding = dataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return binding;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
