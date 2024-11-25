package ar.edu.unlu.corazones.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class VistaGrafica extends JFrame{
    private JButton btnReglas;
    private JButton btnComenzarJuego;
    public VistaGrafica() {
        setTitle("Juego de Cartas Corazones");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel titulo = new JLabel("Bienvenidos al Juego de Cartas Corazones", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnReglas = new JButton("Ver Reglas");
        btnReglas.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnComenzarJuego = new JButton("Comenzar Juego");
        btnComenzarJuego.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnReglas);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnComenzarJuego);

        add(panel);

        setVisible(true);
    }
    public JButton getBtnReglas() {
        return btnReglas;
    }

    public JButton getBtnComenzarJuego() {
        return btnComenzarJuego;
    }

    public void agregarListenerReglas(ActionListener listener) {
        btnReglas.addActionListener(listener);
    }

    public void agregarListenerComenzarJuego(ActionListener listener) {
        btnComenzarJuego.addActionListener(listener);
    }

}
