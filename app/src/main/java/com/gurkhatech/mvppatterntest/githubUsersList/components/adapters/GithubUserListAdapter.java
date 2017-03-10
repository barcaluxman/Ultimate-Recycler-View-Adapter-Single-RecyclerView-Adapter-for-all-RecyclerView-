package com.gurkhatech.mvppatterntest.githubUsersList.components.adapters;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaComboDTO;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaRecyclerAdapter;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaViewHolder;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubUserListAdapter extends GurkhaRecyclerAdapter {

private List < GurkhaComboDTO > data;

@SuppressWarnings("WeakerAccess")
@Inject
public GithubUserListAdapter ( List < GurkhaComboDTO > data ) {
    this.data = data;
}

@Override
public GurkhaViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {
    return getViewHolderFromResId ( viewType, parent, getViewHolderClassByLayoutID ( this.data, viewType ) );
}

@Override
public void onBindViewHolder ( GurkhaViewHolder holder, int position ) {
    holder.bindView ( this.data.get ( position ).getGurkhaDto () );
}

@Override
public int getItemViewType ( int position ) {
    return this.data.get ( position ).getResId ();
}

@Override
public int getItemCount ( ) {
    return ( this.data == null ) ? 0 : data.size ();
}

@Override
public void replaceData ( @NonNull List < GurkhaComboDTO > gurkhaMap ) {
    this.data = gurkhaMap;
    notifyDataSetChanged ();

}
}
