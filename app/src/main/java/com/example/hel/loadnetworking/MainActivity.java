package com.example.hel.loadnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    MainContract.Presenter presenter;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    PostAdapter adapter;
    View emptView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new  PostAdapter();
        progressBar =  findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.star();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
         this.presenter = presenter;
    }

    @Override
    public void setLoadingPosts(boolean isLoading) {
          if (isLoading){
              progressBar.setVisibility(View.VISIBLE);
          }else {
              progressBar.setVisibility(View.GONE);
          }
    }

    @Override
    public void setPosts(Post[] posts) {
        adapter.posts = posts;
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String title, String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideError() {

    }

    @Override
    public void showNoPostsMessage(boolean showMessage) {

    }
}
