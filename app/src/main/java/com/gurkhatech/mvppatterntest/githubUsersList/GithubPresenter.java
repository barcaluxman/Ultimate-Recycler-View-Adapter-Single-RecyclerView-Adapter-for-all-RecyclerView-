package com.gurkhatech.mvppatterntest.githubUsersList;

import android.support.annotation.DrawableRes;

import com.gurkhatech.mvppatterntest.githubUsersList.models.GithubUserData;

import java.util.List;

/**
 * Created by adventure on 3/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

class GithubPresenter implements GithubContract.Presenter {

    private GithubContract.View view;
    private GithubContract.Model model;

    GithubPresenter(GithubContract.View view, GithubContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void searchUsers(String userName) {
        model.getUsersAndPromptPresenter(userName, this);
        enableSearch(false);
    }

    @Override
    public void loadUsers(List<GithubUserData> data) {
        if (data != null) {  //Do not check userList.size directly coz it may return nullPointer
            if (!data.isEmpty()) {
                view.displayUsers(data);
            } else {
                view.showDialogue(model.getNoDataErrorTitle(), model.getNoDataErrorBody(), model.getNoDataErrorImage());
            }
        } else {
            view.showDialogue(model.getGenericErrorTitle(), model.getGenericErrorBody(), model.getGenericErrorImage());
        }
        enableSearch(true);

    }


    @Override
    public void cancelRequests() {
        enableSearch(true);
        model.cancelRequests();
    }

    @Override
    public void enableSearch(boolean enable) {
        view.enableSearch(enable);
    }

    @Override
    public void alertGenericError(String title, String body, @DrawableRes int imageID) {
        view.showDialogue(title, body, imageID);
    }

    @Override
    public void alertNetworkError(String title, String body, @DrawableRes int imageID) {
        view.showDialogue(title, body, imageID);
    }

    @Override
    public void alertNoInternetConnection(String title, String body, @DrawableRes int imageID) {
        view.showDialogue(title, body, imageID);
    }


}
