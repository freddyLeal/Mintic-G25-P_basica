
package covid25;

import models.Departamento;
import models.Municipio;



public class Covid25 {


    public static void main(String[] args) {
        
        Municipio nuevo_municipio = new Municipio();
        nuevo_municipio.setNombre("Nuevo nuevo nuevo");
        nuevo_municipio.setCodigo(0000);
        
        Departamento dep = new Departamento().getById(1);
        nuevo_municipio.setDepartamento( dep );
        
        nuevo_municipio.createMunicipio();
    }
    
    
}
