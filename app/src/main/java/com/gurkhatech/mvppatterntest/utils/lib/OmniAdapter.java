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
        //Class < ? > c = dataIdAndViewHolder.get ( _layoutRes );
        Constructor<?> constructor = null;
        try {
            constructor = ((Class<?>) IOmniModel.get_viewHolderClass()).getConstructor(View.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(IOmniModel.get_layoutRes(), parent, false);
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
        int get_layoutRes();
        Class get_viewHolderClass();
        @LayoutRes
        int getDefaultLayoutRes();
        Class getDefaultViewHolder();
        void resetToDefault();

    }

    public static abstract class OmniModel implements IOmniModel {

        //Extend OmniModel if you do not want to extend model class from other classes like RealmObject
        //If you extend this instead of implementing IOmniModel you will have to implement only two methods
        //int getDefaultLayoutRes();
        //Class getDefaultViewHolder();

        @LayoutRes
        private int _layoutRes = 0;

        private Class _viewHolderClass;

        public int get_layoutRes() {
            return this._layoutRes == 0 ? getDefaultLayoutRes() : _layoutRes;
        }

        public Class get_viewHolderClass() {
            return _viewHolderClass == null ? getDefaultViewHolder() : _viewHolderClass;
        }

        public void set_layoutRes(int _layoutRes) {
            this._layoutRes = _layoutRes;
        }

        public void set_viewHolderClass(Class _viewHolderClass) {
            this._viewHolderClass = _viewHolderClass;
        }

        public void resetToDefault(){
            this._layoutRes = getDefaultLayoutRes();
            this._viewHolderClass = getDefaultViewHolder();
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