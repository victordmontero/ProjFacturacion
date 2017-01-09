/*
 * Clase de la cual todo JFrame debe heredar
 */
package Vistas;

import Controladores.Controlador;
import javax.swing.JFrame;
/**
 *
 * @author Phenom
 */
public abstract class Vista extends JFrame{
    /**
     * Referencia al controlador a la cual esta vista
     * esta asociada.
     */
    private Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    
}
