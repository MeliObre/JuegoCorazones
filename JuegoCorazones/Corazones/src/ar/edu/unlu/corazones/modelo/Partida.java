package ar.edu.unlu.corazones.modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Partida {
    private List<Jugador> jugadores;  // Lista de jugadores
    private int rondasJugadas;  // Número de rondas jugadas
    private Baraja baraja;  // Baraja utilizada en la partida

    public Partida(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.rondasJugadas = 0;
        this.baraja = new Baraja();  // Crear una nueva baraja
    }

    // Inicia la partida
    public void iniciarPartida() {
        repartirCartas();  // Reparte las cartas a los jugadores
        rondasJugadas = 0;  // Reinicia el contador de rondas

        while (!verificarGanador()) {  // Mientras no haya un ganador
            jugarRonda();  // Juega una ronda
            rondasJugadas++;  // Aumenta el número de rondas jugadas
        }
        // Al finalizar las rondas, mostramos al ganador
        Jugador ganador = finalizarPartida();
        System.out.println("La partida ha terminado. El ganador es: " + ganador.getNombre());
    }

    // Repartir las cartas iniciales a los jugadores
    private void repartirCartas() {
        baraja.barajar();  // Barajar la baraja
        List<List<Carta>> manos = baraja.repartir(4);  // Asumiendo que hay 4 jugadores
        for (int i = 0; i < jugadores.size(); i++) {
            List<Carta> cartasRepartidas = manos.get(i);  // Obtener las cartas del jugador
            jugadores.get(i).recibirCartas(cartasRepartidas);
        }
    }

    // Jugar una ronda
    public void jugarRonda() {
        // Lógica para jugar una ronda
        System.out.println("Iniciando ronda " + (rondasJugadas + 1));

        // Ejemplo de cómo podría llevarse a cabo la ronda
        // Realizamos el intercambio de cartas según las reglas
        // El número de ronda podría afectar el intercambio, por ejemplo:
        Ronda ronda = new Ronda(rondasJugadas + 1); // Pasamos el número de ronda a la clase Ronda
        ronda.iniciarIntercambio(jugadores); // Inicia el intercambio de cartas para la ronda

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

    // Verificar si hay un ganador
    public boolean verificarGanador() {
        // Lógica para verificar si hay un ganador
        // Esto puede basarse en un puntaje específico, por ejemplo 50 puntos
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() >= 100) {  // Si un jugador alcanza o supera 50 puntos, se acaba el juego
                return true;
            }
        }
        return false;  // Si no hay ganador aún
    }

    // Finalizar la partida y devolver el ganador
    public Jugador finalizarPartida() {
        Jugador ganador = Collections.min(jugadores, Comparator.comparingInt(Jugador::getPuntaje));
        return ganador;  // Devuelve el jugador con menos puntos (o el que cumpla alguna otra condición de victoria)
    }
}
