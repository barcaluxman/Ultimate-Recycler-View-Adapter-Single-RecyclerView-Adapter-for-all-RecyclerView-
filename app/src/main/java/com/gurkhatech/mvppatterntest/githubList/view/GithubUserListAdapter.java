package com.gurkhatech.mvppatterntest.githubList.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.constants.GithubApp;
import com.gurkhatech.mvppatterntest.githubList.model.GithubUserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
class GithubUserListAdapter extends RecyclerView.Adapter < GitHubUserListViewHolder > {
private static GithubUserListAdapter githubUserListAdapter;
private List < GithubUserDTO > data;

// if we convert it into local multiple instance of same object
//will be created
@SuppressWarnings("FieldCanBeLocal")
private GithubUserDTO temp;
private RequestManager glideRequestManager;

private GithubUserListAdapter ( ) {
    this.data = new ArrayList <> ();
    glideRequestManager = Glide.with ( GithubApp.getInstance () );
}

public static GithubUserListAdapter getInstance ( ) {
    githubUserListAdapter = ( githubUserListAdapter == null ) ? new GithubUserListAdapter () : githubUserListAdapter;
    return githubUserListAdapter;
}

void setData ( List < GithubUserDTO > data ) {
    this.data = data;
    notifyDataSetChanged ();
}

@Override
public GitHubUserListViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {
    return new GitHubUserListViewHolder ( LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.item_github_use_list, parent, false ) );
}

@Override
public void onBindViewHolder ( GitHubUserListViewHolder holder, int position ) {
    temp = data.get ( position );
    holder.userName.setText ( temp.getUserName () );
    holder.profileUrl.setText ( temp.getProfileUrl () );
    holder.reposUrl.setText ( temp.getRepoUrl () );
    glideRequestManager.load ( temp.getAvatarUrl () ).into ( holder.avatar );

}

@Override
public int getItemCount ( ) {
    return (this.data==null)?0:data.size ();
}
}
