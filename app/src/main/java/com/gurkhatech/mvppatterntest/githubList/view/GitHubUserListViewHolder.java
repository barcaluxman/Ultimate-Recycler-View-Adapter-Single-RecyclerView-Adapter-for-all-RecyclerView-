package com.gurkhatech.mvppatterntest.githubList.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;

import butterknife.BindView;
import butterknife.ButterKnife;


class GitHubUserListViewHolder extends RecyclerView.ViewHolder {
@BindView ( R.id.avatar )
ImageView avatar;
@BindView ( R.id.userName )
TextView userName;
@BindView ( R.id.profileUrl )
TextView profileUrl;
@BindView ( R.id.reposUrl )
TextView reposUrl;
    GitHubUserListViewHolder ( View itemView ) {
        super ( itemView );
        ButterKnife.bind ( this,itemView );

    }
}