package com.moringaschool.eloque.dictionary_api.api;

import androidx.annotation.NonNull;

import com.moringaschool.eloque.models.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringaschool.eloque.models.Constants.APP_ID;

public class OxfordApiClient {
    private static  OxfordApiClient oxfordApiClient;
    private static Retrofit retrofit = null;

    public static OxfordApi getEntries() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("app_id", APP_ID)
                            .addHeader("app_key", Constants.API_KEY)
                            .build();
                    return chain.proceed(request);
                }
            }).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.OXFORD_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(OxfordApi.class);

    }


}
