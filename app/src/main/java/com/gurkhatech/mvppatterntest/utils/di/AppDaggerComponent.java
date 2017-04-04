package com.gurkhatech.mvppatterntest.utils.di;
import com.gurkhatech.mvppatterntest.githubUsersList.components.viewholders.GitHubUserListViewHolder;
import com.gurkhatech.mvppatterntest.githubUsersList.components.viewholders.GitHubUserListViewHolderAlter;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubModel;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubView;

import dagger.Component;

/**
 * Created by adventure on 2/11/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
@SuppressWarnings("WeakerAccess")
@Component(modules = {ContextModule.class, GlideModule.class, GithubApiServiceModule.class, DTOModules.class})
public interface AppDaggerComponent {

    void injectGithubView(GithubView view);


    void injectUserViewHolder(GitHubUserListViewHolder viewHolder);

    void injectUserViewHolderAlter(GitHubUserListViewHolderAlter viewHolder);

    void injectGithubModel(GithubModel githubModel);
}
