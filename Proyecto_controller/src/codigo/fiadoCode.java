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
    String[] columnas = {"id", "Nombre", "DNI", "Deuda", "Semana 1", "Semana 2", "Semana 3", "Semana 4", "Debe"};
    String[] fiados = new String[9];
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
            fiados[4] = rs.getString("s1");
            fiados[5] = rs.getString("s2");
            fiados[6] = rs.getString("s3");
            fiados[7] = rs.getString("s4");
            fiados[8] = rs.getString("total");
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
        String insert = "INSERT INTO fiado (nombre, dni, deuda, total) VALUES (?,?,?,?)";
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

    
    public void modificarS1(String idF, String p, String t){
        this.id = idF;
        this.pago = p;
        this.total = t;
        String insert = "UPDATE fiado SET s1 = ?, total = ? WHERE id = ?";
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
    
    public void modificarS2(String idF, String p, String t){
        this.id = idF;
        this.pago = p;
        this.total = t;
        String insert = "UPDATE fiado SET s2 = ?, total = ? WHERE id = ?";
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
    
    public void modificarS3(String idF, String p, String t){
        this.id = idF;
        this.pago = p;
        this.total = t;
        String insert = "UPDATE fiado SET s3 = ?, total = ? WHERE id = ?";
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
    
    public void modificarS4(String idF, String p, String t){
        this.id = idF;
        this.pago = p;
        this.total = t;
        String insert = "UPDATE fiado SET s4 = ?, total = ? WHERE id = ?";
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
