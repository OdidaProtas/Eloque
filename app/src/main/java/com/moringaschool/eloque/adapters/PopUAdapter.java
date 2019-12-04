package com.moringaschool.eloque.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.androidstudy.daraja.Daraja;
import com.androidstudy.daraja.DarajaListener;
import com.androidstudy.daraja.model.AccessToken;
import com.androidstudy.daraja.model.LNMExpress;
import com.androidstudy.daraja.model.LNMResult;
import com.androidstudy.daraja.util.TransactionType;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.eloque.R;

public class PopUAdapter extends DialogFragment {
    public Button mSubmitButton;
    public EditText phoneNumberEditText;
    public TextView mDescription;
    public Activity context;
    public Daraja daraja;
    private String phoneNumber;
    private String amount;
    private EditText amountEditext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.deposit_form, container, false);

        getDialog().setTitle("Description");

        Button cancelButton = rootView.findViewById(R.id.cancelButton);
        Button submitButton = rootView.findViewById(R.id.submitButton);
        phoneNumberEditText = rootView.findViewById(R.id.phoneEditText);
        amountEditext = rootView.findViewById(R.id.AmountEditText);
        cancelButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        daraja = Daraja.with("MeJ9x2E6gAUAuwiAcbGePtSulMBdxQid", "G5nHEAfqrnEogzNL", new DarajaListener<AccessToken>() {
            @Override
            public void onResult(@NonNull AccessToken accessToken) {
                Log.i(getActivity().getClass().getSimpleName(), accessToken.getAccess_token());
            }

            @Override
            public void onError(String error) {
                Log.e(getActivity().getClass().getSimpleName(), error);

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginTransaction();
            }
        });

        return rootView;
    }

    private void beginTransaction() {


        phoneNumber = phoneNumberEditText.getText().toString().trim();
        amount = amountEditext.getText().toString().trim();

        if (TextUtils.isEmpty(phoneNumber)) {
            phoneNumberEditText.setError("Please Provide a Phone Number");
            return;
        }

        LNMExpress lnmExpress = new LNMExpress(
                "174379",
                "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919",  //https://developer.safaricom.co.ke/test_credentials
                TransactionType.CustomerPayBillOnline,
                amount,
                "254708374149",
                "174379",
                phoneNumber,
                "http://mycallbackurl.com/checkout.php",
                FirebaseAuth.getInstance().getUid(),
                "Goods Payment"
        );

        daraja.requestMPESAExpress(lnmExpress,
                new DarajaListener<LNMResult>() {
                    @Override
                    public void onResult(@NonNull LNMResult lnmResult) {
                        Log.i(getActivity().getClass().getSimpleName(), lnmResult.ResponseDescription);
                    }

                    @Override
                    public void onError(String error) {
                        Log.i(getActivity().getClass().getSimpleName(), error);
                    }
                });


    }
}
