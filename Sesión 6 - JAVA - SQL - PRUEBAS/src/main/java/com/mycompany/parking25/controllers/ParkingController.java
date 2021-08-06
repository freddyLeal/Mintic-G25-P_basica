package com.mycompany.parking25.controllers;

import com.mycompany.parking25.models.ParkingLog;
import java.sql.Timestamp;
import java.util.List;
import models.GeneralModel;

public class ParkingController {
    
    
    public ParkingLog getParkingLogByParkingId(Integer id) throws Exception{
        return (ParkingLog) new ParkingLog().getLastParkingId(id);
    }
    
    public List<ParkingLog> getParkingLogList(Integer parkingId) throws Exception {
        List<ParkingLog> parkingLogList = new GeneralModel().getParkingLogListByParking(parkingId);
        return parkingLogList;
    }

    private Integer calculateMinutes(Timestamp arrived, Timestamp departure) {
        long llegada = arrived.getTime();
        long salida = departure.getTime();
        long totalTime = salida - llegada;
        totalTime = totalTime / 1000;
        return new Long(totalTime).intValue();
    }
    
}
