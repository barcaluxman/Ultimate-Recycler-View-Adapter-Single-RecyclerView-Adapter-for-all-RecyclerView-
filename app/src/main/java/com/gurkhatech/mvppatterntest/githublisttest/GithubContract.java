package com.gurkhatech.mvppatterntest.githublisttest;

import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;

import java.util.List;

/**
 * Created by adventure on 3/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

interface GithubContract {
    interface View{
        void displayUsers ( List<GithubUserDTO> userList);
        void displayNoUsers();
    }
    interface Model{
        List<GithubUserDTO> getUsers();
    }
    interface  Presenter{
    
        void loadUsers ( );
    }
}
