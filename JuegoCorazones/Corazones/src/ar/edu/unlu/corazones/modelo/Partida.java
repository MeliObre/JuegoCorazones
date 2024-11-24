package ar.edu.unlu.corazones.modelo;
import java.util.*;

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

        Ronda ronda = new Ronda(rondasJugadas + 1, jugadores);

        // realizo el intercambio de cartas segun las reglas en la clase regla
        ronda.iniciarIntercambio(jugadores);

        List<Carta> cartasJugadas = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            // muestro las cartas disponibles para que el jugador elija
            System.out.println(jugador.getNombre() + " elige una carta:");
            for (int j = 0; j < jugador.getMano().size(); j++) {
                System.out.println(j + ": " + jugador.getMano().get(j));
            }
            //pido que elija una carta
            Scanner scanner = new Scanner(System.in);
            int indiceElegido = scanner.nextInt();

            // indice valido
            if (indiceElegido >= 0 && indiceElegido < jugador.getMano().size()) {
                Carta carta = jugador.jugarCarta(indiceElegido); // el jugador juega la carta seleccionada
                cartasJugadas.add(carta);
                System.out.println(jugador.getNombre() + " juega: " + carta);
            } else {
                System.out.println("Indice invalido");
            }
        }

        // Calcular los puntos sumados en esta ronda
        Reglas.calcularPuntos(jugadores, cartasJugadas);

        // Mostrar puntajes actualizados de los jugadores
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene " + jugador.getPuntaje() + " puntos.");
        }

        rondasJugadas++;
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
