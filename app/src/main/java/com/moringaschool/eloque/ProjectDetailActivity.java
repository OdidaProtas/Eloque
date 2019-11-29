package com.moringaschool.eloque;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.eloque.models.Projects;

import org.parceler.Parcels;

import java.util.ArrayList;

public class ProjectDetailActivity extends AppCompatActivity {
    private ArrayList<Projects> projects;
    private TextView projectLevel;
    private TextView category;
    private TextView price;
    private TextView owner;
    private TextView description;
    private TextView requiremsnts;
    private TextView email;
    private Button attemptProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        projectLevel = findViewById(R.id.detailLevel);
        category = findViewById(R.id.detailCategory);
        price = findViewById(R.id.detailProjectPrice);
        owner = findViewById(R.id.detailProjectOwner);
        description = findViewById(R.id.descriptionView);
        requiremsnts = findViewById(R.id.requirementsView);
        email =findViewById(R.id.detailProjectOwnerEmail);
        attemptProject = findViewById(R.id.attemptProject);

        projects = Parcels.unwrap(getIntent().getParcelableExtra("projects"));
        int index = Integer.parseInt(getIntent().getStringExtra("position"));
        final Projects project = projects.get(index);

        projectLevel.setText(project.getLevel());
        category.setText(project.getCategory());
        price.setText("Kes: "+project.getOfferInKes());
        owner.setText(project.getPostedBy());
        description.setText(project.getDescription());
        requiremsnts.setText(project.getRequirements());
        email.setText(project.getPostedbyEmail());

        attemptProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AttemptProjectActivity.class);
                intent.putExtra("project", Parcels.wrap(project));
                startActivity(intent);
            }
        });



        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                    android.app.ActionBar.LayoutParams.MATCH_PARENT,
                    android.app.ActionBar.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(lp);
            tv.setText(project.getProjectTitle());
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }
    }
}
