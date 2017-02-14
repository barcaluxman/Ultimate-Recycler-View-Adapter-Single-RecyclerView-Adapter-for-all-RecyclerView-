package com.gurkhatech.mvppatterntest.githubList.components.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gurkhatech.mvppatterntest.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GitHubUserListViewHolder extends RecyclerView.ViewHolder {
@BindView ( R.id.avatar )
public ImageView avatar;
@BindView ( R.id.userName )
public TextView userName;
@BindView ( R.id.profileUrl )
public TextView profileUrl;
@BindView ( R.id.reposUrl )
public TextView reposUrl;
    public GitHubUserListViewHolder ( View itemView ) {
        super ( itemView );
        ButterKnife.bind ( this,itemView );

    }

}