package ar.edu.unlu.corazones.vista;
import javax.swing.*;
import java.awt.*;
public class VistaReglas extends JFrame{
    public VistaReglas() {
        this.setTitle("Reglas del Juego");
        this.setSize(600, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JTextArea textoReglas = new JTextArea("""
                    Reglas del Juego de Corazones:
                    Objetivo: 
                        -Evitar acumular puntos.
                    Valor de las Cartas
                        -Cada carta de corazones vale 1 punto.
                        -La Reina de picas vale 13 puntos.
                        -Las demás cartas no tienen valor en puntos.
                    El destino de las cartas cambia en cada ronda:
                        -Ronda 1: Al jugador de la izquierda.
                        -Ronda 2: Al jugador de la derecha.
                        -Ronda 3: Al jugador opuesto.
                        -Ronda 4: Sin intercambio.
                    El jugador con el 2 de tréboles inicia la partida.  
                    El jugador con la carta más alta del palo inicial recoge las cartas de esa mano y lidera la siguiente.    
                    
                    ¡Disfruta del juego!
                """);
        textoReglas.setEditable(false);
        textoReglas.setLineWrap(true);
        textoReglas.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(textoReglas);

        this.add(scroll, BorderLayout.CENTER);
    }

}
