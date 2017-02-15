package com.gurkhatech.mvppatterntest.githubList.components.adapters;

import android.view.ViewGroup;

import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaDTO;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaMap;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaMapDTO;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaRecyclerAdapter;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaViewHolder;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubUserListAdapter extends GurkhaRecyclerAdapter < GurkhaViewHolder > {
private GurkhaMap map;

// if we convert it into local multiple instance of same object
//will be created
private List < GurkhaDTO > data;

@SuppressWarnings("WeakerAccess")
@Inject
public GithubUserListAdapter ( List < GurkhaDTO > data,GurkhaMap map ) {
    this.data = data;
    this.map = map;
}

/**
 * We could have not asked for context and get it from application,
 * But glide handles the the image loading process and copes well with
 * activity or fragment life cycle so we are using activity's context instead
 * of fragment context
 */
@Override
public GurkhaViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {
    //return new GitHubUserListViewHolder ( LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_github_use_list, parent, false ) );

    return map.getViewHolderFromResId ( viewType, parent );
}

@Override
public void onBindViewHolder ( GurkhaViewHolder holder, int position ) {
    holder.bindView ( this.data.get ( position ) );
}

@Override
public int getItemViewType ( int position ) {
    try{return this.map.getResIdFromDTO (this.data.get ( position ));}catch (Exception ignored){}
    return 0;

}

@Override
public int getItemCount ( ) {
    return ( this.data == null ) ? 0 : data.size ();
}

@Override
public GurkhaDTO addToMap ( GurkhaMapDTO dto ) {
    this.data.add ( dto.getDto () );
    notifyDataSetChanged ();
    return map.putData ( dto );
}
}
