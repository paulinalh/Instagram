package com.example.instagram.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagram.LoginActivity;
import com.example.instagram.Post;
import com.example.instagram.R;
import com.parse.ParseFile;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class ProfileFragment extends Fragment {
    Post post;
    TextView tvUser;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView ivPictureUser=view.findViewById(R.id.ivPictureUser);

        ParseFile picture= ParseUser.getCurrentUser().getParseFile("picture");
        Glide.with(getContext()).load(picture.getUrl()).transform(new RoundedCornersTransformation(500, 0)).into(ivPictureUser);

        TextView tvUser = view.findViewById(R.id.tvUser);
        String name = ParseUser.getCurrentUser().getUsername();
        tvUser.setText(name);

        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogoutButton();
            }
        });
    }

    //This method Log out from the account and goes directly to Login page
    public void onLogoutButton() {

        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null

        // navigate backwards to Login screen
        Intent i = new Intent(getContext(), LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // this makes sure the Back button won't work
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // same as above
        startActivity(i);
        getActivity().finish();
    }

}