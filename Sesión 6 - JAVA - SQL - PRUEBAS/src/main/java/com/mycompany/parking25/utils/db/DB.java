package utils.db;

import com.mycompany.parking25.utils.db.DBConf;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/parking";
    
    private String driverTest = "org.h2.Driver";
    private String userTest = "root";
    private String passwordTest = "jdbc:h2:mem:test;MODE=MYSQL;INIT=RUNSCRIPT FROM 'C:/Users/user/Desktop/model_parking.sql';DB_CLOSE_DELAY=-1";
    private String urlTest = "jdbc:h2:mem:test;MODE=MYSQL;";
    private String urlInitTest = "";
    
    public DB() {
        try{
            if( DBConf.testMode )
                Class.forName( driverTest );
            else
                Class.forName( driver );
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection conectar(){
        Connection conn = null;
        
        if( DBConf.testMode ){
            try{
                conn = DriverManager.getConnection(this.urlTest, this.userTest, this.passwordTest);
            } catch(Exception e){
                System.err.println("No se puede conectar a la base de datos: " + this.url);
            }
        } else {
            try{
                conn = DriverManager.getConnection(this.url, this.user, this.password);
            } catch(Exception e){
                System.err.println("No se puede conectar a la base de datos: " + this.url);
            }
        }
        return conn;
    }
     
    
    public Connection startDbTest(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.urlInitTest, this.userTest, this.passwordTest);
        } catch(Exception e){
            System.err.println("No se puede conectar a la base de datos: " + this.url);
        }
        return conn;
    }
    
    
}
