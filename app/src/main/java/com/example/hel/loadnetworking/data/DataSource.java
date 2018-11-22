package com.example.hel.loadnetworking.data;

import com.example.hel.loadnetworking.Post;

public interface DataSource {

    interface GetPostCallback{
        void onPostLoaded(Post[] posts);
        void onPostNotAvailable(String error, Throwable cause);
    }

    void getPosts(GetPostCallback getPostCallback);


}
