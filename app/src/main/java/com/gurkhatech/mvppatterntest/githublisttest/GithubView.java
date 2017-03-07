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

public class GithubView implements   GithubContract.View {
    @Override
    public void displayUsers ( List<GithubUserDTO> userList ) {
        
    }
    
    @Override
    public void displayNoUsers ( ) {
        
    }
}
