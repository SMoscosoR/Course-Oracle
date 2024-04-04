/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;
import entregable2.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Academico
 */
public class Clientes extends javax.swing.JFrame {

    /**
     * Creates new form Entregable
     */
    public Clientes() {
        initComponents();
        mostrarClientes();
    }
    public void mostrarClientes(){
        try{
            Conexion cn = new Conexion();
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Clientes");
            
            DefaultTableModel modelo = (DefaultTableModel)tblClientes.getModel();
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            String[] columns = {"IDCliente", "DNI", "Nombre", "Apellido", "Telefono", "Direccion", "Email"};
            
            for(String column: columns){
                modelo.addColumn(column);
            }
            
            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("IDCliente")),
                    String.valueOf(resultSet.getInt("DNI")),
                    resultSet.getString("Nombre"),
                    resultSet.getString("Apellido"),
                    String.valueOf(resultSet.getInt("Telefono")),
                    resultSet.getString("Direccion"),
                    resultSet.getString("Email")
                };
                modelo.addRow(row);
        }
        tblClientes.setModel(modelo);
        } catch(SQLException e){
            e.printStackTrace();           
        }
    }
    
    public void eliminarClientes(){
        try{
            int idcliente;
            idcliente = Integer.parseInt(txtIDCliente.getText());        
            Conexion cn = new Conexion();
        
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Clientes WHERE IDCliente = ?");
            preparedStatement.setInt(1, idcliente); 
        
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Delete row succesfull");
                mostrarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Delete row fail");
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void insertarCliente(){
        try{
            int idcliente = Integer.parseInt(txtIDCliente.getText());
            int dni = Integer.parseInt(txtDNI.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellidos.getText();
            int telefono = Integer.parseInt(txtTelefono.getText());
            String direccion = txtDireccion.getText();
            String email = txtEmail.getText();

            Conexion cn = new Conexion();
            
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("INSERT INTO Clientes VALUES(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1,idcliente);
            ps.setInt(2,dni);
            ps.setString(3,nombre);
            ps.setString(4,apellido);
            ps.setInt(5,telefono);
            ps.setString(6,direccion);
            ps.setString(7,email);
             
            int rows = ps.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Insert row succesfull");
                mostrarClientes();
            } else {
                JOptionPane.showMessageDialog(null, "Insert row fail");
        } 
        } catch(SQLException e){
            e.printStackTrace();
}
    }
    public void actualizarCliente() {
    try {
            int idcliente = Integer.parseInt(txtIDCliente.getText());
            int dni = Integer.parseInt(txtDNI.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellidos.getText();
            int telefono = Integer.parseInt(txtTelefono.getText());
            String direccion = txtDireccion.getText();
            String email = txtEmail.getText();
            
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
        
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("UPDATE Clientes SET DNI = ?, Nombre = ?, Apellido = ?, Telefono = ?, Direccion = ?, Email = ? WHERE IDCliente = ?");
        
            ps.setInt(1,dni);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setInt(4,telefono);
            ps.setString(5,direccion);
            ps.setString(6,email);
            ps.setInt(7, idcliente);

        int rows = ps.executeUpdate();
        
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
            mostrarClientes();
        } else {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
        }
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IDCliente:");

        jLabel2.setText("Clientes");

        jLabel3.setText("DNI:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Direccion:");

        jLabel8.setText("Email:");

        txtIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDClienteActionPerformed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnInsertar)
                        .addGap(51, 51, 51)
                        .addComponent(btnActualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                                    .addComponent(txtIDCliente)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellidos)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDClienteActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        insertarCliente();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarCliente();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarClientes();
    }//GEN-LAST:event_btnEliminarActionPerformed
private void tblClientesMouseClicked(java.awt.event.MouseEvent evt){
        int columns = tblClientes.getSelectedColumn();
        int row = tblClientes.getSelectedRow();
        
        tblClientes.getModel().getValueAt(row, 1);
        tblClientes.getModel().getValueAt(row, 2);
        tblClientes.getModel().getValueAt(row, 3);
        tblClientes.getModel().getValueAt(row, 4);
        tblClientes.getModel().getValueAt(row, 5);
        tblClientes.getModel().getValueAt(row, 6);
        tblClientes.getModel().getValueAt(row, 7);
        
        
        txtIDCliente.setText(String.valueOf(tblClientes.getModel().getValueAt(row, 0)));
        txtDNI.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 1)));
        txtNombre.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 2)));
        txtApellidos.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 3)));
        txtTelefono.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 4)));
        txtDireccion.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 5)));
        txtEmail.setText(String.valueOf(tblClientes.getModel().getValueAt(row+1, 6)));

    }
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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
