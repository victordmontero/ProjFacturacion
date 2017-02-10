/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projfactura.Repositorios;

import Modelos.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author Phenom
 */
public class RepositorioClientes implements IRepositorio<Cliente> {

    Connection conn;

    public RepositorioClientes() {
        try {
            String url = "jdbc:derby://localhost:1527/ProjFacturario";
            String name = "app";
            String pwd = "app";
            conn = DriverManager.getConnection(url, name, pwd);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente ObtenerUno(Predicate<Cliente> predicado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Agregar(Cliente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Cliente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
