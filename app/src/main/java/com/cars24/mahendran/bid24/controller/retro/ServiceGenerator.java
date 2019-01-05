/*
 * Copyright (c) 2016 - 2017 1Banyan Inc. - All rights reserved.
 * Unauthorized copying of this file is strictly prohibited
 * Proprietary and confidential
 */

package com.cars24.mahendran.bid24.controller.retro;

import com.cars24.mahendran.bid24.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("User-Agent", Constants.APP_NAME)
                            .header("Accept", "application/json")
                            .header("Content-Type", Constants.HTTP_REQUEST_CONTENT_TYPE)
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            })
            .addInterceptor(new HttpLoggingInterceptor().setLevel(Level.BODY));


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.PLATFORM_URL + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build());

    public static <S> S createServiceWithContentType(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);

    }
    public static <S> S createServiceResponse(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);

    }
}
