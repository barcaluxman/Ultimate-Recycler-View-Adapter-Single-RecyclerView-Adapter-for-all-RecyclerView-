package com.gurkhatech.mvppatterntest.githubUsersList.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adventure on 2/9/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubUserListDTO {

@NonNull
@SerializedName("items")
private List <GithubUserData> list = new ArrayList <> ();

@NonNull
public List <GithubUserData> getList ( ) {
    return this.list;
}
}
