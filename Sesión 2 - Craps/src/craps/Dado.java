package craps;

import java.util.Random;



public final class Dado {
    
    private final Random lanzarAleatorio = new Random();
    private int valor;
    private int caras;
    
    public Dado(int caras){
        this.caras = caras;
        this.lanzar();
    }
    
    public int lanzar(){
        valor = 1 + lanzarAleatorio.nextInt(caras);
        return valor;
    }
    
    public int obtenerValor(){
        return this.valor;
    }
    
        
}
