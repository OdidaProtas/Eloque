package com.moringaschool.eloque.User_Interface;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.moringaschool.eloque.DictionaryFragment;
import com.moringaschool.eloque.R;
import com.moringaschool.eloque.fragments.ChatFragment;
import com.moringaschool.eloque.fragments.HomeFragment;
import com.moringaschool.eloque.fragments.WalletFragment;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    final FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bottomNavigationHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        loadFragment(new HomeFragment());

        ActionBar bar = getSupportActionBar();
        if(bar!=null){
            TextView tv = new TextView(getApplicationContext());
            android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                    android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                    android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
            tv.setLayoutParams(lp);
            tv.setText(bar.getTitle());
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            bar.setCustomView(tv);
        }


    }

    ;


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.bottomNavigationHome:
                    fragment = new HomeFragment();
                    ActionBar bar = getSupportActionBar();
                    if(bar!=null){
                        TextView tv = new TextView(getApplicationContext());
                        android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                                android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                                android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
                        tv.setLayoutParams(lp);
                        tv.setText("Eloque");
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                        bar.setCustomView(tv);
                    }

                    loadFragment(fragment);
                    return true;

                case R.id.bottomNavigationDictionary:
                    fragment  = new DictionaryFragment();
                    ActionBar bar1 = getSupportActionBar();
                    if(bar1!=null){
                        TextView tv = new TextView(getApplicationContext());
                        android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                                android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                                android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
                        tv.setLayoutParams(lp);
                        tv.setText("Dictionary");
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                        bar1.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                        bar1.setCustomView(tv);
                    }
                    loadFragment(fragment);

                    return true;

                case R.id.bottomNavigationWallet:
                        fragment = new WalletFragment();
                    ActionBar bar2 = getSupportActionBar();
                    if(bar2!=null){
                        TextView tv = new TextView(getApplicationContext());
                        android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                                android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                                android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
                        tv.setLayoutParams(lp);
                        tv.setText("Wallet");
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                        bar2.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                        bar2.setCustomView(tv);
                    }

                        loadFragment(fragment);

                    return true;

                case R.id.bottomNavigationChat:
                        fragment = new ChatFragment();
                    ActionBar bar3 = getSupportActionBar();
                    if(bar3!=null){
                        TextView tv = new TextView(getApplicationContext());
                        android.app.ActionBar.LayoutParams lp = new android.app.ActionBar.LayoutParams(
                                android.app.ActionBar.LayoutParams.MATCH_PARENT, // Width of TextView
                                android.app.ActionBar.LayoutParams.WRAP_CONTENT); // Height of TextView
                        tv.setLayoutParams(lp);
                        tv.setText("Chat");
                        tv.setGravity(Gravity.CENTER);
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
                        bar3.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                        bar3.setCustomView(tv);
                    }
                        loadFragment(fragment);
                    return true;
            }
            return false;

        }
    };


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


}
