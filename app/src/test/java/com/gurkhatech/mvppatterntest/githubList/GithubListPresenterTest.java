package com.gurkhatech.mvppatterntest.githubList;

import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by adventure on 2/14/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubListPresenterTest {

@Mock
List < GithubUserDTO > data;
@Mock
private GithubListContract.View view;
private GithubListContract.Presenter presenter;
@Mock
private GithubListContract.Model model;

@Before
public void setUp ( ) throws Exception {
    MockitoAnnotations.initMocks ( this );

    presenter = new GithubListPresenter ( view, model );

}

@After
public void tearDown ( ) throws Exception {

}

@Test
public void enableSearch ( ) throws Exception {
    presenter.enableSearch ( false );
    verify ( view ).enableSearchButton ( false );
}

@Test
public void alertNetworkError ( ) throws Exception {
    presenter.alertNetworkError ();
    verify ( view ).showNetworkError ();
}

@Test
public void disconnect ( ) throws Exception {
    presenter.disconnect ();
    verify ( model ).cancelNetworkCall ();
}

@Test
public void searchUser ( ) throws Exception {
    presenter.searchUser ( "" );
    verify ( model ).makeAsyncRequest ( "", presenter );
}

@Test
public void noDataFoundError ( ) throws Exception {
    presenter.alertNoDataFound ();
    verify ( view ).showNoDataError ();
}

@Test
public void disableSearch ( ) throws Exception {
    presenter.enableSearch ( false );
    verify ( view ).enableSearchButton ( false );

}

@Test
public void dataLoading ( ) throws Exception {
    presenter.loadData ( data );
    verify ( view ).setData ( data );

}

}