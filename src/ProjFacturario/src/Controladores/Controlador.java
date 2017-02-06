/*
 * Clase de que todo controlador debe heredar
 */
package Controladores;

import Vistas.Vista;

/**
 *
 * @author 20151903
 */
public abstract class Controlador<V extends Vista> {

    /**
     * Vista asociada a este controlador
     */
    V Vista;
    
    public V getVista() {
        return Vista;
    }

    public void setVista(V Vista) {
        this.Vista = Vista;
    }

}
