package ar.edu.unlu.corazones.vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private JButton jugarCartaButton;
    private JTextArea informacionTextArea;
    private JPanel panel;
    public Vista() {
        setTitle("Corazones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // muestro información sobre el juego
        informacionTextArea = new JTextArea();
        informacionTextArea.setEditable(false);
        panel.add(new JScrollPane(informacionTextArea), BorderLayout.CENTER);

        // jugar una carta
        jugarCartaButton = new JButton("Jugar Carta");
        panel.add(jugarCartaButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    // actualizar la información mostrada en la interfaz
    public void actualizarInformacion(String info) {
        informacionTextArea.setText(info);
    }

    // escuchar la acción de jugar carta
    public void agregarListener(ActionListener listener) {
        jugarCartaButton.addActionListener(listener);
    }
}
