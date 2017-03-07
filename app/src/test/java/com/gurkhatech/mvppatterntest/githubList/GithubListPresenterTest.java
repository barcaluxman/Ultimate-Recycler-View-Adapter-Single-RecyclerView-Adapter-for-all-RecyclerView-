package com.gurkhatech.mvppatterntest.githubList;

import com.gurkhatech.mvppatterntest.githubList.components.adapters.gurkha.lib.GurkhaComboDTO;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

/**
 * Created by adventure on 2/14/17.
 * erlaxmanbhattarai@gmail.com
 * itzluxman@gurkhatech.com
 * copyright reserved
 * gurkhatech.com
 */
public class GithubListPresenterTest {
    private String name = "laxman";
    private String name1 = name;
    
    /***
     @Mock List < GithubUserDTO > data;
     @Mock private GithubListContract.View view;
     private GithubListContract.Presenter presenter;
     @Mock private GithubListContract.Model model;
     
     @Before public void setUp ( ) throws Exception {
     MockitoAnnotations.initMocks ( this );
     
     presenter = new GithubListPresenter ( view, model );
         
     }
     
     @After public void tearDown ( ) throws Exception {
         
     }
     
     @Test public void enableSearch ( ) throws Exception {
     presenter.enableSearch ( false );
     verify ( view ).setEnableSearchButton ( false );
     }
     
     @Test public void alertNetworkError ( ) throws Exception {
     presenter.alertNetworkError ();
     verify ( view ).showNetworkError ();
     }
     
     @Test public void disconnect ( ) throws Exception {
     presenter.disconnect ();
     verify ( model ).cancelNetworkCall ();
     }
     
     @Test public void searchUser ( ) throws Exception {
     presenter.searchUser ( "" );
     verify ( model ).makeAsyncRequest ( "", presenter );
     }
     
     @Test public void noDataFoundError ( ) throws Exception {
     presenter.alertNoDataFound ();
     verify ( view ).showNoDataError ();
     }
     
     @Test public void disableSearch ( ) throws Exception {
     presenter.enableSearch ( false );
     verify ( view ).setEnableSearchButton ( false );
         
     }
     **/
    
    
    @Test
    public void doesPass ( ) {
        Assert.assertSame ( name, name1 );
        Assert.assertSame ( name, name1 );
    }
    
    @Test
    public void shouldPassUserListToView ( ) {
        
        //Given
        GithubListContract.View view = new MockGithubView ();
        GithubListContract.Model model = new MockModel ();
        
        
        //when
        
        
        GithubListContract.Presenter presenter = new GithubListPresenter(view,model);
        //then
        
        
    }
    
    private class MockGithubView implements GithubListContract.View {
        
        @Override
        public void setData ( List < GurkhaComboDTO > data ) {
            
        }
        
        @Override
        public void setEnableSearchButton ( boolean enable ) {
            
        }
        
        @Override
        public void showNetworkError ( ) {
            
        }
        
        @Override
        public void showNoDataError ( ) {
            
        }
    }
    
    
    private class MockModel implements GithubListContract.Model {
        @Override
        public void makeAsyncRequest ( String name, GithubListContract.Presenter presenter ) {
            
        }
        
        @Override
        public void cancelNetworkCall ( ) {
            
        }
        
        @Override
        public void injectModel ( ) {
            
        }
    }
    
}