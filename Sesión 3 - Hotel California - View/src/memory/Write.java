package memory;

import hotel.Holder;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class Write implements Runnable {
    
    private Holder holder;
    
    public Write( Holder holder){
        this.holder = holder;
    }

    
    @Override
    public void run() {
        try{
            System.out.println("Guardando información");
            FileOutputStream fos = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream( fos );
            oos.writeObject( this.holder );
        } catch(Exception e){
            System.out.println("Error al guardar la información.");
        }
    }
    
}
