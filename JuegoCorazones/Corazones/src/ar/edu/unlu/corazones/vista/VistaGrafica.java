package ar.edu.unlu.corazones.vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class VistaGrafica extends JFrame{
    //private JButton botonReglas;
    //private JButton botonIniciar;
    JFrame frame;
    public VistaGrafica (){
        IniciarVistaGrafica();
    }

    private void IniciarVistaGrafica(){
        frame = new JFrame("Corazones");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal= (JPanel) frame.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        JLabel etiqueta1= new JLabel("Juego de cartas Corazones");
        panelPrincipal.add(etiqueta1,BorderLayout.NORTH);
        JPanel menu=new JPanel();
        menu.setLayout(new GridLayout(4,1,5,5));

        JButton boton1=new JButton("Iniciar juego");
        JButton boton2=new JButton("Reglas");

        menu.add(boton1);
        menu.add(boton2);

        JPanel menu2= new JPanel();
        menu2.setLayout(new FlowLayout());
        menu2.add(menu);

        panelPrincipal.add(menu2,BorderLayout.WEST);

        frame.setVisible(true);
    }

    /*
    public VistaGrafica() {
        frame = new JFrame("titulo de la venta");
        this.setTitle("Juego de Cartas - Corazones");
        frame.setSize(900, 900);
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
    */
}
