package ar.edu.unlu.corazones.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VistaGrafica extends JFrame{
    private JButton botonReglas;
    private JButton botonIniciar;

    public VistaGrafica() {
        this.setTitle("Juego de Cartas - Corazones");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("¡Bienvenidos al Juego de Cartas Corazones!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        botonReglas = new JButton("Ver Reglas");
        botonIniciar = new JButton("Comenzar Juego");

        // botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonReglas);
        panelBotones.add(botonIniciar);

        this.setLayout(new BorderLayout());
        this.add(titulo, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);
    }

    public void agregarListenerReglas(ActionListener listener) {
        botonReglas.addActionListener(listener);
    }
    public void agregarListenerComenzarJuego(ActionListener listener) {
        botonIniciar.addActionListener(listener);
    }

}
