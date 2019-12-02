package com.moringaschool.eloque.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.interfaces.ItemTouchHelperAdapter;
import com.moringaschool.eloque.interfaces.OnStartDragListener;
import com.moringaschool.eloque.models.Projects;

public class FirebaseProjectListAdapter extends FirebaseRecyclerAdapter<Projects, FirebaseProjectViewHolder> implements ItemTouchHelperAdapter {


    private DatabaseReference mRef;
//    private AddProjectActivity mOnStartDragListener;
    private Context mContext;
    private OnStartDragListener mOnStartDragListener;




    public FirebaseProjectListAdapter(@NonNull FirebaseRecyclerOptions<Projects> options, DatabaseReference ref, OnStartDragListener onStartDragListener, Context context) {
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
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
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
            getRef(position).removeValue();
    }
}
