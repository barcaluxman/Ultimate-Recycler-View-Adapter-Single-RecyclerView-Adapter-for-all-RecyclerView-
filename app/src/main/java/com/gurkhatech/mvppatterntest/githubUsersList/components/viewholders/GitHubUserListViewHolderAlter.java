package com.gurkhatech.mvppatterntest.githubUsersList.components.viewholders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubView;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.GithubUserListAdapter;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaDTO;
import com.gurkhatech.mvppatterntest.githubUsersList.components.adapters.gurkha.lib.GurkhaViewHolder;
import com.gurkhatech.mvppatterntest.githubUsersList.components.dtos.GithubUserDTO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gurkhatech.mvppatterntest.utils.GithubListConstants.THUMBNIL_FACTOR;


public class GitHubUserListViewHolderAlter extends GurkhaViewHolder {

    @Nullable
    @BindView(R.id.userName)
    TextView userName;
    @Nullable
    @BindView(R.id.avatar)
    ImageView avatar;
    @Nullable
    @BindView(R.id.profileUrl)
    TextView profileUrl;
    @Nullable
    @BindView(R.id.reposUrl)
    TextView reposUrl;
    @Inject
    RequestManager requestManager;

    public GitHubUserListViewHolderAlter(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        GithubView.getDaggerComponent().injectUserViewHolderAlter(this);

    }

    @Override
    public void bindView(GurkhaDTO data, GithubUserListAdapter adapter) {
        GithubUserDTO userDTO = (GithubUserDTO) data;
        assert this.avatar != null;
        requestManager.load(userDTO.getAvatarUrl()).thumbnail(THUMBNIL_FACTOR).into(this.avatar);
        assert userName != null;
        userName.setText(userDTO.getUserName());
        assert reposUrl != null;
        reposUrl.setText(userDTO.getRepoUrl());
        assert profileUrl != null;
        profileUrl.setText(userDTO.getProfileUrl());

    }

}