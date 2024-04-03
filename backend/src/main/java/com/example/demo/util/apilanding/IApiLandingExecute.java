package com.example.demo.util.apilanding;

import com.google.gson.stream.MalformedJsonException;
import com.example.demo.dto.apilading.ResponseDto;

public interface IApiLandingExecute {

    ResponseDto executeValidZipCode(String zipCode);


}