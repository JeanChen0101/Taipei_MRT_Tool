package com.tpe.mrt.tool.form;

import com.tpe.mrt.tool.entity.Station;

import java.util.List;

public class StationData extends Station {
    List<String> upEscalatorList;

    List<String> downEscalatorList;

    List<String> bothDirectionsEscalatorList;

    List<String> elevatorList;

    List<String> paidWCList;

    List<String> freeWClocateList;


    public List<String> getUpEscalatorList() {
        return upEscalatorList;
    }

    public void setUpEscalatorList(List<String> upEscalatorList) {
        this.upEscalatorList = upEscalatorList;
    }

    public List<String> getDownEscalatorList() {
        return downEscalatorList;
    }

    public void setDownEscalatorList(List<String> downEscalatorList) {
        this.downEscalatorList = downEscalatorList;
    }

    public List<String> getBothDirectionsEscalatorList() {
        return bothDirectionsEscalatorList;
    }

    public void setBothDirectionsEscalatorList(List<String> bothDirectionsEscalatorList) {
        this.bothDirectionsEscalatorList = bothDirectionsEscalatorList;
    }

    public List<String> getElevatorList() {
        return elevatorList;
    }

    public void setElevatorList(List<String> elevatorList) {
        this.elevatorList = elevatorList;
    }

    public List<String> getPaidWCList() {
        return paidWCList;
    }

    public void setPaidWCList(List<String> paidWCList) {
        this.paidWCList = paidWCList;
    }

    public List<String> getFreeWClocateList() {
        return freeWClocateList;
    }

    public void setFreeWClocateList(List<String> freeWClocateList) {
        this.freeWClocateList = freeWClocateList;
    }
}
