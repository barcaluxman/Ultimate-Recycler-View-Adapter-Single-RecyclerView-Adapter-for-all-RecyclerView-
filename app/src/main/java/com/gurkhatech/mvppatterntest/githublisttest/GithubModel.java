package com.gurkhatech.mvppatterntest.githublisttest;

import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;
import com.gurkhatech.mvppatterntest.githublisttest.GithubContract.Model;

import java.util.List;

/**
 * Created by adventure on 3/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubModel  implements   Model{
    @Override
    public List< GithubUserDTO > getUsers ( ) {
        return null;
    }
}
