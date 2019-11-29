package com.moringaschool.eloque;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    private FloatingActionButton takePicture;
    private ImageView imageView;
    private GridView gridView;
    private String[] skills = {"Word", "Publisher", "Literature", "Photoshop", "Design", "SpreadSheets", "Research", "WordPress", "Reviews"};

    private TextView mName;
    private TextView mEmail;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Button signOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        takePicture = findViewById(R.id.takePicture);

        gridView = (GridView) findViewById(R.id.skillsGridView);
        gridView.setAdapter(new SkillsAdapter(this, skills));
        mName = findViewById(R.id.textViewName);
        mEmail = findViewById(R.id.textViewEmail);


        mAuth = FirebaseAuth.getInstance();

        mName.setText(mAuth.getCurrentUser().getDisplayName());
        mEmail.setText(mAuth.getCurrentUser().getEmail());

        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                    android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                    android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
            tv.setLayoutParams(lp);
            tv.setText("Your Profile");
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }

        signOut = findViewById(R.id.action_logout);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(ProfileActivity.this, LOginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        }


}
