package com.example.demo.util;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

    static <T> T buildAPI(Class<T> clazz, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }
}