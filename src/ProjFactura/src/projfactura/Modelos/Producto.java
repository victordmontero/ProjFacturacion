/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Modelos;

/**
 *
 * @author VDMontero
 */
public class Producto {
    public int ProductoId;
    public String Descripcion;
    public double Precio;
    public double Exento;

    public void setProductoId(int ProductoId) {
        this.ProductoId = ProductoId;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setExento(double Exento) {
        this.Exento = Exento;
    }
    
    
}
