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
public class FacturaDetalle {
    public int ProdutoId;
    public int FacturaId;
    public double Precio;
    public int Cantidad;

    public void setProdutoId(int ProdutoId) {
        this.ProdutoId = ProdutoId;
    }

    public void setFacturaId(int FacturaId) {
        this.FacturaId = FacturaId;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    
}
