/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package codigo;
import Conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Rellenar {
    public void rellenar(String tabla, String valor,JComboBox combo){
        String sql="select * from "+tabla;
        Statement st;
         conexion enlace=new conexion();
         Connection conect=enlace.conectar();
         
         try{
             st=conect.createStatement();
             ResultSet rs= st.executeQuery(sql);
             while(rs.next()){
                 combo.addItem(rs.getString(valor));
             }
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null, "Error"+e.toString());
         }
    }
}
