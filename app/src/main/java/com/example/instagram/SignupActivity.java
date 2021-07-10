package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {
    EditText etUsername;
    EditText etPassword;
    Button btnSignup;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnSignup=findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= etUsername.getText().toString();
                String password= etPassword.getText().toString();
                onButtonSignUp(username, password);
            }
        });

        String username= etUsername.getText().toString();
        String password= etPassword.getText().toString();



    }

    private void onButtonSignUp(String username, String password) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Set custom properties
        user.put("phone","650-253-0000");
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done (ParseException e){
                if (e == null) {
                    // Hooray! Let them use the app now.
                    goMainActivity();
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }



    private void goMainActivity() {
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


}
