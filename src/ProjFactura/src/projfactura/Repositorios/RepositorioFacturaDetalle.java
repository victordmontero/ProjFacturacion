/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Predicate;
import projfactura.Modelos.FacturaDetalle;
import projfactura.Modelos.FacturaDetalle;

/**
 *
 * @author VDMontero
 */
public class RepositorioFacturaDetalle extends RepositorioBase<FacturaDetalle> {

    @Override
    public ArrayList<FacturaDetalle> Obtener() {
        return Obtener(x -> 1 == 1);
    }

    @Override
    public ArrayList<FacturaDetalle> Obtener(Predicate<FacturaDetalle> predicado) {
        try {
            ArrayList<FacturaDetalle> lista = new ArrayList<FacturaDetalle>();
            ArrayList<FacturaDetalle> resultado = new ArrayList<FacturaDetalle>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Facturas";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                FacturaDetalle fac = new FacturaDetalle();

                fac.setFacturaId(rs.getInt("FacturaId"));
                fac.setProdutoId(rs.getInt("ProdutoId"));
                fac.setPrecio(rs.getDouble("Precio"));
                fac.setCantidad(rs.getInt("Cantidad"));

                lista.add(fac);
            }
            for (int i = 0; i < lista.size(); i++) {
                FacturaDetalle c = lista.get(i);
                if (predicado.test(c)) {
                    resultado.add(c);
                }
            }

            return resultado;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public FacturaDetalle ObtenerUno(Predicate<FacturaDetalle> predicado) {
        return Obtener(predicado).get(0);
    }

    @Override
    public void Agregar(FacturaDetalle entidad) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO FacturaDetalle"
                    + "(ProductoId,ClienteId,Precio,Cantidad)"
                    + "VALUES"
                    + String.format("(%d,%d,%f,%d)",
                            entidad.FacturaId,
                            entidad.ProdutoId,
                            entidad.Precio,
                            entidad.Cantidad);

            stmt.execute(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Actualizar(FacturaDetalle entidad) {
    }

    @Override
    public void Eliminar(int id) {
        
    }

}
