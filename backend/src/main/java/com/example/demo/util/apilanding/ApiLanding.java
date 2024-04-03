package com.example.demo.util.apilanding;

import com.google.gson.stream.MalformedJsonException;
import com.example.demo.dto.apilading.ResponseDto;
import com.example.demo.dto.location.LocalityResponse;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

@Headers("Accept: application/json")
public interface ApiLanding {

    @RequestLine("GET /postalcode")
    ResponseDto zipCodeProvince(@QueryMap Map<String, Object> queryMap) throws MalformedJsonException;


}