package com.tpe.mrt.tool.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.http.HttpResponse;

@Controller
public class StationController {


    /*
     在頁面上點選一個線，回傳這個線上的所有車站
     */
    @GetMapping("/stations/{line}")
    public ResponseEntity getStations(@PathVariable String line) {
        System.out.println("我按了哪一條線? -->" + line);
        return ResponseEntity.ok().build();
    }


}
