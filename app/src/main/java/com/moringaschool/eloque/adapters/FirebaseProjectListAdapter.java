package com.moringaschool.eloque.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.interfaces.ItemTouchHelperAdapter;
import com.moringaschool.eloque.interfaces.OnStartDragListener;
import com.moringaschool.eloque.models.Projects;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseProjectListAdapter extends FirebaseRecyclerAdapter<Projects, FirebaseProjectViewHolder> implements ItemTouchHelperAdapter {


    private Query mRef;
//    private AddProjectActivity mOnStartDragListener;
    private Context mContext;
    private OnStartDragListener mOnStartDragListener;
    private ArrayList<Projects> mProjects = new ArrayList<>();
    private ChildEventListener mChildEventLIstener;




    public FirebaseProjectListAdapter(@NonNull FirebaseRecyclerOptions<Projects> options, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventLIstener = mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                mProjects.add(dataSnapshot.getValue(Projects.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onBindViewHolder(@NonNull final FirebaseProjectViewHolder firebaseProjectViewHolder, int i, @NonNull Projects projects) {
        firebaseProjectViewHolder.bindProjects(projects);
        firebaseProjectViewHolder.mRestaurantImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(firebaseProjectViewHolder);
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public FirebaseProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_items_drag, parent, false);
        return  new FirebaseProjectViewHolder(view);
    }

    @Override
    public boolean onItemMove(int itemPosition, int toPosition) {
        Collections.swap(mProjects, itemPosition, toPosition);
        notifyItemMoved(itemPosition, toPosition);
        setIndexInFirebase();
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
             mProjects.remove(position);
            getRef(position).removeValue();

    }

    private  void setIndexInFirebase(){
        for (Projects project: mProjects){
            int index = mProjects.indexOf(project);
            DatabaseReference ref = getRef(index);
            project.setIndex(Integer.toString(index));
            ref.setValue(project);
        }
    }
    @Override
    public void stopListening(){
        super.stopListening();
        mRef.removeEventListener(mChildEventLIstener);
    }

}
