package com.example.chatapp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name=findViewById(R.id.textView5);
//        TextView bitsId=findViewById(R.id.textView8);
        TextView email=findViewById(R.id.textView9);
        ImageView profilePic=findViewById(R.id.imageView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        name.setText(user.getDisplayName());
        email.setText(user.getEmail());

        Picasso.get().load("https://res.cloudinary.com/alwin24/image/upload/v1638023355/avatars/user_z0lszf.jpg").into(profilePic);
        if(user.getPhotoUrl()!=null){
        Picasso.get().load(user.getPhotoUrl()).into(profilePic);
        }

        Button button1 = findViewById(R.id.profile_button);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println("Button Clicked");
                    AuthUI.getInstance().signOut(Profile.this)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(Profile.this,
                                            "You have been signed out.",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // Close activity
                                    finish();
                                }
                            });
            }

        });


    }
}