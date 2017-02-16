package com.gurkhatech.mvppatterntest.utils.di;

import com.gurkhatech.mvppatterntest.githubList.GithubListActivity;
import com.gurkhatech.mvppatterntest.githubList.GithubListModel;
import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolder;
import com.gurkhatech.mvppatterntest.githubList.components.viewholders.GitHubUserListViewHolderAlter;

import dagger.Component;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@SuppressWarnings("WeakerAccess")
@Component(modules = { ContextModule.class, GlideModule.class,GithubApiServiceModule.class,DTOModules.class })
public interface AppDaggerComponent {
void injectGithubListActivity ( GithubListActivity activity );
void injectGithubListModel( GithubListModel model);
void injectUserViewHolder( GitHubUserListViewHolder viewHolder);
void injectUserViewHolderAlter( GitHubUserListViewHolderAlter viewHolder);
}
