package org.example;

import java.util.Random;
import java.util.Scanner;

public class SerpientesEscaleras {
    private static final int finish = 64; //Colocamos la casilla final que es la meta de los jugadores
    private static final int[] ORIGEN_CASILLAS_ESPECIALES = {7, 11, 31, 30, 40, 43, 50, 59};
    private static final int[] DESTINO_CASILLAS_ESPECIALES = {38, 37, 46, 2, 21, 60, 5, 42}; //Colocamos las casillas especiales
    //Estas pueden afectanos o ayudarnos en el juego, por ejemplo si caigo en la 7 me lleva a la 38, y así sucesivamente con todas

    public int[] posicionJugadores; //Creamos un Arrays para almacenar las posiciones de los jugadores
    private Random dado; //Creamos la simulacion del dado
    private int[] tiradasconsecutivas6; //Este arrays nos servira para almacenar las tiradas del jugador

    //Creamos el constructor
    public SerpientesEscaleras(int numeroJugadores){
        posicionJugadores = new int[numeroJugadores];//Inicializamos los Arrays y la simulacion del dado
        dado = new Random();
        tiradasconsecutivas6 = new int[numeroJugadores];

    }

    // Aca retornamos un valor aleatorio entre 1 y 6 simulando el dado
    public int LanzarDado(){
        return dado.nextInt(6)+1;
    }


    //Simulacion del Juego
    public void jugar(){
        boolean findeljuego = false; //Es el control para ver si el juego ya termino
        Scanner scanner = new Scanner(System.in);

        while(!findeljuego){ //Bucle para que funcione el juego
            for(int i = 0; i<posicionJugadores.length; i++){ // Este es el ciclo para la posicion de cada jugador
                System.out.println("Es Turno del jugador " + (i+1) + " Presiona enter para lanzar el dado");
                scanner.nextLine();

                int tiro = LanzarDado();
                System.out.println("El jugador " + (i+1) + " obtuvo en el dado " + tiro);

                //Aca verificamos si el juegador sacó tres veces seguidas 6.
                if(tiro == 6){ //Validamos si sacó 6 en el dado
                    tiradasconsecutivas6[i]++; //Si la tada es 6, aumenta uno en el contador de tiradas consecutivas
                    if(tiradasconsecutivas6[i]==3){ //Si el contador llega a 3, se cumple la condicion.
                        System.out.println("Jugador " + (i+1) + "has sacado tres veces 6 de forma consecutiva, REGRESAS AL INICIO");
                        posicionJugadores[i] = 1; //Aca regresamos al jugador a la posicion inicial
                        tiradasconsecutivas6[i] = 0; //Y reiniciamos el contador de tiradas consecutivas
                        continue; //Saltamos al siguiente jugador
                    }
                }else{
                    tiradasconsecutivas6[i]=0; //Reiniciamos el contador de tiradas consecutivas si este no llega a 3
                }

                posicionJugadores[i] += tiro; //Acá avanzamos las posicion del juegador segun el numero que nos haya proporcionado el dado

                //Aca validamos si el jugador ha llegado al final del trablero
                if(posicionJugadores[i]>=finish){
                    System.out.println("El Jugador " + (i+1) + " HA GANADO");
                    findeljuego = true;
                    break;
                }
                //Aca validamos si el jugador ha caido en una casilla especial
                for(int a = 0; a<ORIGEN_CASILLAS_ESPECIALES.length; a++){
                    if(posicionJugadores[i] == ORIGEN_CASILLAS_ESPECIALES[a]){
                        System.out.println("Jugador " + (i+1) + " Has caído en una casilla especial");
                        posicionJugadores[i] = DESTINO_CASILLAS_ESPECIALES[a];
                    }
                }
                //Si el jugador se pasa de la meta, con este metodo podemos hacerlo regresar las casillas que se pasó
                if(posicionJugadores[i] > finish){
                    int sepaso = posicionJugadores[i] - finish; //Calculamos cuanto se pasó
                    posicionJugadores[i] = finish - sepaso; //Retrocedemos al jugador
                }
                //Aca mostramos la posicion en la que se encuentra el jugador
                System.out.println("El Jugador " + (i+1) + " ha avanzado a la casilla " + posicionJugadores[i]);
            }
        }
    }
}
