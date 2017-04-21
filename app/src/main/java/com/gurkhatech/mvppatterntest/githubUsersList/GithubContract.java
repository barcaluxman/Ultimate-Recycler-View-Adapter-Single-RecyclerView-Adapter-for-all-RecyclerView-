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

interface GithubContract {
    interface View {
        void displayUsers(List<GithubUserData>  userList);
        void enableSearch(boolean enable);

        void displayNoDataError(String title, String body, @DrawableRes int imageID);

        void displayNoInternetConnection(String title, String body, @DrawableRes int imageID);

        void displayNetworkError(String title, String body, @DrawableRes int imageID);

        void displayGenericError(String title, String body, @DrawableRes int imageID);
    }

    interface Model {
        void getUsersAndPromptPresenter(String userName, Presenter presenter);

        void cancelRequests();

        //Errors Responses

        String getNetworkErrorTitle();

        String getNetworkErrorBody();

        @DrawableRes
        int getNetworkErrorImage();


        String getNoInternetErrorTitle();

        String getNoInternetErrorBody();

        @DrawableRes
        int getNoInternetErrorImage();

        String getNoDataErrorTitle();

        String getNoDataErrorBody();

        @DrawableRes
        int getNoDataErrorImage();


        String getGenericErrorTitle();

        String getGenericErrorBody();

        @DrawableRes
        int getGenericErrorImage();
    }

    interface Presenter {

        void searchUsers(String userName);

        void loadUsers(List< GithubUserData> adapterData);
        void cancelRequests();

        void enableSearch(boolean enable);

        void alertGenericError(String title, String body, @DrawableRes int imageID);

        void alertNetworkError(String title, String body, @DrawableRes int imageID);

        void alertNoInternetConnection(String title, String body, @DrawableRes int imageID);
    }
}
