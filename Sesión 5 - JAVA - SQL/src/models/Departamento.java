package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.db.DB;


public class Departamento {
    private DB db = new DB();
    
    private Integer id;
    private String nombre;
    private Integer codigo;

    public Departamento() {
    }
    
    
    
    public Departamento getById(Integer id){
        Departamento dep = null;
        
        try(Connection conn = db.conectar()){
            String query = "SELECT dep.id, dep.nombre, dep.codigo FROM departamento dep WHERE dep.id = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un registro con el id="+id);
                            
                this.id = result.getInt("id");
                this.nombre = result.getString("nombre");
                this.codigo = result.getInt("codigo");
                dep = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla departamento");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla Departamento");
        }
        
        return dep;
    }
    
    
    
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    
}
