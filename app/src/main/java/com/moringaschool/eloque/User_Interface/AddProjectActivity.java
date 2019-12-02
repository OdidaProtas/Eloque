package com.moringaschool.eloque.User_Interface;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.adapters.FirebaseProjectListAdapter;
import com.moringaschool.eloque.adapters.FirebaseProjectViewHolder;
import com.moringaschool.eloque.interfaces.OnStartDragListener;
import com.moringaschool.eloque.models.Constants;
import com.moringaschool.eloque.models.Projects;

public class AddProjectActivity extends AppCompatActivity implements OnStartDragListener {
    private String title;
    private FloatingActionButton openNewProjectForm;
    private FirebaseUser user;
    private DatabaseReference mProjectsReference;
    private FirebaseProjectListAdapter mFirebaseAdapter;
    private FirebaseRecyclerAdapter<Projects, FirebaseProjectViewHolder> firebaseAdapter;
    private RecyclerView mRecyclerview;
    private ProgressBar loadingBar;
    private ItemTouchHelper mItemTouchHelper;

    private boolean isSaved;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);
        mRecyclerview = findViewById(R.id.myProjectsRecyclerView);
        loadingBar = findViewById(R.id.projectsInfoView);

        title = getIntent().getStringExtra("title");
        isSaved = getIntent().getBooleanExtra("isSaved", false);


        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        String category = getIntent().getStringExtra("category");



        mProjectsReference = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_ADDED_PROJECT)
                .child(category);

        if (isSaved) {
            setUpFirebaseAdapter();
        }else{
            setUpSavedAdapter();
        }

        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                    android.app.ActionBar.LayoutParams.MATCH_PARENT,
                    android.app.ActionBar.LayoutParams.WRAP_CONTENT);
            tv.setLayoutParams(lp);
            tv.setText(title);
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }


        openNewProjectForm = findViewById(R.id.floatingActionButtonOpenForm);
        openNewProjectForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ProjectsFormActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                startActivity(intent);
            }
        });
    }

    private void setUpFirebaseAdapter(){
        Toast.makeText(getApplicationContext(), "Looking for Available Projects", Toast.LENGTH_LONG).show();
        FirebaseRecyclerOptions<Projects> options = new FirebaseRecyclerOptions
                .Builder<Projects>()
                .setQuery(mProjectsReference, Projects.class)
                .build();

        mFirebaseAdapter = new FirebaseProjectListAdapter(options, mProjectsReference, this, this);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mFirebaseAdapter);
        mRecyclerview.setHasFixedSize(true);
        ItemTouchHelper.Callback callback = new SimpleItemTouchCallBack(mFirebaseAdapter);
        mItemTouchHelper =new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerview);


        };
    private void setUpSavedAdapter(){

        FirebaseRecyclerOptions<Projects> options =
                new FirebaseRecyclerOptions.Builder<Projects>()
                        .setQuery(mProjectsReference, Projects.class)
                        .build();
        firebaseAdapter = new FirebaseRecyclerAdapter<Projects, FirebaseProjectViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseProjectViewHolder firebaseTeamViewHolder, int position, @NonNull Projects projects) {
                firebaseTeamViewHolder.bindProjects(projects);
            }
            @NonNull
            @Override
            public FirebaseProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_list_items, parent, false);
                return new FirebaseProjectViewHolder(view);
            }
        };
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(firebaseAdapter);

    }

    @Override
    protected void onStart(){
        super.onStart();
        if (isSaved) {
            mFirebaseAdapter.startListening();
        }else{
            firebaseAdapter.startListening();
        }
        loadingBar.setVisibility(View.GONE);
    }
    @Override
    protected  void onStop(){
        super.onStop();
        if (mFirebaseAdapter != null){
            mFirebaseAdapter.stopListening();

        }
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {

    }
}


