package com.moringaschool.eloque.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

import com.moringaschool.eloque.R;

public class SkillsCheckBoxAdapter extends DialogFragment {
            private Button submitSkills;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.skills_checkboxes, container, false);
        getDialog().setTitle("Add Skills");
        submitSkills = view.findViewById(R.id.subitSkills);

        submitSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectSkills();
            }
        });


        return view;
    }

    private void collectSkills(){
        dismiss();

        }
}
