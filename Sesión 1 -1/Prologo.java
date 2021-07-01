package prologo;

import java.util.Scanner;

public class Prologo {

    public static void main(String[] args) {
        
        // salidas
        System.out.println("Hola Mundo!!!");
        System.out.println("Hola");
        System.err.println("esto es un error");
        
        
        // entradas input("la pregunta: ")
        Scanner in = new Scanner( System.in );
        System.out.print("Ingrese el nombre: ");
        String nombre = in.nextLine();
        System.out.println("Hola " + nombre);
        
        System.out.print("Ingrese su edad: ");
        int edad = in.nextInt();
        System.out.println("Su edad es " + edad);
        
        System.out.print("Número random: ");
        float numero = in.nextFloat();
        System.out.println("Un número " + numero);
        
        String otroNombre = System.console().readLine();
        System.out.println( otroNombre );
        


        // String
        String nuevoNombre = "Freddy Alejandro Leal";
        
        System.out.println( nuevoNombre.toUpperCase() );
        System.out.println( nuevoNombre.toLowerCase() );
        
        String holaMundo = "Hola Mundo";
        System.out.println( holaMundo.indexOf("e") );
        System.out.println( holaMundo.substring(2) );
        System.out.println( holaMundo.substring(2, 6) );
        
        // "Hola mundo"[::-1]
        System.out.println( holaMundo.length() );
        
        String nombreNuevo = "Freddy";
        nombreNuevo = nombreNuevo + " " +"Leal";
        System.out.println(nombreNuevo);
        
        String strInt = "12";
        int edad3 = Integer.parseInt(strInt);
        System.out.println(edad3);
        
        // CONDICIONALES
        boolean pregunta = false;
        boolean segundaPregunta = false;
        
        if( pregunta ){
            System.out.println("Primera condición");
        } else if(segundaPregunta ){
            System.out.println("Segunda condición");
        }else {
            System.out.println("No entro a ninguna, default");
        }
        
        // SWITCH
        int i = 0;
        switch( i ){
            case 0:
                System.out.println("Es cero");
                break;
            case 1:
                System.out.println("Es uno");
                break;
            case 2:
                System.out.println("Es dos");
                break;
            default:
                System.out.println("No es ni cero, ni uno ni dos");
        }
        
        

    
        // ciclo for
//        for item in range(10):
//            print(item)
        
        for( int k=0; k<10; k++ ){
            System.out.println(k);
        }
        
        String fullName = "Freddy Alejandro";
        for( char caracter : fullName.toCharArray() ){
            System.out.println( caracter );
        }
        
        // while
        int contador = 0;
        while( contador < 10 ){
            System.out.println(contador);
            contador++;
        }
        
        // do - while
        int numero2 = 25;
        do {
            System.out.println( numero2 );
            numero2++;
        } while( numero2 < 20 );
        
        
        
        
        
    }
    
}
 
