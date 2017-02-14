package com.gurkhatech.mvppatterntest.githubList.components.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolder;

import java.util.List;

import javax.inject.Inject;

import static com.gurkhatech.mvppatterntest.utils.GithubListConstants.THUMBNIL_FACTOR;

/**
 * Created by adventure on 2/10/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubUserListAdapter extends RecyclerView.Adapter < GitHubUserListViewHolder > {
private List < GithubUserDTO > data;

// if we convert it into local multiple instance of same object
//will be created
@SuppressWarnings("FieldCanBeLocal")
private GithubUserDTO temp;
private RequestManager glideRequestManager;

@SuppressWarnings("WeakerAccess")
@Inject
public GithubUserListAdapter ( RequestManager manager, List< GithubUserDTO > data ) {
    this.data = data;
    glideRequestManager = manager;
}

/**
 * We could have not asked for context and get it from application,
 * But glide handles the the image loading process and copes well with
 * activity or fragment life cycle so we are using activity's context instead
 * of fragment context
 */


public void setData ( List < GithubUserDTO > data ) {
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
    glideRequestManager.load ( temp.getAvatarUrl () ).thumbnail ( THUMBNIL_FACTOR ).into ( holder.avatar );

}

@Override
public int getItemCount ( ) {
    return ( this.data == null ) ? 0 : data.size ();
}
}
