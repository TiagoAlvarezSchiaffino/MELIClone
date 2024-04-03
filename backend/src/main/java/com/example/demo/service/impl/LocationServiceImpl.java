package com.example.demo.service.impl;

import com.example.demo.dto.location.LocalityDto;
import com.example.demo.service.ILocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements ILocationService {

//    private final IApiGeorefArExecute executeApiGeorefArExecute;


    @Override
    public List<LocalityDto> findAllByIdProvince(String idProvince) {
//        LocalityResponse localityResponse = this.executeApiGeorefArExecute.executeLocation(idProvince, 1);
        return null;
    }
}