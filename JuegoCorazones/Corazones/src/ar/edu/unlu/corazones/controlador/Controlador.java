package ar.edu.unlu.corazones.controlador;
import ar.edu.unlu.corazones.vista.VistaGrafica;
import ar.edu.unlu.corazones.vista.VistaReglas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class Controlador {
    private VistaGrafica vista;

    public Controlador(VistaGrafica vista) {
        this.vista = vista;

        // uso listerns para interacciones simples
        this.vista.agregarListenerReglas(e -> mostrarReglas());
    }

    private void mostrarReglas() {
        VistaReglas vistaReglas = new VistaReglas();
        vistaReglas.setVisible(true);
    }
}

