package com.tpe.mrt.tool.controller;


import com.tpe.mrt.tool.entity.Station;
import com.tpe.mrt.tool.repository.StationRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class StationDataUploadController {

    @Autowired
    private StationRepository repository;
    private static final String FILE_PATH = "D:\\02_Jean_Project\\01_Taipei_MRT_Tool\\station_data.xlsx";


    //上傳北捷資料 excel file，然後insert 進db

    @PostMapping("/stations/upload")
    private ResponseEntity upload(@RequestParam("files") MultipartFile[] uploadfiles) {
        MultipartFile multipartFile = uploadfiles[0];
        String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());

        System.out.println("fileName : " + fileName);

        try ( Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
            DataFormatter formatter = new DataFormatter();

            int rowNum = sheet.getLastRowNum() + 1;

            if (rowNum > 0) {
                for (int i = 1; i < rowNum; i++) {
                    String stationName = formatter.formatCellValue(sheet.getRow(i).getCell(0), formulaEvaluator);
                    String stationNameEn = formatter.formatCellValue(sheet.getRow(i).getCell(1), formulaEvaluator);
                    String lineColor = formatter.formatCellValue(sheet.getRow(i).getCell(2), formulaEvaluator);
                    String upEscalator = formatter.formatCellValue(sheet.getRow(i).getCell(3), formulaEvaluator);
                    String downEscalator = formatter.formatCellValue(sheet.getRow(i).getCell(4), formulaEvaluator);
                    String bothDirectionsEscalator = formatter.formatCellValue(sheet.getRow(i).getCell(5), formulaEvaluator);
                    String elevator = formatter.formatCellValue(sheet.getRow(i).getCell(6), formulaEvaluator);
                    String allowBikeStr = formatter.formatCellValue(sheet.getRow(i).getCell(7), formulaEvaluator);
                    Boolean allowBike;
                    if ("0".equals(allowBikeStr)) {
                        allowBike = false;
                    } else {
                        allowBike = true;
                    }
                    String youbike = formatter.formatCellValue(sheet.getRow(i).getCell(8), formulaEvaluator);
                    String paidWC = formatter.formatCellValue(sheet.getRow(i).getCell(9), formulaEvaluator);
                    String freeWClocate = formatter.formatCellValue(sheet.getRow(i).getCell(10), formulaEvaluator);
                    String note = formatter.formatCellValue(sheet.getRow(i).getCell(11), formulaEvaluator);

                    Station station = new Station();
                    if (StringUtils.isNotBlank(stationName)) station.setStationName(stationName);
                    if (StringUtils.isNotBlank(stationNameEn)) station.setStationNameEn(stationNameEn);
                    if (StringUtils.isNotBlank(lineColor)) station.setLineColor(lineColor);
                    if (StringUtils.isNotBlank(upEscalator)) station.setUpEscalator(upEscalator);
                    if (StringUtils.isNotBlank(downEscalator)) station.setDownEscalator(downEscalator);
                    if (StringUtils.isNotBlank(bothDirectionsEscalator))
                        station.setBothDirectionsEscalator(bothDirectionsEscalator);
                    if (StringUtils.isNotBlank(elevator)) station.setElevator(elevator);
                    station.setAllowBike(allowBike);
                    if (StringUtils.isNotBlank(youbike)) station.setYoubike(youbike);
                    if (StringUtils.isNotBlank(paidWC)) station.setPaidWC(paidWC);
                    if (StringUtils.isNotBlank(freeWClocate)) station.setFreeWClocate(freeWClocate);
                    if (StringUtils.isNotBlank(note)) station.setNote(note);
                    repository.saveAndFlush(station);
                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

//        String responseMessage = "MRT Data uploads successfully!";
        return ResponseEntity.ok().build();

    }


}
