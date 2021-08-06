package models;


import com.mycompany.parking25.models.ParkingLog;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.db.Models;


public class GeneralModel extends Models{

    
    public void startDBTesting(){
        try(Connection conn = startDbTest()){
            System.out.println("Iniciando Base de datos de prueba");
            // no hacer nada
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public List<ParkingLog> getParkingLogListByParking(Integer parkingId) throws Exception{
        List<ParkingLog> parkingLogList = new ArrayList();
        try(Connection conn = conectar()){
            String query = "SELECT id, code, car_number, arrived, departure, minutes, parking_i "
                + "     FROM parking_log  WHERE parking_i = ? order by id desc";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, parkingId);
            
            ResultSet result = statement.executeQuery();
            while( result.next() ){
                parkingLogList.add( ParkingLog.rowMapper( result ) );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return parkingLogList;
    }
    
    
    @Override
    public Object find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
