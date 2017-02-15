package com.gurkhatech.mvppatterntest.githubList.components.viewholders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubList.GithubListActivity;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaDTO;
import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkh.lib.GurkhaViewHolder;
import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gurkhatech.mvppatterntest.utils.GithubListConstants.THUMBNIL_FACTOR;


public class GitHubUserListViewHolder extends GurkhaViewHolder {

@Nullable
@BindView(R.id.avatar)
public ImageView avatar;
@Nullable
@BindView(R.id.userName)
public TextView userName;
@Nullable
@BindView(R.id.profileUrl)
public TextView profileUrl;
@Nullable
@BindView(R.id.reposUrl)
public TextView reposUrl;
private GithubUserDTO userDTO;


@Inject
public RequestManager requestManager;

public GitHubUserListViewHolder ( View itemView ) {
    super ( itemView );
    ButterKnife.bind ( this, itemView );
    GithubListActivity.getDaggerComponent ().injectUserViewHolder ( this );

}

@Override
public void bindView ( GurkhaDTO data ) {
    userDTO = (GithubUserDTO) data;
    assert this.avatar != null;
    requestManager.load ( userDTO.getAvatarUrl () ).thumbnail ( THUMBNIL_FACTOR ).into ( this.avatar );
    assert userName != null;
    userName.setText ( userDTO.getRepoUrl () );
    assert reposUrl != null;
    reposUrl.setText ( userDTO.getRepoUrl () );
    assert profileUrl != null;
    profileUrl.setText ( userDTO.getProfileUrl () );
}

}