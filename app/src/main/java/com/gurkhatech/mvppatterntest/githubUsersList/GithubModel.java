package com.gurkhatech.mvppatterntest.githubUsersList;

import android.content.Context;

import com.gurkhatech.mvppatterntest.R;
import com.gurkhatech.mvppatterntest.githubUsersList.components.dtos.GithubUserListDTO;
import com.gurkhatech.mvppatterntest.githubUsersList.GithubContract.Model;
import com.gurkhatech.mvppatterntest.utils.GithubAPIService;
import com.gurkhatech.mvppatterntest.utils.Util;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adventure on 3/7/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */

public class GithubModel implements Model {

    @Inject
    GithubAPIService apiService;
    private Call<GithubUserListDTO> userListCall;

    private Context context;

    GithubModel(Context context) {
        this.context = context;
        GithubView.getDaggerComponent().injectGithubModel(this);

    }

    @Override
    public void getUsersAndPromptPresenter(final String userName, final GithubContract.Presenter presenter) {
        userListCall = apiService.searchGitHubUsers(userName);
        if(Util.isInternetConnected(context)) {
            userListCall.enqueue(new Callback<GithubUserListDTO>() {
                @Override
                public void onResponse(Call<GithubUserListDTO> call, Response<GithubUserListDTO> response) {

                    try {
                        presenter.loadUsers(response.body().getList());
                    } catch (Exception ignored) {
                        Util.log(ignored.getMessage());
                        presenter.alertGenericError(getNetworkErrorTitle(), getNetworkErrorBody(), getNetworkErrorImage());
                    }

                }

                @Override
                public void onFailure(Call<GithubUserListDTO> call, Throwable t) {
                    presenter.alertNetworkError(getNetworkErrorTitle(), getNetworkErrorBody(), getNetworkErrorImage());
                }
            });
        }else {
            presenter.alertNoInternetConnection(getNoInternetErrorTitle(),getNoInternetErrorBody(),getNoInternetErrorImage());
        }
    }

    @Override
    public void cancelRequests() {
        userListCall.cancel();
    }

    @Override
    public String getNetworkErrorTitle() {
        return context.getString(R.string.network_error_title);
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
