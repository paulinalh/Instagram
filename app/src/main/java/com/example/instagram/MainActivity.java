package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.instagram.fragments.ComposeFragment;
import com.example.instagram.fragments.PostsFragment;
import com.example.instagram.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*public static final String TAG = "MainActivity";
    public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE=42;
    private EditText etDescription;
    private Button btnCaptureImage;
    private ImageView ivPostImage;
    private Button btnSubmit;
    private File photoFile;
    private Button btnGoToFeed;
    public String photoFileName="photo.jpg";*/
    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here

        final Fragment fragment1 = new FirstFragment();
        final Fragment fragment2 = new SecondFragment();
        final Fragment fragment3 = new ThirdFragment();

        // handle navigation selection
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                                fragment = new ComposeFragment();
                                break;
                            case R.id.action_compose:
                                Toast.makeText(MainActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                                fragment = new ComposeFragment();
                                break;
                            case R.id.action_profile:
                                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                                fragment = new ComposeFragment();
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                        return true;
                    }
                });*/


        BottomNavigationView bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // Set default selection
        bottomNavigation.setSelectedItemId(R.id.action_home);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.action_home:
                    //Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    fragment = new PostsFragment();
                    break;
                case R.id.action_compose:
                    //Toast.makeText(MainActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                    fragment = new ComposeFragment();
                    break;
                case R.id.action_profile:
                    //Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    fragment = new ProfileFragment();
                    break;

            }
            fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
            return true;
        }

    };
}