/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fiadoCode {
    
    private String nombre, dni, deuda;
    private String id, pago, total;
    
    public DefaultTableModel clientesFiados() {
    String[] columnas = {"id", "Nombre", "DNI", "Deuda", "Monto", "Debe"};
    String[] fiados = new String[6];
    DefaultTableModel model = new DefaultTableModel(null, columnas);
    String select = "SELECT * FROM fiado";
    
    Connection con = null;
    PreparedStatement pr = null;
    ResultSet rs = null;

    try {
        con = conexion.conectar();
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos");
            return model;
        }
        
        pr = con.prepareStatement(select);
        rs = pr.executeQuery();

        while (rs.next()) {
            fiados[0] = rs.getString("id");
            fiados[1] = rs.getString("nombre");
            fiados[2] = rs.getString("dni");
            fiados[3] = rs.getString("deuda");
            fiados[4] = rs.getString("pagos");
            fiados[5] = rs.getString("total");
            model.addRow(fiados);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pr != null) pr.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión");
        }
    }
    return model;
}

    
    public void guardar(String n, String d, String de){
        this.nombre = n;
        this.dni = d;
        this.deuda = de;
        String insert = "INSERT INTO fiados (nombre, dni, deuda, total) VALUES (?,?,?,?)";
        try{
            Connection con = conexion.conectar();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, nombre);
            ps.setString(2, dni);
            ps.setString(3, deuda);
            ps.setString(4, deuda);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Listo","Listo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            
        }
    }
    
    public void modificarMonto(String idF, String p, String t){
        this.id = idF;
        this.pago = p;
        this.total = t;
        String insert = "UPDATE fiados SET pagos = ?, total = ? WHERE id = ?";
        try{
            Connection con = conexion.conectar();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, pago);
            ps.setString(2, total);
            ps.setString(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Listo","Listo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            
        }
    }
}
