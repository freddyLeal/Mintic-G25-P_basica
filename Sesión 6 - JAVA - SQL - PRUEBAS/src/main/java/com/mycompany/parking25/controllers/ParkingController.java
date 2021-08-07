package com.mycompany.parking25.controllers;

import com.mycompany.parking25.models.Parking;
import com.mycompany.parking25.models.ParkingLog;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public List<Parking> getFreeParkingList() {
        List<Parking> parkingList = new GeneralModel().getParkingList(true);
        return parkingList;
    }

    public List<Parking> getNotFreeParkingList() {
        List<Parking> parkingList = new GeneralModel().getParkingList(false);
        return parkingList;
    }
    
    public List<Parking> getAllParkingList(){
        List<Parking> parkingList = new GeneralModel().getParkingList(null);
        return parkingList;
    }

    public void setArrivedToParking(int id, String placa) {
        Parking par = null;
        try {
            par = (Parking) new Parking().find( id );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        par.setIsFree(false);
        par.setArrived( new Timestamp( new Date().getTime() ) );
        par.setCarNumber(placa);
        try {
            par.save();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setDepartureToParking(int id) throws Exception {
        Parking par = (Parking) new Parking().find(id);
        
        ParkingLog log = new ParkingLog();
        log.setCode( par.getCode() );
        log.setCarNumber( par.getCarNumber() );
        log.setArrived( par.getArrived() );
        log.setDeparture( new Timestamp(new Date().getTime()) );
        log.setMinutes( calculateMinutes( par.getArrived(), log.getDeparture() ) );
        log.setParkingId( par.getId() );
        log.save();
        
        par.setIsFree(true);
        par.setCarNumber(null);
        par.setArrived( null );
        par.save();
    }
    
}
