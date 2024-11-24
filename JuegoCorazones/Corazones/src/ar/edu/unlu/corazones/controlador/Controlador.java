package ar.edu.unlu.corazones.controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ar.edu.unlu.corazones.modelo.Partida;
import ar.edu.unlu.corazones.vista.Vista;

public class Controlador {
    private Vista vista;
    private Partida partida;

    public Controlador(Vista vista, Partida partida) {
        this.vista = vista;
        this.partida = partida;

        vista.agregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarCarta();
            }
        });
    }

    public void jugarCarta() {
        // Supongamos que jugamos la carta en la ronda
        // Deberías obtener el jugador actual y la carta que juega
        // y luego actualizar el modelo
        partida.jugarRonda();

        // Luego, actualizar la vista
        vista.actualizarInformacion("¡Ronda jugada!");
    }
}
