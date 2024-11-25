import ar.edu.unlu.corazones.vista.VistaGrafica;
import ar.edu.unlu.corazones.controlador.Controlador;
public class CorazonesAppGrafica {
    public static void main(String[] args) {
        VistaGrafica vistaPrincipal = new VistaGrafica();
        Controlador controlador = new Controlador(vistaPrincipal);
        //muestro la vent principal
        vistaPrincipal.setVisible(true);
    }
}
