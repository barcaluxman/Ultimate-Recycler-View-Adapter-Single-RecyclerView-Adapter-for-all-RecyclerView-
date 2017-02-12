package com.gurkhatech.mvppatterntest.githubList.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.model.GithubUserDTO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubUserListAdapter extends RecyclerView.Adapter < GitHubUserListViewHolder > {
private static GithubUserListAdapter githubUserListAdapter;
private List < GithubUserDTO > data;

// if we convert it into local multiple instance of same object
//will be created
@SuppressWarnings("FieldCanBeLocal")
private GithubUserDTO temp;
private RequestManager glideRequestManager;
@Inject
public GithubUserListAdapter ( RequestManager manager ) {
    this.data = new ArrayList <> ();
    glideRequestManager = manager;
}

/**
 * We could have not asked for context and get it from application,
 * But glide handles the the image loading process and copes well with
 * activity or fragment life cycle so we are using activity's context instead
 * of fragment context
 */
public static GithubUserListAdapter getInstance ( RequestManager manager ) {
    githubUserListAdapter = ( githubUserListAdapter == null ) ? new GithubUserListAdapter ( manager ) : githubUserListAdapter;
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
    glideRequestManager.load ( temp.getAvatarUrl () ).thumbnail ( 0.3f ).into ( holder.avatar );

}

@Override
public int getItemCount ( ) {
    return ( this.data == null ) ? 0 : data.size ();
}
}
