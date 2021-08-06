package utils.db;

import java.sql.Connection;


public abstract class Models {
    private DB db = new DB();

    public Models() {
        db = new DB();
    }
    
    public abstract Object find(Integer id) throws Exception;
    public abstract Integer save() throws Exception;
    public abstract void delete() throws Exception;
    
    
    public Connection conectar(){
        return this.db.conectar();
    }
    
    public Connection startDbTest(){
        return this.db.startDbTest();
    } 
    
    
}
