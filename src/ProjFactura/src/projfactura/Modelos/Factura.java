/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Modelos;

import java.sql.Date;

/**
 *
 * @author VDMontero
 */
public class Factura {
    public int FacturaId;
    public int ClienteId;
    public String NCF;
    public Date Fecha;

    public void setFacturaId(int FacturaId) {
        this.FacturaId = FacturaId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public void setNCF(String NCF) {
        this.NCF = NCF;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
