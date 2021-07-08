package craps;


public class Simulation {
    
    public void simularCraps(int ciclos){
        
        int gano = 0;
        int perdio = 0;
        
        Craps craps = new Craps();
        for(int i= 0; i < ciclos; i++){
            if( craps.jugar() )
                gano++;
            else
                perdio++;
        }
        
        System.out.println("");
        System.out.println("Número de juegos: " + ciclos);
        System.out.println("El juegador gano: " + gano);
        System.out.println("El juegador perdio: " + perdio);
        
        float porcentaje = (gano*100) / ciclos;
        System.out.println("El juegador gana el : " + porcentaje + "% de las veces");
    }
    
}
