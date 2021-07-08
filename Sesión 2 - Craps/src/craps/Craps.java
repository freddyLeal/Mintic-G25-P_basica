package craps;


/*
*   Se juega con 2 dados
*   Si en el primer tiro se saca 7 o 11, el jugador gana
*   Si en el primer tiro se saca 2, 3 o 12 el juegador pierde
*   Si no es ninguno de los anteriores se anota un punto (se guarda el valor)
*   Si no ganó ni perdió se lanza los dados hasta que:
*       - Si saca el mismo punto, el jugador gana 
*       - Si saca 7 el juegador pierde
*/
public class Craps {

    private enum ESTADO {CONTINUA, GANO, PERDIO};
    private Dado dado1 = new Dado(6);
    private Dado dado2 = new Dado(6);
    
    private final int DOS = 2;
    private final int TRES = 3;
    private final int SIETE = 7;
    private final int ONCE = 11;
    private final int DOCE = 12;
    
    
    public boolean jugar(){
        ESTADO estadoJuego;
        int miPunto = 0;
        int valorDados = lanzarDados();
        
        switch ( valorDados ) {
            case SIETE:
            case ONCE:
                estadoJuego = ESTADO.GANO;
                break;
            case DOS:
            case TRES:
            case DOCE:
                estadoJuego = ESTADO.PERDIO;
                break;
            default:
                miPunto = valorDados;
                estadoJuego = ESTADO.CONTINUA;
        }
        
        while( estadoJuego == ESTADO.CONTINUA ){
            valorDados = lanzarDados();
            if( miPunto == valorDados )
                estadoJuego = ESTADO.GANO;
            else
                if( valorDados == SIETE )
                    estadoJuego = ESTADO.PERDIO;
        }
        
        if( estadoJuego == ESTADO.GANO ){
            return true;
        } else {
            return false;
        }
        
    }
    
    
    private int lanzarDados() {
        int valor1 = dado1.lanzar();
        int valor2 = dado2.lanzar();
        return valor1 + valor2;
    }
    
    
}
