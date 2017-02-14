/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import projfactura.Modelos.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Phenom
 */
public class RepositorioClientes extends RepositorioBase<Cliente>{

    @Override
    public ArrayList<Cliente> Obtener() {
        try {
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CLIENTES";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setClienteId(rs.getInt("ClienteId"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setRNC(rs.getString("RNC"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setEmail(rs.getString("Email"));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Cliente> Obtener(Predicate<Cliente> predicado) {
        try {
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            ArrayList<Cliente> resultado = new ArrayList<Cliente>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CLIENTES";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setClienteId(rs.getInt("ClienteId"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setRNC(rs.getString("RNC"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setEmail(rs.getString("Email"));
                lista.add(cli);
            }
            for (int i = 0; i < lista.size(); i++) {
                Cliente c = lista.get(i);
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
    public Cliente ObtenerUno(Predicate<Cliente> predicado) {
        try {
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            ArrayList<Cliente> resultado = new ArrayList<Cliente>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM CLIENTES";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setClienteId(rs.getInt("ClienteId"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setRNC(rs.getString("RNC"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setEmail(rs.getString("Email"));
                lista.add(cli);
            }
            
            for (int i = 0; i < lista.size(); i++) {
                Cliente c = lista.get(i);
                if (predicado.test(c)) {
                    resultado.add(c);
                }
            }

            return resultado.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void Agregar(Cliente entidad) {
        try {
            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO Clientes"
                    + "(Nombre,RNC,Direccion,Telefono,Email)"
                    + "VALUES"
                    + String.format("('%s','%s','%s','%s','%s')",
                            entidad.Nombre,
                            entidad.RNC,
                            entidad.Direccion,
                            entidad.Telefono,
                            entidad.Email);

            stmt.execute(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Eliminar(int id) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Clientes "
                    + "WHERE ClienteId=" + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void Actualizar(Cliente entidad) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Clientes "
                    + "SET Nombre = '" + entidad.Nombre + "'"
                    + ", RNC = '" + entidad.RNC + "'"
                    + ", Direccion = '" + entidad.Direccion + "'"
                    + ", Telefono = '" + entidad.Telefono + "'"
                    + ", Email = '" + entidad.Email + "'"
                    + " WHERE ClienteId = " + entidad.ClienteId;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return;
        }
    }

}
