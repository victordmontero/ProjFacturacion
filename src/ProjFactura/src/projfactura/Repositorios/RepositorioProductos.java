/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import projfactura.Modelos.Producto;

/**
 *
 * @author VDMontero
 */
public class RepositorioProductos extends RepositorioBase<Producto> {

    @Override
    public ArrayList<Producto> Obtener() {
        return Obtener(x -> 1 == 1);
    }

    @Override
    public ArrayList<Producto> Obtener(Predicate<Producto> predicado) {
        try {
            ArrayList<Producto> lista = new ArrayList<Producto>();
            ArrayList<Producto> resultado = new ArrayList<Producto>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM PRODUCTOS";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Producto pro = new Producto();

                pro.setProductoId(rs.getInt("ProductoId"));
                pro.setDescripcion(rs.getString("Descripcion"));
                pro.setPrecio(rs.getDouble("Precio"));
                pro.setExento(rs.getDouble("Exento"));

                lista.add(pro);
            }
            for (int i = 0; i < lista.size(); i++) {
                Producto c = lista.get(i);
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
    public Producto ObtenerUno(Predicate<Producto> predicado) {
        return Obtener(predicado).get(0);
    }

    @Override
    public void Agregar(Producto entidad) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO Productos"
                    + "(Descripcion,Precio,Exento)"
                    + "VALUES"
                    + String.format("('%s',%s,%s)",
                            entidad.Descripcion,
                            entidad.Precio,
                            entidad.Exento);

            stmt.execute(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Actualizar(Producto entidad) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Productos "
                    + "SET Descripcion = '" + entidad.Descripcion + "'"
                    + ", Precio = '" + entidad.Precio + "'"
                    + ", Exento = '" + entidad.Exento + "'"
                    + " WHERE ProductoId = " + entidad.ProductoId;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Eliminar(int id) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Productos "
                    + "WHERE ClienteId=" + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

}
