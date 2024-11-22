package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.Collections;
public class Partida {
    private ArrayList<Jugador> jugadores; // Lista de jugadores
    private Baraja baraja;               // Baraja de cartas
    private boolean juegoTerminado;      // Indicador de fin de juego
    private Jugador ganador;             // Jugador con menor puntaje al final

    private static final int PUNTAJE_LIMITE = 100; // Límite para terminar el juego
    private static final int NUMERO_JUGADORES = 4; // Número de jugadores
    public Partida(ArrayList<Jugador> jugadores) {
        if (jugadores.size() != NUMERO_JUGADORES) {
            throw new IllegalArgumentException("Se necesitan exactamente " + NUMERO_JUGADORES + " jugadores para iniciar la partida.");
        }
        this.jugadores = new ArrayList<>(jugadores);
        this.baraja = new Baraja();
        this.juegoTerminado = false;
        this.ganador = null;
    }
    // Iniciar la partida


}
