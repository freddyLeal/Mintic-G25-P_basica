package hotelcalifornia25;

import hotel.Holder;
import hotel.Hotel;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
import memory.Write;
import view.View;




public class HotelCalifornia25 {

    public static void main(String[] args) {
        File f = new File("backup");
        if( f.exists() ){
            try {
                FileInputStream fis = new FileInputStream( f );
                ObjectInputStream ois = new ObjectInputStream( fis );
                Hotel.holder = (Holder) ois.readObject();
            } catch (Exception e) {
                System.out.println("No se pudo cargar el archivo.");
            }
            
        }

        View view = new View();
        view.show();
        
        
        

    }
    
}
