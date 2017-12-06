/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Proyecto;
import models.Tarea;
import session_manager.Session;
import view_dialogs.DetailsTask;
import view_dialogs.DialogTermina;

/**
 *
 * @author cesargustavo
 */
public class ViewTareasUsuario extends javax.swing.JPanel {
    private Tarea tareas;
    private Proyecto proj;
    private DefaultTableModel modelo;
    private ResultSet results;
    private DialogTermina dit;
    private DetailsTask dett;
    
    /**
     * Creates new form ViewPrincipal
     */
    public ViewTareasUsuario(UserView _frame) {
        initComponents();
        tareas = new Tarea();
        proj = new Proyecto();
        
        dit = new DialogTermina(_frame,true);
        dit.setViewTareasUsuario(this);
        dett = new DetailsTask(_frame,true);
        
        modelo = new DefaultTableModel(){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Titulo");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Status");
        modelo.addColumn("Proyecto");
        
        this.jTable1.setModel(modelo);
        
        // COLORES DE LAS ROWS
        this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                        
                String status = (String)table.getModel().getValueAt(row, 3);
                if (isSelected) {
                    c.setBackground(Color.blue.darker());
                    c.setForeground(Color.white);
                }else{
                    if (col == 3) {
                        c.setForeground(Color.white);
                        switch(status){
                            case "Pendiente":
                                c.setBackground(Color.orange.darker());
                            break;
                            case "Cancelada":
                                c.setBackground(Color.red.darker());
                            break;
                            case "Terminada":
                                c.setBackground(Color.green.darker());
                            break;
                        }
                    }else{
                        c.setBackground(null);
                        c.setForeground(Color.black);
                    }
                }
                return this;
            }   
        });
        this.jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        finalizaTarea = new javax.swing.JButton();
        detallesTarea = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("Actividades:");

        finalizaTarea.setBackground(new java.awt.Color(0, 42, 73));
        finalizaTarea.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        finalizaTarea.setForeground(new java.awt.Color(255, 255, 255));
        finalizaTarea.setText("Terminar tarea");
        finalizaTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaTareaActionPerformed(evt);
            }
        });

        detallesTarea.setBackground(new java.awt.Color(0, 42, 73));
        detallesTarea.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        detallesTarea.setForeground(new java.awt.Color(255, 255, 255));
        detallesTarea.setText("Detalles");
        detallesTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallesTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(detallesTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(finalizaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizaTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detallesTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finalizaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaTareaActionPerformed
        // TODO add your handling code here:
        if (this.jTable1.getSelectedRowCount() > 0) {
            if (String.valueOf( jTable1.getValueAt(jTable1.getSelectedRow(), 3) ).equals("Pendiente")) {
                this.dit.setTaskData( Integer.valueOf( String.valueOf( jTable1.getValueAt(jTable1.getSelectedRow(), 0) ) ) );
                this.dit.setVisible(true);
            }else
                JOptionPane.showMessageDialog(this, "La tarea debe estar pendiente!");
        }else
            JOptionPane.showMessageDialog(this, "Seleccione una tarea!");
    }//GEN-LAST:event_finalizaTareaActionPerformed

    private void detallesTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallesTareaActionPerformed
        // TODO add your handling code here:
        if (this.jTable1.getSelectedRowCount() > 0) {
            if (String.valueOf( jTable1.getValueAt(jTable1.getSelectedRow(), 3) ).equals("Terminada")) {
                dett.setTaskData( Integer.valueOf( String.valueOf( jTable1.getValueAt(jTable1.getSelectedRow(), 0) ) ) );
                dett.setVisible(true);
            }else
                JOptionPane.showMessageDialog(this, "La tarea debe estar Terminada!");
        }else
            JOptionPane.showMessageDialog(this, "Seleccione una tarea!");
    }//GEN-LAST:event_detallesTareaActionPerformed
    
    public void actualizarTabla(){
        modelo.setRowCount(0);
        results=tareas.findByUserId(Session.getId());
        try{
            while(results.next()){
                modelo.addRow(new Object[]{
                    results.getString("id"),
                    results.getString("titulo"),
                    results.getString("descripcion"),
                    (results.getInt("status") == 1 ? "Pendiente" : (results.getInt("status") == 2) ? "Cancelada" : "Terminada" ),
                    results.getString("p_titulo")
                });
            }
            this.jTable1.setModel(modelo);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detallesTarea;
    private javax.swing.JButton finalizaTarea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
