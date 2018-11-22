package com.example.hel.loadnetworking;

import com.example.hel.loadnetworking.data.DataSource;

public class MainPresenter implements MainContract.Presenter {

    private final DataSource dataSource;
    private final  MainContract.View contractView;

    public MainPresenter(DataSource dataSource, MainContract.View contractView) {
        this.dataSource = dataSource;
        this.contractView = contractView;
    }

    @Override
    public void star() {
        loadPost();

    }

    @Override
    public void loadPost() {
        contractView.setLoadingPosts(true);
        //para pegar o metodo, gerando automaticamente o metodo
        dataSource.getPosts(new DataSource.GetPostCallback() {
            @Override
            public void onPostLoaded(Post[] posts) {
                contractView.setLoadingPosts(false);
                if(posts != null && posts.length > 0){
                        contractView.showNoPostsMessage(false);
                        contractView.setPosts(posts);

                }else{
                    contractView.showNoPostsMessage(true);
                }
            }

            @Override
            public void onPostNotAvailable(String error, Throwable cause) {

                String fullError = error;
                contractView.showError(error, fullError);
                contractView.setLoadingPosts(false);
                contractView.showNoPostsMessage(true);
                contractView.setPosts(null);

            }
        });

    }

    @Override
    public void onLoadPostImageError(String error, Exception e) {

    }
}
