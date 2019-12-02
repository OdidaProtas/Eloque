package com.moringaschool.eloque.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.moringaschool.eloque.R;

public class SkillsAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mSkills;

    public SkillsAdapter(Context context, String[] skills) {
        this.mContext = context;
        this.mSkills = skills;
    }

    public SkillsAdapter() {
        super();
    }

    @Override
    public int getCount() {
        return mSkills.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if(convertView== null){
            gridView = inflater.inflate(R.layout.skills_items, null);
            Button skillsButton = (Button) gridView.findViewById(R.id.skillButton);
            skillsButton.setText(mSkills[position].toLowerCase());
        }else{
            gridView = (View) convertView;
        }
        return gridView;
    }
}

