package com.gurkhatech.mvppatterntest.githubUsersList;

import android.support.annotation.DrawableRes;

import com.gurkhatech.mvppatterntest.utils.lib.GurkhaComboDTO;
import com.gurkhatech.mvppatterntest.githubUsersList.models.GithubUserData;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adventure on 3/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubPresenterTest {



    @Test
    public void shouldDisplayUsersToScreen() {
        //given
        final GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(1);

        //when
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");

        //then
        Assert.assertEquals(true, ((MockView) (view)).enoughItems);
    }

    @Test
    public void shouldHandleNoUsersFound() {
        //given
        final GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(2);

        //when
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");

        //then
        Assert.assertEquals(true, ((MockView) (view)).emptyList);

    }


    @Test
    public void shouldHandleNull() {
        //given
        final GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(3);

        //when
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");

        //then
        Assert.assertEquals(true, ((MockView) (view)).genericError);

    }
    @Test
    public void shouldDisplayNoInternet() {
        //given
        GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(4);
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");
        //then
        Assert.assertEquals(true, ((MockView) view).noInternet);
    }


    @Test
    public void shouldHandleNetworkError() {
        //given
        final GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(5);

        //when
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");

        //then
        Assert.assertEquals(true, ((MockView) (view)).networkError);

    }
    @Test
    public void shouldHandleGenericError() {
        //given
        final GithubContract.View view = new MockView();
        GithubContract.Model model = new MockModel(6);

        //when
        GithubContract.Presenter presenter = new GithubPresenter(view, model);
        presenter.searchUsers("");

        //then
        Assert.assertEquals(true, ((MockView) (view)).genericError);

    }

    private class MockModel implements GithubContract.Model {
        int flags = 0;


        /**
         * 1- perfect return list of three user dtos
         * 2- return empty list
         * 3- return null
         * 4- no internet connection
         * 5- some network error
         * 6- unknown error
         */

        MockModel(int flags) {
            this.flags = flags;
        }

        @Override
        public void getUsersAndPromptPresenter(String userName, GithubContract.Presenter presenter) {

            switch (this.flags) {
                case 1:
                    presenter.loadUsers(Arrays.asList(new GithubUserData("jfalkdjfkjadjfadkl"), new GithubUserData("fda"), new GithubUserData(""),null));
                case 2:
                    presenter.loadUsers(Collections.<GithubUserData>emptyList());
                case 3:
                    presenter.loadUsers(null);
                case 4:
                    presenter.alertNoInternetConnection("", "", 0);
                case 5:
                    presenter.alertNetworkError("", "", 0);
                case 6:
                    presenter.alertGenericError("", "", 0);

            }

        }

        @Override
        public void cancelRequests() {

        }

        @Override
        public String getNetworkErrorTitle() {
            return null;
        }

        @Override
        public String getNetworkErrorBody() {
            return null;
        }

        @Override
        public int getNetworkErrorImage() {
            return 0;
        }

        @Override
        public String getNoInternetErrorTitle() {
            return null;
        }

        @Override
        public String getNoInternetErrorBody() {
            return null;
        }

        @Override
        public int getNoInternetErrorImage() {
            return 0;
        }

        @Override
        public String getNoDataErrorTitle() {
            return null;
        }

        @Override
        public String getNoDataErrorBody() {
            return null;
        }

        @Override
        public int getNoDataErrorImage() {
            return 0;
        }

        @Override
        public String getGenericErrorTitle() {
            return null;
        }

        @Override
        public String getGenericErrorBody() {
            return null;
        }

        @Override
        public int getGenericErrorImage() {
            return 0;
        }
    }

    private class MockView implements GithubContract.View {
        boolean enoughItems = false;
        boolean genericError;
        boolean networkError;
        boolean noInternet;
        boolean emptyList;
        boolean searchEnabled;


        @Override
        public void displayUsers(List<GurkhaComboDTO> userList) {
            enoughItems = true;
        }

        @Override
        public void enableSearch(boolean enable) {
            searchEnabled = enable;
        }

        @Override
        public void displayNoDataError(String title, String body, @DrawableRes int imageID) {
            emptyList = true;
        }

        @Override
        public void displayNoInternetConnection(String title, String body, @DrawableRes int imageID) {
            noInternet = true;
        }

        @Override
        public void displayNetworkError(String title, String body, @DrawableRes int imageID) {
            networkError = true;
        }

        @Override
        public void displayGenericError(String title, String body, @DrawableRes int imageID) {
            genericError = true;
        }
    }
}