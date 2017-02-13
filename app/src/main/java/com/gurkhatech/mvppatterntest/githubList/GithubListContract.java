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
interface Presenter {
    void searchUser ( String userName );

    void disconnect ( );

}

interface View {
    void setData ( List < GithubUserDTO > data );

}

interface Model {
    List < GithubUserDTO > getUserList ( String name );

    void cancelNetworkCall ( );

}

}
