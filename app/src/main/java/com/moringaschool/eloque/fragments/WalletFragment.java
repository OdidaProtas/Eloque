package com.moringaschool.eloque;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class WalletFragment extends Fragment {
    private ImageView showWithdrawForm;
    private FragmentActivity myContext;
    private ImageView showDepositForm;




    public WalletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_wallet, container, false);
        showDepositForm = view.findViewById(R.id.depositForm);
        showWithdrawForm =view.findViewById(R.id.withdrawForm);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

//        showWithdrawForm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fm = myContext.getSupportFragmentManager();
//                PopUAdapter popUAdapterAdapter = new PopUAdapter();
//                popUAdapterAdapter.show(fm, "restaurants");
//
//            }
//        });

        showDepositForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = myContext.getSupportFragmentManager();
                PopUAdapter popUAdapterAdapter = new PopUAdapter();
                popUAdapterAdapter.show(fm, "restaurants");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}
