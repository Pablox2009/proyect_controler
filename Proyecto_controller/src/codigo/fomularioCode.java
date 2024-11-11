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
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class fomularioCode {
    
    private String fecha, zona, total_inicial, puntos_venta_inicial;
    
    private String clientes_fiado, clientes_saldo, clientes_estado; 
    
    private String rendicion_efectivo, rendicion_transferencia, cobranza, gastos, rendicion_total;
    
    private String devolucion_cliente, devolucion_saldo, devolucion_total;
    
    private String pd_cantidad, pd_nombre, pd_precio_uni, pd_saldo, pd_total;
    
    private String total_real, tr_total, puntos_venta_final, devolucion;
    
    private String fiado_total;
    
    public void clientes(HashMap<String, String> codigoc){    
        String mostrar = "SELECT * FROM cliente WHERE borrado = 1";
        try{
            Connection con = conexion.conectar();
            PreparedStatement ps = con.prepareStatement(mostrar);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                codigoc.put(codigo, nombre);
            }
        }
        catch(SQLException err){
            err.printStackTrace();
        }
    }
    
    public void guardar(String fechaF, String zonaF, String total_inicialF, String puntos_inicial, List<String> clientesFiado, String fiado_totalF, List<String> clientesSaldo, List<String> clientesEstado, String rendicion_efectivoF, String rendicion_transferenciaF, String cobranzaF, String gastosF, String rendicion_totalF, List<String> devolucionCliente, List<String> devolucionSaldo, String devolucion_totalF, List<String> pdCantidad, List<String> pdNombre, List<String> pdPrecioUni, List<String> pdSaldo, String pd_totalF, String total_realF, String puntos_venta_finalF, String tr_totalF, String devolucionF){
        this.fecha = fechaF;
        this.zona = zonaF;
        this.total_inicial = total_inicialF;
        this.puntos_venta_inicial = puntos_inicial;
        
        this.clientes_fiado = String.join(",", clientesFiado);
        this.clientes_saldo = String.join(",", clientesSaldo);
        this.clientes_estado = String.join(",", clientesEstado);
        this.fiado_total = fiado_totalF;
        
        this.rendicion_efectivo = rendicion_efectivoF;
        this.rendicion_transferencia = rendicion_transferenciaF;
        this.cobranza = cobranzaF;
        this.gastos = gastosF;
        this.rendicion_total = rendicion_totalF;
        
        this.devolucion_cliente = String.join(",", devolucionCliente);
        this.devolucion_saldo = String.join(",", devolucionSaldo);
        this.devolucion_total = devolucion_totalF;
        
        this.pd_cantidad = String.join(",", pdCantidad);
        this.pd_nombre = String.join(",", pdNombre);
        this.pd_precio_uni = String.join(",", pdPrecioUni);
        this.pd_saldo = String.join(",", pdSaldo);
        this.pd_total = pd_totalF;
        
        this.total_real = total_realF;
        this.tr_total = tr_totalF;
        this.puntos_venta_final = puntos_venta_finalF;
        this.devolucion = devolucionF;
        String semana ="semana 1";
        String sql = "INSERT INTO registro (semana, fecha, zona, total_inicial, puntos_venta_inicial, clientes_fiado, fiado_saldo, fiado_estado, fiado_total, rendicion_efectivo, rendicion_transferencia, cobranza, gastos, rendicion_total, devolucion_cliente, devolucion_saldo, devolucion_total, pd_cantidad, pd_nombre, pd_precio_uni, pd_saldo, pd_total, total_real, tr_total, puntos_venta_final, devolucion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            Connection con = conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, semana);
            ps.setString(2, fecha);
            ps.setString(3, zona);
            ps.setString(4, total_inicial);
            ps.setString(5, puntos_venta_inicial);
            ps.setString(6, clientes_fiado);
            ps.setString(7, clientes_saldo);
            ps.setString(8, clientes_estado);
            ps.setString(9, fiado_total);
            ps.setString(10, rendicion_efectivo);
            ps.setString(11, rendicion_transferencia);
            ps.setString(12, cobranza);
            ps.setString(13, gastos);
            ps.setString(14, rendicion_total);
            ps.setString(15, devolucion_cliente);
            ps.setString(16, devolucion_saldo);
            ps.setString(17, devolucion_total);
            ps.setString(18, pd_cantidad);
            ps.setString(19, pd_nombre);
            ps.setString(20, pd_precio_uni);
            ps.setString(21, pd_saldo);
            ps.setString(22, pd_total);
            ps.setString(23, total_real);
            ps.setString(24, tr_total);
            ps.setString(25, puntos_venta_final);
            ps.setString(26, devolucion);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Listo","Listo",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
