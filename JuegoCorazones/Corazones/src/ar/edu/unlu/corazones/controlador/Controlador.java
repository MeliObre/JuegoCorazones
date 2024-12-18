package ar.edu.unlu.corazones.controlador;
import ar.edu.unlu.corazones.vista.VistaGrafica;
import ar.edu.unlu.corazones.vista.VistaReglas;
import ar.edu.unlu.corazones.modelo.Partida;
import ar.edu.unlu.corazones.modelo.Jugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
public class Controlador {
    private VistaGrafica vista;
    private Partida Partida;

    public Controlador(VistaGrafica vista) throws Exception, RemoteException {
        this.vista = vista;

        // uso listerns para interacciones simples
        //this.vista.agregarListenerReglas(e -> mostrarReglas());
    }

    private void mostrarReglas() {
        VistaReglas vistaReglas = new VistaReglas();
        vistaReglas.setVisible(true);
    }
}

