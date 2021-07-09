package hotelcalifornia25;

import hotel.Hotel;
import java.util.Scanner;




public class HotelCalifornia25 {

    public static void main(String[] args) {
        boolean runSowtware = true;
        boolean firstTime = true;
        Scanner in = new Scanner( System.in );
        int option;
        int roomType;
        
        while( runSowtware ){
            
            if( firstTime ){
                firstTime = false;
            } else {
                System.out.println("");
                System.out.print("Presione Enter para continuar");
                new Scanner(System.in).nextLine();
                System.out.println("");
            }
            
            System.out.println("Menú");
            System.out.println("1. Ver habitaciones disponibles");
            System.out.println("2. Asignar habitación");
            System.out.println("3. Liberar habitación");
            System.out.println("4. Ordenar Comida");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            option = in.nextInt();
            
            switch( option ){
                case 1:
                    System.out.println("\nTipo de habitación:\n1. Doble de lujo\n2. Doble sencilla\n3. De lujo\n4. Sencilla");
                    System.out.print("Opción: ");
                    roomType = in.nextInt();
                    Hotel.getAvailableRooms( roomType );
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    runSowtware = false;
            }
        }
                
    }
    
}
