/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.function.Predicate;
import projfactura.Modelos.Factura;

/**
 *
 * @author VDMontero
 */
public class RepositorioFacturas extends RepositorioBase<Factura> {

    @Override
    public ArrayList<Factura> Obtener() {
        return Obtener(x -> 1 == 1);
    }

    @Override
    public ArrayList<Factura> Obtener(Predicate<Factura> predicado) {
        try {
            ArrayList<Factura> lista = new ArrayList<Factura>();
            ArrayList<Factura> resultado = new ArrayList<Factura>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Facturas";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Factura fac = new Factura();

                fac.setFacturaId(rs.getInt("FacturaId"));
                fac.setClienteId(rs.getInt("ClienteId"));
                fac.setNCF(rs.getString("NCF"));
                fac.setFecha(rs.getDate("Fecha"));

                lista.add(fac);
            }
            for (int i = 0; i < lista.size(); i++) {
                Factura c = lista.get(i);
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
    public Factura ObtenerUno(Predicate<Factura> predicado) {
        return Obtener(predicado).get(0);
    }

    @Override
    public void Agregar(Factura entidad) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO Facturas"
                    + "(ClienteId,NCF,Fecha)"
                    + "VALUES"
                    + String.format("(%s,'%s','%s')",
                            entidad.ClienteId,
                            entidad.NCF,
                            entidad.Fecha);

            stmt.execute(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Actualizar(Factura entidad) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Facturas "
                    + "SET ClienteId = '" + entidad.ClienteId + "'"
                    + ", NCF = '" + entidad.NCF + "'"
                    + ", Fecha = '" + entidad.Fecha + "'"
                    + " WHERE FacturaId = " + entidad.FacturaId;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Eliminar(int id) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Facturas "
                    + "WHERE ClienteId=" + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

}
