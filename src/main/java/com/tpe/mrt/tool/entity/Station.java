package com.tpe.mrt.tool.entity;

import javax.persistence.*;


@Entity
@Table(name="station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_name_en")
    private String stationNameEn;

    @Column(name = "line_color")
    private String lineColor;

    @Column(name = "up_escalator")
    private String upEscalator;

    @Column(name = "down_escalator")
    private String downEscalator;

    @Column(name = "both_directions_escalator")
    private String bothDirectionsEscalator;

    @Column(name = "elevator")
    private String elevator;

    @Column(name = "allow_bike")
    private Boolean allowBike;

    @Column(name = "youbike")
    private String youbike;

    @Column(name = "paid_wc")
    private String paidWC;

    @Column(name = "free_wc_locate")
    private String freeWClocate;

    @Column(name = "note")
    private String note;


    public Station() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationNameEn() {
        return stationNameEn;
    }

    public void setStationNameEn(String stationNameEn) {
        this.stationNameEn = stationNameEn;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public String getUpEscalator() {
        return upEscalator;
    }

    public void setUpEscalator(String upEscalator) {
        this.upEscalator = upEscalator;
    }

    public String getDownEscalator() {
        return downEscalator;
    }

    public void setDownEscalator(String downEscalator) {
        this.downEscalator = downEscalator;
    }

    public String getYoubike() {
        return youbike;
    }

    public void setYoubike(String youbike) {
        this.youbike = youbike;
    }

    public String getPaidWC() {
        return paidWC;
    }

    public void setPaidWC(String paidWC) {
        this.paidWC = paidWC;
    }

    public String getFreeWClocate() {
        return freeWClocate;
    }

    public void setFreeWClocate(String freeWClocate) {
        this.freeWClocate = freeWClocate;
    }

    public String getBothDirectionsEscalator() {
        return bothDirectionsEscalator;
    }

    public void setBothDirectionsEscalator(String bothDirectionsEscalator) {
        this.bothDirectionsEscalator = bothDirectionsEscalator;
    }

    public Boolean getAllowBike() {
        return allowBike;
    }

    public void setAllowBike(Boolean allowBike) {
        this.allowBike = allowBike;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
