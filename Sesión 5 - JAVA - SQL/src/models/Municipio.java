package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.db.DB;


public class Municipio {
    private DB db = new DB();
    
    private Integer id;
    private String nombre;
    private Integer codigo;
    private Departamento departamento;

    
    public Municipio() {
    }
    

    public Municipio getById(Integer id){
        Municipio municipio = null;
        
        try(Connection conn = db.conectar()){
            String query = "SELECT m.id, m.nombre, m.codigo, m.departamento_id "
                    + "     FROM municipio m "
                    + "     LEFT JOIN departamento dep on dep.id = m.departamento_id"
                    + "     WHERE m.id = ?";
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
                this.departamento = new Departamento().getById( result.getInt("departamento_id") );
                municipio = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro con el id="+id+" en la tabla municipio");
            
        } catch(Exception e){
            System.out.println("No se puede encontrar el elemento id=" + id + " de la tabla municipio");
        }
        
        return municipio;
    }
    
    
    
    public Integer createMunicipio(){
        Integer id = null;
        try(Connection conn = db.conectar()){
            String query = "INSERT INTO municipio (departamento_id, nombre, codigo) "
                    + "     VALUES (?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            if(this.departamento == null)
                throw new Exception("El departamento es obligatorio para crear un municipio.");
            
            statement.setInt(1, this.departamento.getId() );
            statement.setString(2, this.nombre);
            statement.setInt(3, this.codigo);
            int rows = statement.executeUpdate();
            
            if( rows > 0){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if( generatedKeys.next() )
                    id = generatedKeys.getInt(1);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.err.println("No se puedo crear el registro en la tabla municio.");
        }
        
        return id;
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

    /**
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    
    
    
    
}
