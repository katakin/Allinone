package com.example.allinone.ui.common.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katakin on 22/07/17.
 */

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected final List<T> dataList = new ArrayList<>();

    public void insert(int position, T data) {
        dataList.add(position, data);
        notifyItemInserted(position);
    }

    public void add(T data) {
        insert(dataList.size(), data);
    }

    public void setList(List<T> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = dataList.size();
        dataList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public T getItem(int position) {
        return dataList.get(position);
    }
}
