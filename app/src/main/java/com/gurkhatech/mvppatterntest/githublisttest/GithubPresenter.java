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

public class GithubPresenter implements GithubContract.Presenter {
    
    private GithubContract.View view;
    private GithubContract.Model model;
    
    public GithubPresenter ( GithubContract.View view, GithubContract.Model model ) {
        
        this.view = view;
        this.model = model;
    }
    
    @Override
    public void loadUsers ( ) {
        List < GithubUserDTO > userList = model.getUsers ();
        
        if (userList != null) {
            if (userList.size () > 0) {
                
                view.displayUsers ( userList );
            }else {
                view.displayNoUsers ();
            }
        }
        else {
            view.displayNoUsers ();
        }
    }
}
