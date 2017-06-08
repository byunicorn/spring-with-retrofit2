package com.springapp.common;

import org.springframework.beans.factory.annotation.Required;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class ApiServiceFactory {
    private String baseUrl;
    private Converter.Factory converterFactory;
    private Retrofit retrofit;

    @Required
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Required
    public void setConverterFactory(Converter.Factory converterFactory) {
        this.converterFactory = converterFactory;
    }

    public void init() {
        this.retrofit = new Retrofit.Builder()
                .addConverterFactory(converterFactory)
                .baseUrl(baseUrl)
                .build();
    }

    public <T> T create(Class<T> service){
        return this.retrofit.create(service);
    }
}
