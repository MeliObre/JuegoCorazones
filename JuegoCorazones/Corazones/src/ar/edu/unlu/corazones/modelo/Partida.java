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

        while (!verificarGanador()) {
            jugarRonda();
            rondasJugadas++;
        }
        // muestro ganador por ronda
        Jugador ganador = finalizarPartida();
        System.out.println("La partida termino. El ganador es: " + ganador.getNombre());
    }


    private void repartirCartas() {
        baraja.barajar();
        List<List<Carta>> manos = baraja.repartir(4);
        for (int i = 0; i < jugadores.size(); i++) {
            List<Carta> cartasRepartidas = manos.get(i);
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

            Scanner scanner = new Scanner(System.in);
            int indiceElegido = scanner.nextInt();


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


        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " tiene " + jugador.getPuntaje() + " puntos.");
        }

        rondasJugadas++;
    }

    public boolean verificarGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntaje() >= 100) {
                return true;
            }
        }
        return false;
    }

    // finalizo la partida y devuelvo el ganador
    public Jugador finalizarPartida() {
        Jugador ganador = Collections.min(jugadores, Comparator.comparingInt(Jugador::getPuntaje));
        return ganador;
    }
}
