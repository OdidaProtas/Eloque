package com.moringaschool.eloque.User_Interface;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.eloque.models.Constants;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.models.Projects;

import java.util.ArrayList;
import java.util.List;

public class ProjectsFormActivity extends AppCompatActivity {
    private Button submitButton;
    private TextInputEditText projectTitleEditText;
    private RadioGroup categoryRadioGroup;
    private RadioButton categoryRadioButton;
    private TextInputEditText descriptionEditText;
    private RadioGroup levelRadioGroup;
    private RadioButton levelRadioButton;
    private TextInputEditText requirementsEditText;
    private TextInputEditText offerInKesEditText;


    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private DatabaseReference mNewProjectReference;
    private FirebaseDatabase mDatabase;

    private String[] colors = {"#FF6633", "#FFB399", "#FF33FF", "#FFFF99", "#00B3E6", "#E6B333", "#3366E6", "#999966", "#99FF99", "#B34D4D", "#80B300", "#809900", "#E6B3B3", "#6680B3", "#66991A"};
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_form);

        submitButton = findViewById(R.id.submitProject);
        projectTitleEditText = findViewById(R.id.projectNameEditText);
        categoryRadioGroup = findViewById(R.id.categoryRadioGroup);
        descriptionEditText= findViewById(R.id.descriptionEditText);
        levelRadioGroup = findViewById(R.id.levelRadioGroup);
        requirementsEditText = findViewById(R.id.requirementsEditText);
        offerInKesEditText =  findViewById(R.id.offerInKesEditText);


        mAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase = FirebaseDatabase.getInstance();
        mNewProjectReference = mDatabase.getReference();



        final List<String> allEntries = new ArrayList<String>();


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedCategory = categoryRadioGroup.getCheckedRadioButtonId();
                categoryRadioButton = findViewById(selectedCategory);
                int selectedLevel = levelRadioGroup.getCheckedRadioButtonId();
                levelRadioButton = findViewById(selectedLevel);

                String projectTitle = projectTitleEditText.getText().toString();
                String category = categoryRadioButton.getText().toString();
                String description = descriptionEditText.getText().toString();
                String level = levelRadioButton.getText().toString();
                String requirements = requirementsEditText.getText().toString();
                String offerInKes = offerInKesEditText.getText().toString();


                if (projectTitle == ""){
                    projectTitleEditText.setError("Title is required");
                }else if (description == "") {
                    descriptionEditText.setError("Description is Required");
                }else if (requirements == ""){
                    requirementsEditText.setError("Requirements are required");
                }else if (offerInKes == ""){
                    offerInKesEditText.setError("You have to make an offer");
                } else if (offerInKes != ""){
                    try {
                        Integer.parseInt(offerInKes);

                        for (int i = 0;  i< colors.length; i++){
                                int index = (int)(Math.random() * 10);
                                color = colors[index];
                        }


                        Projects newProject = new Projects(projectTitle, category, description, level, requirements,offerInKes, user.getDisplayName(), user.getEmail());
                        String uid = user.getUid();

                        mNewProjectReference = mDatabase.getReference(Constants.FIREBASE_CHILD_ADDED_PROJECT).child(category);

                        DatabaseReference pushRef = mNewProjectReference.push();

                        String pushId = pushRef.getKey();
                        newProject.setPushId(pushId);
                        newProject.setColor(color);
                        pushRef.setValue(newProject);

                        Toast.makeText(getApplicationContext(), "Project Saved", Toast.LENGTH_LONG).show();

                        Intent intent =  new Intent(getApplicationContext(), AddProjectActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("category", category);
                        startActivity(intent);

                    }catch (NumberFormatException e) {
                        offerInKesEditText.setError(offerInKes + " is not a valid number");
                    }

                }

            }
        });


        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                    android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                    android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
            tv.setLayoutParams(lp);
            tv.setText("New Project");
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }




    }
}
