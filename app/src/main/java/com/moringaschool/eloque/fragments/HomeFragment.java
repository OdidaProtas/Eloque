package com.moringaschool.eloque.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.User_Interface.AddProjectActivity;
import com.moringaschool.eloque.User_Interface.ProfileActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
  private ImageView newAcademicProjects;
  private ImageView newResearch;
  private ImageView newArticles;
  private ImageView newWordPress;
  private ImageView newImages;

  private ImageView savedAcademic;
  private ImageView savedResearch;
  private ImageView savedArticles;
  private ImageView savedWordpress;
  private ImageView savedImages;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton addProject = view.findViewById(R.id.addProject);
        FloatingActionButton viewProfile = view.findViewById(R.id.viewProfile);
        newAcademicProjects= view.findViewById(R.id.card_AcademicProject);
        newResearch = view.findViewById(R.id.newResearch);
        newArticles= view.findViewById(R.id.newArticles);
        newWordPress = view.findViewById(R.id.newWordPress);
        newImages = view.findViewById(R.id.newImages);

        savedAcademic= view.findViewById(R.id.savedAcademic);
        savedResearch = view.findViewById(R.id.savedResearch);
        savedArticles= view.findViewById(R.id.savedArticles);
        savedWordpress = view.findViewById(R.id.savedWordPress);
        savedImages = view.findViewById(R.id.savedImages);

        newAcademicProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Projects");
                intent.putExtra("category", "Academic");
                intent.putExtra("isSaved",  false);
                startActivity(intent);
            }
        });


        newResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Research Projects");
                intent.putExtra("category", "Research");
                intent.putExtra("isSaved",  false);
                startActivity(intent);
            }
        });

        newArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Articles Projects");
                intent.putExtra("category", "Article");
                intent.putExtra("isSaved",  false);
                startActivity(intent);
            }
        });

        newWordPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "  WordPress Projects");
                intent.putExtra("category", "Wordpress");
                intent.putExtra("isSaved",  false);
                startActivity(intent);
            }
        });

        newImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Images Projects");
                intent.putExtra("category", "Image");
                intent.putExtra("isSaved",  false);
                startActivity(intent);
            }
        });

        savedAcademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", " Saved Academic Projects");
                intent.putExtra("category", "saved Academic "  + FirebaseAuth.getInstance().getUid());
                intent.putExtra("isSaved",  true);
                startActivity(intent);
            }
        });

        savedResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Saved Research Projects");
                intent.putExtra("category", "saved Research "  + FirebaseAuth.getInstance().getUid());
                intent.putExtra("isSaved",  true);
                startActivity(intent);
            }
        });

        savedArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "  Saved Articles Projects");
                intent.putExtra("category", "saved Article "  + FirebaseAuth.getInstance().getUid());
                intent.putExtra("isSaved",  true);
                startActivity(intent);
            }
        });

        savedWordpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Saved WordPress Projects");
                intent.putExtra("category", "saved Wordpress "  + FirebaseAuth.getInstance().getUid());
                intent.putExtra("isSaved",  true);
                startActivity(intent);
            }
        });

        savedImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Saved Images Projects");
                intent.putExtra("category", "saved Image "  + FirebaseAuth.getInstance().getUid());
                intent.putExtra("isSaved",  true);
                startActivity(intent);
            }
        });


        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddProjectActivity.class);
                intent.putExtra("title", "Your Projects");
                intent.putExtra("category", "Academic");
                startActivity(intent);
            }
        });
        return view;
    }

}
