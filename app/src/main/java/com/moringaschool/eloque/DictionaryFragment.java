package com.moringaschool.eloque;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.moringaschool.eloque.dictionary_api.api.OxfordApi;
import com.moringaschool.eloque.dictionary_api.api.OxfordApiClient;
import com.moringaschool.eloque.dictionary_api.dictionary.OxfordSearchResponse;
import com.moringaschool.eloque.dictionary_api.dictionary.Result;
import com.moringaschool.eloque.models.Constants;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class DictionaryFragment extends Fragment{
    public static OxfordApiClient apiManager;
    private TextView searchedWord;
    private OkHttpClient okHttpClient;
    private TextView pronunciation;
    private TextView example;
    private TextView type;
    private TextView entymology;


    public DictionaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_dictionary, container, false);
        final EditText searchView =  view.findViewById(R.id.dictionarySearch);
        Button submitButton = view.findViewById(R.id.submitButton);
        final TextView definitionView = view.findViewById(R.id.definition);
        type = view.findViewById(R.id.type);
        pronunciation = view.findViewById(R.id.typePhonetic);
        example = view.findViewById(R.id.example);
        entymology = view.findViewById(R.id.entymologies);


       submitButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String word = searchView.getText().toString();
               searchedWord = view.findViewById(R.id.wordView);
               OxfordApi client = OxfordApiClient.getEntries();
               Toast.makeText(getContext(), "Searching", Toast.LENGTH_LONG).show();
               searchView.onEditorAction(EditorInfo.IME_ACTION_DONE);


               Call<OxfordSearchResponse> call = client.getDictionaryEntries(Constants.APP_ID, Constants.API_KEY, word);
               call.enqueue(new Callback<OxfordSearchResponse>() {
                   @Override
                   public void onResponse(Call<OxfordSearchResponse> call, Response<OxfordSearchResponse> response) {
                       if (response.isSuccessful()){
                           OxfordSearchResponse body = response.body();
                           Result dictionaryResult = body.getResults().get(0);
                           searchedWord.setText(dictionaryResult.getWord());
                           String definition = body.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0);
                           definitionView.setText(definition);
                           String exampleResult = body.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getExamples().get(0).getText();
                           example.setText("'" + exampleResult + "'");
                           String textType = body.getResults().get(0).getLexicalEntries().get(0).getLexicalCategory().getText();
                           type.setText(textType);
                           String pronunciationText = body.getResults().get(0).getLexicalEntries().get(0).getPronunciations().get(0).getPhoneticSpelling();
                           pronunciation.setText("/"+ pronunciationText +"/");
                           String entymologyRsult = body.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getEtymologies().get(0);
                           entymology.setText(entymologyRsult);
                           Toast.makeText(getContext(), word + " definition has been found", Toast.LENGTH_LONG).show();
                       }switch (response.code()) {
                           case 403:
                               try {
                                   Toast.makeText(getContext(), response.errorBody().string(), Toast.LENGTH_LONG).show();
                               } catch (IOException e) {
                                   e.printStackTrace();
                               }
                               break;
                           case 400:
                           case 404:
                               Toast.makeText(getContext(), String.format("Invalid word %s", word), Toast.LENGTH_LONG).show();
                               break;
                       }
                   }

                   @Override
                   public void onFailure(Call<OxfordSearchResponse> call, Throwable t) {
                       Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                       Log.d("failues...........", t.getMessage());
                   }
               });
           }
       });

               return view;
       }


}
