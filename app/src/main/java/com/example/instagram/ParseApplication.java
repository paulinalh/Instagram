package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("5f8v7x9KwYMMspN9n2N7m48I9uDsjEsLx9Pvf3r9")
                .clientKey("6jjgzD1D58iGY0tEVpfLLWR3cf4BlrN0gqUd8fy2")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
