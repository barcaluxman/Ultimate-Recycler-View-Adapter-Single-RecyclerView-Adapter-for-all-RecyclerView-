package com.gurkhatech.mvppatterntest.githublisttest;

import com.gurkhatech.mvppatterntest.githubList.components.dtos.GithubUserDTO;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

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
    //given
    @Mock
    GithubContract.View mockView;
    @Mock
    GithubContract.Model mockModel;
    //when
    
    @Mock
    GithubContract.Presenter mockPresenter;
    
    @Test
    public void shouldDisplayUsersToScreen ( ) {
        //given
        GithubContract.View view = new MockView ();
        GithubContract.Model model = new GithubContract.Model () {
            @Override
            public List < GithubUserDTO > getUsers ( ) {
                return Arrays.asList ( new GithubUserDTO (), new GithubUserDTO (), new GithubUserDTO () );
            }
        };
        GithubContract.Presenter presenter = new GithubPresenter ( view, model );
        presenter.loadUsers ();
        //then
        Assert.assertEquals ( true, ( (MockView) view ).called );
        Assert.assertEquals ( true, ( (MockView) view ).enoughItems );
        Assert.assertEquals ( false, ( (MockView) view ).error );
    }
    
    
    @Test
    public void shouldHandleNoUsersFound ( ) {
        //given
        final GithubContract.View view = new MockView ();
        GithubContract.Model model = new GithubContract.Model () {
            @Override
            public List < GithubUserDTO > getUsers ( ) {
                return Collections.emptyList ();
            }
        };
        
        //when
        GithubContract.Presenter presenter = new GithubPresenter ( view, model );
        presenter.loadUsers ();
        
        //then
        Assert.assertEquals ( true, ( (MockView) ( view ) ).error );
        
    }
    
    private class MockView implements GithubContract.View {
        boolean called;
        boolean enoughItems;
        boolean error;
        
        @Override
        public void displayUsers ( List < GithubUserDTO > userList ) {
            called = true;
            if (userList.size () > 2) enoughItems = true;
        }
        
        @Override
        public void displayNoUsers ( ) {
            error = true;
        }
    }
    
}