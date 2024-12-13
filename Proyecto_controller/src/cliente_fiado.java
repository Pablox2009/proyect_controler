
import codigo.fiadoCode;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class cliente_fiado extends javax.swing.JFrame {

    private fiadoCode fc;
    private String id, deuda, total, s1="0", s2="0", s3="0", s4="0";
    
    public cliente_fiado() {
        initComponents();
        fc= new fiadoCode();
        centrar();
        fiados();
    }
    
    public void fiados(){ 
        DefaultTableModel model = fc.clientesFiados();
        tabla_fiados.setModel(model);
        
        tabla_fiados.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int fila = tabla_fiados.getSelectedRow();
                if (fila != -1) {
                    id = tabla_fiados.getValueAt(fila, 0).toString();
                    deuda = tabla_fiados.getValueAt(fila, 3).toString();
                }
            }
        });
        
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 4) {
                    s1 = model.getValueAt(row, 4).toString();
                    actualizarS1();
                    fiados();
                }
                if (column == 5) {
                    s2 = model.getValueAt(row, 5).toString();
                    actualizarS2();
                    fiados();
                }
                if (column == 6) {
                    s3 = model.getValueAt(row, 6).toString();
                    actualizarS3();
                    fiados();
                }
                if (column == 7) {
                    s4 = model.getValueAt(row, 7).toString();
                    actualizarS4();
                    fiados();
                }
            }
        });
    }

    private void centrar(){
        Dimension tamaño = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamaño.width - this.getWidth()) / 2;
        int y = (tamaño.height - this.getHeight()) / 2;
        this.setLocation(x, y);
    }
    
    public void actualizarS1(){
        double deudaNumerica = Double.parseDouble(deuda);
        double pagoNumerico1 = Double.parseDouble(s1);
        double pagoNumerico2 = Double.parseDouble(s2);
        double pagoNumerico3 = Double.parseDouble(s3);
        double pagoNumerico4 = Double.parseDouble(s4);
        double totalNumerico = deudaNumerica - (pagoNumerico1 + pagoNumerico2 + pagoNumerico3 + pagoNumerico4);
        total = String.valueOf(totalNumerico);
        fc.modificarS1(id, s1, total);
        //s1="0"; s2="0"; s3="0";s4="0";
    }
    
    public void actualizarS2(){
        double deudaNumerica = Double.parseDouble(deuda);
        double pagoNumerico1 = Double.parseDouble(s1);
        double pagoNumerico2 = Double.parseDouble(s2);
        double pagoNumerico3 = Double.parseDouble(s3);
        double pagoNumerico4 = Double.parseDouble(s4);
        double totalNumerico = deudaNumerica - (pagoNumerico1 + pagoNumerico2 + pagoNumerico3 + pagoNumerico4);
        total = String.valueOf(totalNumerico);
        JOptionPane.showMessageDialog(null, "id:" + id + "semana2: "+ s2 + "total" +total);
        fc.modificarS2(id, s2, total);
        //s1="0"; s2="0"; s3="0";s4="0";
    }
    
    public void actualizarS3(){
        double deudaNumerica = Double.parseDouble(deuda);
        double pagoNumerico1 = Double.parseDouble(s1);
        double pagoNumerico2 = Double.parseDouble(s2);
        double pagoNumerico3 = Double.parseDouble(s3);
        double pagoNumerico4 = Double.parseDouble(s4);
        double totalNumerico = deudaNumerica - (pagoNumerico1 + pagoNumerico2 + pagoNumerico3 + pagoNumerico4);
        total = String.valueOf(totalNumerico);
        fc.modificarS3(id, s3, total);
        //s1="0"; s2="0"; s3="0";s4="0";
    }
    
    public void actualizarS4(){
        double deudaNumerica = Double.parseDouble(deuda);
        double pagoNumerico1 = Double.parseDouble(s1);
        double pagoNumerico2 = Double.parseDouble(s2);
        double pagoNumerico3 = Double.parseDouble(s3);
        double pagoNumerico4 = Double.parseDouble(s4);
        double totalNumerico = deudaNumerica - (pagoNumerico1 + pagoNumerico2 + pagoNumerico3 + pagoNumerico4);
        total = String.valueOf(totalNumerico);
        fc.modificarS4(id, s4, total);
        //s1="0"; s2="0"; s3="0";s4="0";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_fiados = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_fiados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_fiados);

        agregar.setText("Agregar un cliente");

        eliminar.setText("Eliminar un cliente");

        modificar.setText("Modificar datos");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Fiados");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(agregar)
                        .addGap(31, 31, 31)
                        .addComponent(eliminar)
                        .addGap(29, 29, 29)
                        .addComponent(modificar)
                        .addGap(182, 182, 182))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cliente_fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente_fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente_fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente_fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente_fiado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla_fiados;
    // End of variables declaration//GEN-END:variables
}
