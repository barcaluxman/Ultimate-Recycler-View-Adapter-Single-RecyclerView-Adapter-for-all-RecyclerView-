package com.gurkhatech.mvppatterntest.githubUsersList.viewholders;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubView;
import com.gurkhatech.mvppatterntest.utils.lib.OmniAdapter;
import com.gurkhatech.mvppatterntest.githubUsersList.models.GithubUserData;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.gurkhatech.mvppatterntest.utils.commons.GithubListConstants.THUMBNIL_FACTOR;


public class GitHubUserListViewHolder extends OmniAdapter.OmniViewHolder {

    @Nullable
    @BindView(R.id.avatar)
    ImageView avatar;
    @Nullable
    @BindView(R.id.userName)
    TextView userName;
    @Nullable
    @BindView(R.id.profileUrl)
    TextView profileUrl;
    @Nullable
    @BindView(R.id.reposUrl)
    TextView reposUrl;


    @Inject
    RequestManager requestManager;

    public GitHubUserListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        GithubView.getDaggerComponent().injectUserViewHolder(this);

    }

    @Override
    public void bindView(OmniAdapter.IOmniModel data, OmniAdapter adapter) {
        GithubUserData userDTO = (GithubUserData) data;
        assert this.avatar != null;
        requestManager.load(userDTO.getAvatarUrl()).placeholder(R.mipmap.ic_launcher).thumbnail(THUMBNIL_FACTOR).into(this.avatar);
        assert userName != null;
        userName.setText(userDTO.getUserName());
        assert reposUrl != null;
        reposUrl.setText(userDTO.getRepoUrl());
        assert profileUrl != null;
        profileUrl.setText(userDTO.getProfileUrl());
    }

}