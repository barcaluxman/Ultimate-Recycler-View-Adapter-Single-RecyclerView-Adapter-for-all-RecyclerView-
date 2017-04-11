package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by adventure on 2/15/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

@SuppressWarnings("unused")
public class GurkhaRecyclerAdapter extends RecyclerView.Adapter<GurkhaRecyclerAdapter.GurkhaViewHolder> {

    private List<GithubAdapterData> data;

    public void replaceData(@NonNull List<GithubAdapterData> dtoList) {
        this.data = dtoList;
        notifyDataSetChanged();
    }

    public void addDataItem(@NonNull GithubAdapterData dto) {
        this.data.add(dto);
        //notify only the last added item in the recycler view
        notifyItemRangeChanged(this.data.size() - 2, this.data.size() - 1);
    }

    public void addDataList(@NonNull List<GithubAdapterData> dtoList) {
        this.data.addAll(dtoList);
        //notifies only the new data items that are changed
        // (-1) is used because size is one more than index

        notifyItemRangeChanged(this.data.size() - 1 - dtoList.size(), this.data.size() - 1);

    }

    @Override
    public GurkhaViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        return data.get(position).getViewHolder();
    }

    @Override
    public void onBindViewHolder(GurkhaViewHolder holder, int position) {
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


    public  interface GurkhaDTO {
    }

    public static abstract class GurkhaViewHolder extends RecyclerView.ViewHolder {


        public GurkhaViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindView(GurkhaDTO data, GurkhaRecyclerAdapter adapter);
    }


}
