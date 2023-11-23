package com.tpe.mrt.tool.repository;

import com.tpe.mrt.tool.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StationRepository extends JpaRepository<Station,Integer> , JpaSpecificationExecutor<Station> {

    List<Station> findByLineColor(String lineColor);

    List<Station> findByStationName(String stationName);

}
