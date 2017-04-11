package com.gurkhatech.mvppatterntest.utils.lib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by adventure on 2/15/17.
 * erluxman@gmail.com
 * find me - @erluxman every social / developer's network
 */

@SuppressWarnings("unused")
public abstract class SwissKnifeRecyclerViewAdapter extends RecyclerView.Adapter<SwissKnifeRecyclerViewAdapter.SwissKnifeViewHolder> {

    private List<SwissKnifeData> data;

    public void replaceData(@NonNull List<SwissKnifeData> dtoList) {
        this.data = dtoList;
        notifyDataSetChanged();
    }

    public void addDataItem(@NonNull SwissKnifeData dto) {
        this.data.add(dto);
        //notify only the last added item in the recycler view
        notifyItemRangeChanged(this.data.size() - 2, this.data.size() - 1);
    }

    public void addDataList(@NonNull List<SwissKnifeData> dtoList) {
        this.data.addAll(dtoList);
        //notifies only the new data items that are changed
        // (-1) is used because size is one more than index

        notifyItemRangeChanged(this.data.size() - 1 - dtoList.size(), this.data.size() - 1);

    }

    @Override
    public SwissKnifeViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return data.get(position).getViewHolder();
    }

    @Override
    public void onBindViewHolder(SwissKnifeViewHolder holder, int position) {
        holder.bindView(data.get(position).getDto(), this);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return this.data == null ? 0 : data.size();
    }

    public interface SwissKnifeModel {
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

    public static class SwissKnifeData {
        private SwissKnifeModel dto;
        private SwissKnifeViewHolder viewHolder;

        public SwissKnifeData(SwissKnifeModel dto, SwissKnifeViewHolder viewHolder) {
            this.dto = dto;
            this.viewHolder = viewHolder;
        }

        SwissKnifeModel getDto() {
            return dto;
        }

        SwissKnifeViewHolder getViewHolder() {
            return viewHolder;
        }
    }
}
