package com.gurkhatech.mvppatterntest.githubList;

import com.gurkhatech.mvppatterntest.githubList.view.viewcomponents.dtos.GithubUserDTO;

import java.util.List;

/**
 * Created by adventure on 2/12/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
// This interface class basically just sums up what this group of MVP does .
interface GithubListContract {
interface Presenter {
    void searchUser ( String userName );

    void loadData ( List < GithubUserDTO > data );

    void disconnect ( );

    void enableSearch ( boolean enable );

    void alertNetworkError ( );

    void alertNoDataFound ( );

}

interface View {
    void setData ( List < GithubUserDTO > data );

    void enableSearchButton ( boolean enable );

    void showNetworkError ( );

    void showNoDataError ( );

}

interface Model {

    void makeAsyncRequest ( String name, Presenter presenter );

    void cancelNetworkCall ( );

     void injectModel();

}

}
