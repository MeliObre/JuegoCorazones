import ar.edu.unlu.corazones.vista.VistaGrafica;
import ar.edu.unlu.corazones.controlador.Controlador;

import javax.swing.*;

public class CorazonesAppGrafica {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VistaGrafica v=new VistaGrafica();
            }
        });

       /*
        VistaGrafica vistaPrincipal = new VistaGrafica();
        Controlador controlador = new Controlador(vistaPrincipal);
        //muestro la vent principal
        vistaPrincipal.setVisible(true);
        */
    }
}
