package com.example.whatdoyouwannawatch;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class UserHomeActivity extends AppCompatActivity {
    String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        final FirebaseUser FBuser = FirebaseAuth.getInstance().getCurrentUser();
        final String uid = FBuser.getUid();
        user_id = uid;

        // getting user from Firebase
        // 4. Use that reference to invoke the callback method.

        //If new user
        // if new user, push new user data to DB

        MainActivity.pullData(new DataCallback() {
            @Override
            public void onCallback(User user) {
                if(user== null){
                    User newUser = new User(FBuser.getEmail(), FBuser.getDisplayName(), FBuser.getUid());
                    MainActivity.pushData(newUser);
                }
            }
        },uid);

        Toast.makeText(UserHomeActivity.this, "Welcome " + FBuser.getDisplayName(), Toast.LENGTH_SHORT).show();


    }

    public void goToSettingsOnClick(View view) {
        Intent intent = new Intent(UserHomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void goToCreateJoinTheatreOnClick(View view) {
        Intent intent = new Intent(UserHomeActivity.this, CreateJoinTheatre.class);
        startActivity(intent);
    }

    public void goToFriendsListOnClick(View view) {
        Intent intent = new Intent(UserHomeActivity.this, FriendListActivity.class);
        startActivity(intent);
    }

    public void goToWatchHistoryOnClick(View view) {
        Intent intent = new Intent(UserHomeActivity.this, WatchHistoryActivity.class);
        startActivity(intent);
    }
}