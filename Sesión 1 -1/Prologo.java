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
        
        


        // array 
        String[] array = {"Freddy", "Alejandro", "Leal"};
//        System.out.println( array[1] );
//        for( String aux : array ){
//            System.out.println( aux );
//        }

//        String[][] letras = {
//            {"A", "B", "C"},
//            {"D", "E", "F"},
//            {"G", "H", "I"},
//        };
//        System.out.println( letras[2][1] );
        
        
        // arraylist (SON COMO LAS LISTAS EN PYTHON)
//        lista = []
//        for item in range(100):
//            lista.append(item)
        
//        ArrayList<Integer> miLista = new ArrayList<>();
//        for(int item=0; item < 100; item++){
//            miLista.add( item );
//        }
//        
//        System.out.println( miLista.size() );
//        for( int item : miLista ){
//            System.out.println( item );
//        }
        
        
        // MAP (PARACIDOS A LOS DICCIONARIOS DE PYTHON)
        
//        persona = {}
//        persona['nombre'] = 'Freddy'
//        persona['edad'] = 32

//        Map<String, Object> persona = new HashMap();
//        persona.put("nombre", "Freddy");
//        persona.put("edad", 32);
//        
//        int edad = (int) persona.get("edad");
//        System.out.println("La edad es: " + edad);


        
        // Operadores matematicos
        // + - * / %
//        int x = 5;
//        int y = (int) Math.pow(5, 2);
//        System.out.println(y);
//        int z = (int) Math.sqrt(y);
//        System.out.println(z);
        
        
        
        // operadores logicos 
        // == != < > <= >=  .equals
        // &&(and) ||(or)
        
//        if( true && true){
//            System.out.println("Es verdad");
//        } else {
//            System.out.println("Es Mentira");
//        }
        
//        if( true || false){
//            System.out.println("Es verdad");
//        } else {
//            System.out.println("Es Mentira");
//        }

        
        // Números aleatorios 
//        System.out.println( (int) (Math.random()*10 + 1) );
//        Random numeroAleatorio = new Random();
//        System.out.println( numeroAleatorio.nextInt(10) );
        
        
//        BigDecimal numeros = new BigDecimal(0);
//        System.out.println(  ((Object)numeros).getClass().getSimpleName()  );
        
        
        // exception
        int a = 3;
        int c = 0;
        
//        try{
//            int d = a / c; 
//        } catch( ArithmeticException err ){
//            System.out.println("No se puede dividir por cero.");
//        }
        
//        try{
//            int h = Integer.parseInt("asdf");
//        } catch( java.lang.NumberFormatException err){
//            System.out.println("Esto no es un número");
//        } catch( ArithmeticException err ){
//            System.out.println("No se puede dividir por cero.");
//        } finally {
//            System.out.println("Siempre se ejecuta");
//        }
//        
        
//        try{
//            // hago lo que sea
//        } catch(Exception err){
//            
//        }

        
        saludar("Freddy");
    }

    public static void saludar(String nombre){
        System.out.println("Hola " + nombre);
    }
    
    
}
 
