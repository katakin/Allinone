package com.example.allinone.ui.main;

import android.arch.lifecycle.ViewModel;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.allinone.App;
import com.example.allinone.R;
import com.example.allinone.ui.common.adapter.RecyclerConfiguration;
import com.example.allinone.model.CurrencyData;
import com.example.allinone.model.Fiat;
import com.example.allinone.network.Methods;
import com.example.allinone.network.ResponseCallback;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by katakin on 20/07/17.
 */

@Singleton
public class MainViewModel extends ViewModel {

    @Inject Methods methods;

    private App context;
    private MainRecyclerBindingAdapter adapter;
    private RecyclerConfiguration recyclerConfiguration;

    @Inject
    public MainViewModel(App application) {
        context = application;
        recyclerConfiguration = new RecyclerConfiguration();
        initRecycler();
    }

    public RecyclerConfiguration getRecyclerConfiguration() {
        return recyclerConfiguration;
    }

    public void getTickers() {
        ResponseCallback<List<CurrencyData>> callback = new ResponseCallback<List<CurrencyData>>() {
            @Override
            public void onSuccess(List<CurrencyData> list) {
                adapter.setList(list);
            }

            @Override
            public void onFailure(String error) {
                showToast(error);
            }
        };
        methods.returnTickers(callback, Fiat.USD, 10);
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    private void initRecycler() {
        adapter = new MainRecyclerBindingAdapter();
        adapter.setOnItemClickListener(null);

        recyclerConfiguration.setLayoutManager(new LinearLayoutManager(context));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(context, R.drawable.recyclerview_divider));
        recyclerConfiguration.setItemDecoration(dividerItemDecoration);
        recyclerConfiguration.setAdapter(adapter);
    }
}
