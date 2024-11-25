package ar.edu.unlu.corazones.controlador;
import ar.edu.unlu.corazones.vista.VistaGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Controlador {
    private VistaGrafica vista;

    public Controlador(VistaGrafica vista) {
        this.vista = vista;
        this.vista.agregarListenerReglas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarReglas();
            }
        });

        this.vista.agregarListenerComenzarJuego(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });
    }

    private void mostrarReglas() {
        JOptionPane.showMessageDialog(vista, "Reglas del juego Corazones:\n\n1. Las reglas básicas...\n2. El objetivo es...");
    }

    private void iniciarJuego() {
        JOptionPane.showMessageDialog(vista, "¡El juego ha comenzado!");
    }
}

