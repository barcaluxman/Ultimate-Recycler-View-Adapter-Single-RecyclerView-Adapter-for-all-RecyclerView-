package com.gurkhatech.mvppatterntest.utils.lib;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by adventure on 2/15/17.
 * erluxman@gmail.com
 * find me - @erluxman every social / developer's network
 */

@SuppressWarnings("unused")
public abstract class SwissKnifeRecyclerViewAdapter extends RecyclerView.Adapter<SwissKnifeRecyclerViewAdapter.SwissKnifeViewHolder> {

    private List<SwissKnifeModel> data;


    public void replaceData(@NonNull List<SwissKnifeModel> dtoList) {
        this.data = dtoList;
        notifyItemRangeInserted(0, this.data.size() - 1);
    }

    public void addDataItem(@NonNull SwissKnifeModel dto) {
        this.data.add(dto);
        //notify only the last added item in the recycler view
        notifyItemInserted(this.data.size() - 1);
    }

    public void addDataList(@NonNull List<SwissKnifeModel> dtoList) {
        this.data.addAll(dtoList);
        //notifies only the new data items that are changed
        // (-1) is used because size is one more than index
        notifyItemRangeInserted(this.data.size() - 1 - dtoList.size(), this.data.size() - 1);

    }

    @Override
    public SwissKnifeViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return getViewHolderFromOmniModel(data.get(position), parent);
    }

    @Override
    public void onBindViewHolder(SwissKnifeViewHolder holder, int position) {
        holder.bindView(data.get(position), this);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.data == null ? 0 : data.size();
    }

    @SuppressWarnings("TryWithIdenticalCatches")
    private SwissKnifeViewHolder getViewHolderFromOmniModel(SwissKnifeModel swissKnifeModel, ViewGroup parent) {
        //Class < ? > c = dataIdAndViewHolder.get ( layoutRes );
        Constructor<?> cons = null;
        try {
            cons = ((Class<?>) swissKnifeModel.getViewHolderClass()).getConstructor(View.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(swissKnifeModel.getLayoutRes(), parent, false);
        Object object = null;
        try {
            object = cons != null ? cons.newInstance(v) : null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (SwissKnifeViewHolder) object;

    }

    public interface SwissKnifeModel {
        @LayoutRes
        int getLayoutRes();
        Class getViewHolderClass();
        @LayoutRes
        int getDefaultLayoutRes();
        Class getDefaultViewHolder();
        //Every POJO / DTO / MODEL that will be used to set data in a row (generally by data.get(position).getFieldName())
        //should implement this interface so that they can use the swiss knife recyclerView Adapter.

    }

    public static abstract class SwissKnifeViewHolder extends RecyclerView.ViewHolder {
        //Every view holder now will be more readable as programmer must bind views and set data
        //on them in a single View holder class instead of onBindView of Adapter

        public SwissKnifeViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindView(SwissKnifeModel data, SwissKnifeRecyclerViewAdapter adapter);
    }

}