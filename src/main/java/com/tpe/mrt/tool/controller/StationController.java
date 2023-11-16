package com.tpe.mrt.tool.controller;

import com.tpe.mrt.tool.entity.Station;
import com.tpe.mrt.tool.repository.StationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StationController {


    @Autowired
    StationRepository stationRepository;

    /*
     在頁面上點選一個線，回傳這個線上的所有車站
     */
    @GetMapping("/stations/{lineColor}")
    public ResponseEntity<List<Station>> getStations(@PathVariable String lineColor) {
        List<Station> stationList = new ArrayList<>();

        try{
            System.out.println("我按了哪一條線? -->" + lineColor);

            if(StringUtils.isNotBlank(lineColor)){
                stationList = stationRepository.findByLineColor(lineColor);
            }

            stationList.stream().forEach(s -> System.out.println(s.getStationNameEn()));
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(stationList);
    }




}
