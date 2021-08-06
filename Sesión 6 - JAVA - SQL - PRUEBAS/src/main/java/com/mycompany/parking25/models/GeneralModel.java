package models;

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
