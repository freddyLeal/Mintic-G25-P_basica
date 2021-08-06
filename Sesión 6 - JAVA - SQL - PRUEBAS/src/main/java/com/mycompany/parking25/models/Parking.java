package com.mycompany.parking25.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import utils.db.Models;


public class Parking extends Models{
    
    private Integer id;
    private String code;
    private Boolean isFree;
    private String carNumber;
    private Timestamp arrived;

    public Parking() {
    }

    public Parking(Integer id, String code, Boolean isFree, String carNumber, Timestamp arrived) {
        this.id = id;
        this.code = code;
        this.isFree = isFree;
        this.carNumber = carNumber;
        this.arrived = arrived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Timestamp getArrived() {
        return arrived;
    }

    public void setArrived(Timestamp arrived) {
        this.arrived = arrived;
    }

    @Override
    public Object find(Integer id) throws Exception {
        Parking par = null;
        
        try( Connection conn = super.conectar() ){
            String query = "SELECT p.id, p.code, p.is_free, p.car_number, p.arrived "
                    + "     FROM parking p WHERE p.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                par = Parking.rowMapper( result );
            }
            
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("No se puedo obtener la información del objeto id=" + id + " en la tabla parking.");
        }
        
        return par;
    }

    @Override
    public Integer save() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static Parking rowMapper(ResultSet result) throws SQLException{
        return new Parking(
                result.getInt("id"), 
                result.getString("code"), 
                result.getBoolean("is_free"), 
                result.getString("car_number"), 
                result.getTimestamp("arrived") );
    }
    
    
}
