package com.moringaschool.eloque.adapters;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.eloque.interfaces.ItemTouchHelperViewHolder;
import com.moringaschool.eloque.models.Constants;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.User_Interface.ProjectDetailActivity;
import com.moringaschool.eloque.models.Projects;

import org.parceler.Parcels;


import java.util.ArrayList;

public class FirebaseProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {

    View mView;
    Context mContext;
    private String category;

    public ImageView mRestaurantImageView;

    public FirebaseProjectViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindProjects(Projects project) {

        TextView projectNameTextView = mView.findViewById(R.id.projectNameTextView);
        TextView categoryTextView = mView.findViewById(R.id.category);
        TextView projectOwner = mView.findViewById(R.id.projecOwner);
        TextView minimumLevel = mView.findViewById(R.id.minimumLevel);
        TextView projectPrice = mView.findViewById(R.id.projectPrice);
        mRestaurantImageView = mView.findViewById(R.id.dragIcon);
        category = project.getCategory();


        projectNameTextView.setText(project.getProjectTitle());
        categoryTextView.setText(project.getCategory());
        projectOwner.setText(project.getPostedBy());
        minimumLevel.setText(project.getLevel());
        projectPrice.setText("Kes: " + project.getOfferInKes());

    }


    @Override
    public void onClick(View v) {
        final ArrayList<Projects> projects = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_ADDED_PROJECT).child(category);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    projects.add(snapshot.getValue(Projects.class));
                }

                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, ProjectDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("projects", Parcels.wrap(projects));
                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext, R.animator.drag_scale_on);
        set.setTarget(itemView);
        set.start();
    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,R.animator.drag_scale_off);
        set.setTarget(itemView);
        set.start();

    }
}
