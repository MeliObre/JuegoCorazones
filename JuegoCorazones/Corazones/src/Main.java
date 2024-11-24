import ar.edu.unlu.corazones.controlador.Controlador;
import ar.edu.unlu.corazones.modelo.Jugador;
import ar.edu.unlu.corazones.modelo.Partida;
import ar.edu.unlu.corazones.vista.Vista;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");

        // Press Mayús+F10 or click the green arrow button in the gutter to run the code.
        //for (int i = 1; i <= 5; i++) {

            // Press Mayús+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
          //  System.out.println("i = " + i);
        //}
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Jugador 1",1));
        jugadores.add(new Jugador("Jugador 2",2));
        jugadores.add(new Jugador("Jugador 3",3));
        jugadores.add(new Jugador("Jugador 4",4));
        Vista vista = new Vista();
        Partida partida = new Partida(jugadores);
        Controlador controlador = new Controlador(vista, partida);

    }
}