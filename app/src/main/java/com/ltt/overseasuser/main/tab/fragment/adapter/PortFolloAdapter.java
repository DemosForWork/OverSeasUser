package com.ltt.overseasuser.main.tab.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ltt.overseasuser.R;
import com.ltt.overseasuser.base.RecyclerAdapter;

/**
 * Created by Administrator on 2018/1/25.
 */
public class PortFolloAdapter extends RecyclerAdapter {
    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfollo, parent, false));
    }

    @Override
    public int getContentItemCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public class Holder extends RecyclerHolder {

        public Holder(View itemView) {
            super(itemView);
        }
    }
}
