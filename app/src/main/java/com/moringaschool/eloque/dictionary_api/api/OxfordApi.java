package com.moringaschool.eloque.dictionary_api.api;

import com.moringaschool.eloque.dictionary_api.dictionary.OxfordSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OxfordApi {

    @GET("entries/en/{word}")
    Call<OxfordSearchResponse> getDictionaryEntries(
            @Header("app_id") String id,
            @Header("app_key") String key,
            @Query("word") String word);
}
