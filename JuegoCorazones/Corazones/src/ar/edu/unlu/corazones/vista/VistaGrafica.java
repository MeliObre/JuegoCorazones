package ar.edu.unlu.corazones.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VistaGrafica extends JFrame{
    private JButton botonReglas;
    private JButton botonIniciar;

    public VistaGrafica() {
        // Configuración básica
        this.setTitle("Juego de Cartas - Corazones");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Crear componentes
        JLabel titulo = new JLabel("¡Bienvenidos al Juego de Cartas Corazones!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        botonReglas = new JButton("Ver Reglas");
        botonIniciar = new JButton("Comenzar Juego");

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(botonReglas);
        panelBotones.add(botonIniciar);

        // Agregar componentes al marco
        this.setLayout(new BorderLayout());
        this.add(titulo, BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);
    }

    // Método para agregar el listener al botón de "Ver Reglas"
    public void agregarListenerReglas(ActionListener listener) {
        botonReglas.addActionListener(listener);
    }
    // Método para agregar el listener al botón de "Comenzar Juego" (opcional)
    public void agregarListenerComenzarJuego(ActionListener listener) {
        botonIniciar.addActionListener(listener);
    }

}
