package com.example.hel.loadnetworking;

public interface MainContract {

    interface View {

        void setPresenter(Presenter presenter);
        void setLoadingPosts(boolean isLoading);
        void setPosts(Post[] posts);
        void  showError(String title, String error);
        void hideError();
        void showPostsMessage(boolean showMessage);

    }

    interface Presenter{

        void star();
        void loadPost();
        void onLoadPostImageError(String error, Exception e);

    }
}
