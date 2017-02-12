package com.gurkhatech.mvppatterntest.githubList;

import com.gurkhatech.mvppatterntest.githubList.model.dtos.GithubUserDTO;

import java.util.List;

/**
 * Created by adventure on 2/12/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
// This interface class basically just sums up what this group of MVP does .
public interface GithubListContract {
interface IGithubListPresenter {
    void searchUser ( );

    void disconnect ( );

}

interface IGithubListView {
    void setList ( List < GithubUserDTO > data );

    void triggerSearch ( );

    String getUserInput ( );

    void setAdapter ( );

    void setLayoutManager ( );
}

interface IGithubListModel {
    List < GithubUserDTO > getUserList ( String name );

    void cancelNetworkCall ( );

}

}
