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
public abstract class OmniAdapter extends RecyclerView.Adapter<OmniAdapter.OmniViewHolder> {

    private List<IOmniModel> data;


    public void replaceData(@NonNull List<IOmniModel> dtoList) {
        this.data = dtoList;
        notifyItemRangeInserted(0, this.data.size() - 1);
    }

    public void addDataItem(@NonNull IOmniModel dto) {
        this.data.add(dto);
        //notify only the last added item in the recycler view
        notifyItemInserted(this.data.size() - 1);
    }

    public void addDataList(@NonNull List<IOmniModel> dtoList) {
        this.data.addAll(dtoList);
        //notifies only the new data items that are changed
        // (-1) is used because size is one more than index
        notifyItemRangeInserted(this.data.size() - 1 - dtoList.size(), this.data.size() - 1);

    }

    @Override
    public OmniViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return getViewHolderFromOmniModel(data.get(position), parent);
    }

    @Override
    public void onBindViewHolder(OmniViewHolder holder, int position) {
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
    private OmniViewHolder getViewHolderFromOmniModel(IOmniModel IOmniModel, ViewGroup parent) {
        //Class < ? > c = dataIdAndViewHolder.get ( layout );
        Constructor<?> constructor = null;
        try {
            constructor = ((Class<?>) IOmniModel.getViewHolder()).getConstructor(View.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(IOmniModel.getLayout(), parent, false);
        Object object = null;
        try {
            object = constructor != null ? constructor.newInstance(v) : null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (OmniViewHolder) object;

    }

    public interface IOmniModel {
        //Every POJO / DTO / MODEL that will be used to set data in a row (generally by data.get(position).getFieldName())
        //should implement this interface so that they can use the swiss knife recyclerView Adapter.
        @LayoutRes
        int getLayout();
        Class getViewHolder();
        void resetToDefault();
        @LayoutRes
        int getDefaultLayout();
        Class getDefaultViewHolder();

    }

    public static abstract class OmniModel implements IOmniModel {

        //Extend OmniModel if you do not want to extend model class from other classes like RealmObject
        //If you extend this instead of implementing IOmniModel you will have to implement only two methods
        //int getDefaultLayout();
        //Class getDefaultViewHolder();

        @LayoutRes
        private int layout = 0;

        private Class viewHolder;

        @Override
        public int getLayout() {
            return this.layout == 0 ? getDefaultLayout() : layout;
        }

        @Override
        public Class getViewHolder() {
            return viewHolder == null ? getDefaultViewHolder() : viewHolder;
        }

        @Override
        public void resetToDefault() {
            this.layout = getDefaultLayout();
            this.viewHolder = getDefaultViewHolder();
        }

        public void setLayout(int layout) {
            this.layout = layout;
        }

        public void setViewHolder(Class viewHolder) {
            this.viewHolder = viewHolder;
        }


    }

    public static abstract class OmniViewHolder extends RecyclerView.ViewHolder {
        //Every view holder now will be more readable as programmer must bind views and set data
        //on them in a single View holder class instead of onBindView of Adapter

        public OmniViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindView(IOmniModel data, OmniAdapter adapter);
    }

}