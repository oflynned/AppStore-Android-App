package com.syzible.appstore.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by ed on 18/12/2016
 */

abstract class CardAdapter<T> extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private List<T> list = Collections.emptyList();
    private OnViewHolderClick onViewHolderClick;

    CardAdapter(OnViewHolderClick onViewHolderClick) {
        super();
        this.onViewHolderClick = onViewHolderClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(createView(parent.getContext(), parent, viewType), onViewHolderClick);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        bindView(getItem(position), holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private T getItem(int position) {
        return ((list != null && position < list.size()) ? list.get(position) : null);
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    protected abstract View createView(Context context, ViewGroup viewGroup, int viewType);
    protected abstract void bindView(T item, ViewHolder viewHolder);

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnViewHolderClick onViewHolderClick;

        @SuppressLint("UseSparseArrays")
        ViewHolder(View itemView, OnViewHolderClick onViewHolderClick) {
            super(itemView);
            this.onViewHolderClick = onViewHolderClick;

            if(onViewHolderClick != null)
                itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            assert view != null;
            onViewHolderClick.onClick(view, getAdapterPosition());
        }

        View getView(int id) {
            return itemView.findViewById(id);
        }
    }
}
