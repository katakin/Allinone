package com.example.allinone.ui.common.adapter;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.example.allinone.BR;

/**
 * Created by katakin on 22/07/17.
 */

public class RecyclerConfiguration extends BaseObservable {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private RecyclerView.ItemDecoration itemDecoration;
    private RecyclerView.Adapter adapter;

    @Bindable
    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        notifyPropertyChanged(BR.layoutManager);
    }

    @Bindable
    public RecyclerView.ItemDecoration getItemDecoration() {
        return itemDecoration;
    }

    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.itemDecoration = itemDecoration;
    }

    @Bindable
    public RecyclerView.ItemAnimator getItemAnimator() {
        return itemAnimator;
    }

    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        this.itemAnimator = itemAnimator;
        notifyPropertyChanged(BR.itemAnimator);
    }

    @Bindable
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @BindingAdapter("app:configuration")
    public static void configureRecyclerView(RecyclerView recyclerView, RecyclerConfiguration configuration) {
        RecyclerView.LayoutManager layoutManager = configuration.getLayoutManager();
        if (layoutManager != null) recyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration = configuration.getItemDecoration();
        if (itemDecoration != null) recyclerView.addItemDecoration(itemDecoration);
        RecyclerView.ItemAnimator itemAnimator = configuration.getItemAnimator();
        if (itemAnimator != null) recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(configuration.getAdapter());
    }
}
