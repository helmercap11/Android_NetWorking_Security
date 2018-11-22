package com.example.hel.loadnetworking.data;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;
import com.example.hel.loadnetworking.PostList;

public class RemoteDataSource implements DataSource {

    private final String mUrl;
    private final RequestQueue mRequestQueue;

    public RemoteDataSource(String url) {
        mUrl = url;
        mRequestQueue = new RequestQueue(new NoCache(), new BasicNetwork(new HurlStack()));
        mRequestQueue.start();
    }


    @Override
    public void getPosts(final GetPostCallback getPostsCallback) {

        GsonRequest<PostList> gsonRequest = new GsonRequest<>(mUrl, PostList.class, null, new Response.Listener<PostList>() {
            @Override
            public void onResponse(PostList list) {
                getPostsCallback.onPostLoaded(list.post);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                getPostsCallback.onPostNotAvailable(volleyError.getMessage(), volleyError.getCause());
                // + "\n" + volleyError.toString()
            }
        });

        mRequestQueue.add(gsonRequest);

    }
}
