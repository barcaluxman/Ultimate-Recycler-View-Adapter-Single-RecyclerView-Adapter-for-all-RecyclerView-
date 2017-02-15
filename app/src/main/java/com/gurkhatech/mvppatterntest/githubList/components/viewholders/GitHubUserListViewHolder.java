package com.gurkhatech.mvppatterntest.githubList.components.viewholders;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GitHubUserListViewHolder extends RecyclerView.ViewHolder {
@Nullable
@BindView ( R.id.avatar )
public ImageView avatar;
@Nullable
@BindView ( R.id.userName )
public TextView userName;
@Nullable
@BindView ( R.id.profileUrl )
public TextView profileUrl;
@Nullable
@BindView ( R.id.reposUrl )
public TextView reposUrl;
    public GitHubUserListViewHolder ( View itemView ) {
        super ( itemView );
        ButterKnife.bind ( this,itemView );

    }

}