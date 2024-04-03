package com.example.demo.util.apilanding.impl;

import com.google.gson.stream.MalformedJsonException;
import com.example.demo.dto.apilading.ResponseDto;
import com.example.demo.service.impl.ProvinceServiceImpl;
import com.example.demo.util.APIFunctions;
import com.example.demo.util.apilanding.ApiLanding;
import com.example.demo.util.apilanding.IApiLandingExecute;
import com.example.demo.util.properties.ApiLandingProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApiLandingExecuteImpl implements IApiLandingExecute {
    Logger logger = LoggerFactory.getLogger(ApiLandingExecuteImpl.class);

    private final ApiLandingProperties apiLanding;


    private ApiLanding buildApiLanding() {
        return APIFunctions.buildAPI(ApiLanding.class, apiLanding.getUrl());
    }

    private Map<String, Object> params(String zipCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("token-susc", apiLanding.getTokenSusc());
        params.put("token-api", apiLanding.getTokenApi());
        params.put("postalcode", zipCode);
        return params;
    }

    @Override
    public ResponseDto executeValidZipCode(String zipCode) {
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = this.buildApiLanding().zipCodeProvince(this.params(zipCode));
        } catch (MalformedJsonException e) {
            logger.error(e.getMessage());
        }
        if (responseDto.getData().isEmpty()) {
            throw new RuntimeException("No existe una provincia con el codigo ingresado.");
        }
        return responseDto;
    }
}