package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Partida {
    private List<Jugador> jugadores;
    private int rondasJugadas;
    private Baraja baraja;

    public Partida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.rondasJugadas = 0;
        this.baraja = new Baraja();
    }

    public void iniciarPartida() {
        repartirCartas();
        rondasJugadas = 0;

        while (!verificarGanador()) {  // mientras no hay un ganador
            jugarRonda();  // juega una ronda
            rondasJugadas++;  // aumento el número de rondas jugadas
        }
        // muestro ganador por ronda
        Jugador ganador = finalizarPartida();
        System.out.println("La partida termino. El ganador es: " + ganador.getNombre());
    }

    // reparto las cartas a los jugadores
    private void repartirCartas() {
        baraja.barajar();
        List<List<Carta>> manos = baraja.repartir(4);
        for (int i = 0; i < jugadores.size(); i++) {
            List<Carta> cartasRepartidas = manos.get(i);  // Obtener las cartas del jugador
            jugadores.get(i).recibirCartas(cartasRepartidas);
        }
    }

    public void jugarRonda() {

        System.out.println("Iniciando ronda " + (rondasJugadas + 1));
        // realizo el intercambio de cartas según las reglas
        // el numero de ronda afecta el intercambio
        Ronda ronda = new Ronda(rondasJugadas + 1, jugadores); // Pasamos el número de ronda a la clase Ronda
        ronda.iniciarIntercambio(jugadores);

        // Aquí iría la lógica para que los jugadores jueguen sus cartas, sumen puntos, etc.
        // Dependiendo de la dinámica del juego, puedes agregar un ciclo para que los jugadores jueguen
        // sus cartas y luego la función de cálculo de puntos.
        List<Carta> cartasJugadas = new ArrayList<>();  // Lista de cartas jugadas en esta ronda (debería llenarse con las cartas reales jugadas)
        Reglas.calcularPuntos(jugadores, cartasJugadas);  // Calcula los puntos sumados en esta ronda

        // El puntaje de cada jugador se actualiza a medida que se suman los puntos
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene " + jugador.getPuntaje() + " puntos.");
        }
    }

    // verifico si hay un ganador
    public boolean verificarGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() >= 100) {
                return true;
            }
        }
        return false;  // Si no hay ganador aún
    }

    // finalizo la partida y devuelvo el ganador
    public Jugador finalizarPartida() {
        Jugador ganador = Collections.min(jugadores, Comparator.comparingInt(Jugador::getPuntaje));
        return ganador;  // retorno el jugador con menos puntos (o el que cumpla alguna otra condición de victoria)
    }
}
