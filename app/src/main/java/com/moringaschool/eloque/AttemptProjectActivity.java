package com.moringaschool.eloque;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.eloque.models.Projects;

import org.parceler.Parcels;

public class AttemptProjectActivity extends AppCompatActivity {
        private Uri filePath;

        private ImageButton btnChoose;
        private Button  btnUpload;
        private TextView fileName;
        private ProgressBar uploadProgress;
        private TextView info;

        private String ownerUid;

        private final int PICK_FILE_REQUEST = 234;
        private int DOCX = 1;
        private FirebaseDatabase mStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attempt_project);
        Projects project = Parcels.unwrap(getIntent().getParcelableExtra("project"));

        btnChoose = findViewById(R.id.btnChoose);
        btnUpload = findViewById(R.id.btnUPload);
        uploadProgress = findViewById(R.id.uploadProgressView);
        info = findViewById(R.id.infoInfo);
//        fileName = findViewById(R.id.fileName);

        ownerUid = project.getPushId();

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
                uploadProgress.setVisibility(View.VISIBLE);
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

    protected void chooseFile(){
        Intent intent = new Intent();
        intent.setType("docx/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select DOCX"), DOCX);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == DOCX){
           Uri uri = data.getData();
           String uriText = uri.toString();
           uploadProgress.setVisibility(View.GONE);
           info.setText("Selected file \n"+uriText);
           info.setBackgroundResource(R.drawable.card_background);
           info.setTextColor(Color.parseColor("#2E8B57"));
            Toast.makeText(getApplicationContext(), "File selected, Upload now", Toast.LENGTH_LONG).show();

        }

    }

}
