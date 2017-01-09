/*
 * Clase de que todo controlador debe heredar
 */
package Controladores;

import Vistas.Vista;

/**
 *
 * @author 20151903
 */
public abstract class Controlador {

    /**
     * Vista asociada a este controlador
     */
    Vista Vista;
    
    public Vista getVista() {
        return Vista;
    }

    public void setVista(Vista Vista) {
        this.Vista = Vista;
    }

}
