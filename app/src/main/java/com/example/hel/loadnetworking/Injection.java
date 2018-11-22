package com.example.hel.loadnetworking;

import android.content.Context;

import com.example.hel.loadnetworking.data.DataSource;
import com.example.hel.loadnetworking.data.RemoteDataSource;


public class Injection {

    public  static DataSource provideDataSource(Context context){
        return new RemoteDataSource(BuildConfig.POSTS_URL);
    }
}
