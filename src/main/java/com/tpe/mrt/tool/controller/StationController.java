package com.tpe.mrt.tool.controller;

import com.tpe.mrt.tool.entity.Station;
import com.tpe.mrt.tool.form.StationData;
import com.tpe.mrt.tool.repository.StationRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
//        System.out.println("lineColor : " + lineColor);
        try {
            if (StringUtils.isNotBlank(lineColor)) {
                stationList = stationRepository.findByLineColor(lineColor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(stationList);
    }


    @GetMapping("/stations/getStationInfo/{stationName}")
    public ResponseEntity<Station> getStationInfo(@PathVariable String stationName) {
        Station station = new Station();
        StationData stationData = new StationData();
        try {
//            System.out.println("stationName:" + stationName);

            stationName = URLDecoder.decode(stationName, StandardCharsets.UTF_8);
            List<Station> list = stationRepository.findByStationName(stationName);

            if (CollectionUtils.isNotEmpty(list)) {
                station = list.get(0);
            }


            BeanUtils.copyProperties(station, stationData);

            String upEscalator_original = station.getUpEscalator();
            String downEscalator_original = station.getDownEscalator();
            String bothDirectionsEscalator_original = station.getBothDirectionsEscalator();
            String elevator_original = station.getElevator();
            String paidWC_original = station.getPaidWC();
            String freeWClocate_original = station.getFreeWClocate();

//            List<String> upEscalatorList = getFormedData(upEscalator_original);
//            List<String> downEscalatorList = getFormedData(downEscalator_original);
//            List<String> bothDirectionsEscalatorList = getFormedData(bothDirectionsEscalator_original);
//            List<String> elevatorList = getFormedData(elevator_original);
//            List<String> paidWCList = getFormedData(paidWC_original);
//            List<String> freeWClocateList = getFormedData(freeWClocate_original);


            station.setUpEscalator(getFormedData(upEscalator_original));
            station.setDownEscalator(getFormedData(downEscalator_original));
            station.setBothDirectionsEscalator(getFormedData(bothDirectionsEscalator_original));
            station.setElevator(getFormedData(elevator_original));
            station.setPaidWC(getFormedData(paidWC_original));
            station.setFreeWClocate(getFormedData(freeWClocate_original));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(station);


    }


    private boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    private String getFormedData(String originalData) {
        List<String> formedData = new ArrayList<>();
        try {
            if (StringUtils.isNotBlank(originalData)) {
                List<String> originalDataList = Arrays.asList(originalData.split(","));

                for (String escalator : originalDataList) {
                    String info = isNumber(escalator) ? "出口" + escalator : escalator;
                    formedData.add(info);
                }
            }
            formedData.toString().replace("[", "").replace("]", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formedData.toString().replace("[", "").replace("]", "");
    }


}
