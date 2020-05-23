/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.LienzoEditor;

public class VentanaColores extends javax.swing.JFrame {

    VentanaEditorGrafico ventanaEditorGrafico;
    ArrayList<LienzoEditor> listaLienzoEditores;
    int indice,indiceTabla;
    boolean seleccionado, agregarColor;
    objetos.Color colorNuevo = null;
    
    public VentanaColores(VentanaEditorGrafico ventanaEditorGrafico) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaEditorGrafico = ventanaEditorGrafico;
        seleccionado = false;
        agregarColor = false;
    }
    
    public void setDatos(ArrayList<LienzoEditor> listaLienzoEditores, int indice){
        this.listaLienzoEditores = listaLienzoEditores;
        this.indice = indice;
        labelLienzo.setText("Lienzo: "+listaLienzoEditores.get(indice).lienzo.getNombre());
        llenarTabla();
    }
    
    public void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        modelo.addColumn("Nombre Color");
        String nombreColor [] = new String[1];
        for (int i = 0; i < listaLienzoEditores.get(indice).listaColores.size(); i++) {
            nombreColor[0] = listaLienzoEditores.get(indice).listaColores.get(i).getNombre();
            modelo.addRow(nombreColor);
        }
    }
    
    public void llenarDatosColores(){
        labelRed.setText("Red: "+colorNuevo.getRed());
        labelBlue.setText("Blue: "+colorNuevo.getBlue());
        labelGreen.setText("Green: "+colorNuevo.getGreen());
        labelNombreColor.setText("Nombre: "+colorNuevo.getNombre());
    }
    
    public void limpiar(){
        labelRed.setText("");
        labelGreen.setText("");
        labelBlue.setText("");
        labelNombreColor.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        labelLienzo = new javax.swing.JLabel();
        botonColores = new javax.swing.JButton();
        labelColor = new javax.swing.JLabel();
        labelRed = new javax.swing.JLabel();
        labelGreen = new javax.swing.JLabel();
        labelBlue = new javax.swing.JLabel();
        labelNombreColor = new javax.swing.JLabel();
        botonFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        tabla.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        botonAgregar.setText("Agregar Nuevo");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        labelLienzo.setText("Lienzo: ");

        botonColores.setText("Colores");
        botonColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColoresActionPerformed(evt);
            }
        });

        labelRed.setText("Red: ");

        labelGreen.setText("Green: ");

        labelBlue.setText("Blue: ");

        labelNombreColor.setText("Nombre: ");

        botonFinalizar.setText("Finalizar");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(botonAgregar))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelNombreColor, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonColores)
                        .addGap(121, 121, 121)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelLienzo)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(botonFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminar)
                        .addGap(117, 117, 117))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelColor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(labelLienzo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(botonColores)
                        .addGap(18, 18, 18)
                        .addComponent(labelRed)
                        .addGap(18, 18, 18)
                        .addComponent(labelGreen)
                        .addGap(18, 18, 18)
                        .addComponent(labelBlue)
                        .addGap(18, 18, 18)
                        .addComponent(labelNombreColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(botonAgregar)))
                .addGap(22, 22, 22)
                .addComponent(labelColor, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonFinalizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        if(agregarColor){
            if(listaLienzoEditores.get(indice).buscarColor(colorNuevo.getNombre())==null){
                listaLienzoEditores.get(indice).listaColores.add(colorNuevo);
                llenarTabla();
                limpiar();
                agregarColor = false;
                JOptionPane.showMessageDialog(null, "Se agrego el Color"+colorNuevo.getNombre());
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe un color con ese Nombre");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar un color");
        }
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        indiceTabla = tabla.getSelectedRow();
        labelColor.setText(tabla.getValueAt(indiceTabla, 0).toString());
        seleccionado = true;
    }//GEN-LAST:event_tablaMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if(seleccionado){
            listaLienzoEditores.get(indice).listaColores.remove(indiceTabla);
            seleccionado = false;
            llenarTabla();
            JOptionPane.showMessageDialog(null, "Sel elimino el color: "+labelColor.getText());
            labelColor.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar un color de la Tabla");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColoresActionPerformed
        JColorChooser colorChooser = new JColorChooser();
        Color col = colorChooser.showDialog(null, "Seleccione un color", null);
        String nombre;
        if(col!=null){
            nombre = JOptionPane.showInputDialog("Nombre del Nuevo Color:");
            if(nombre!=null){
                objetos.Color cl = new objetos.Color();
                cl.setNombre(nombre);
                cl.setRed(col.getRed());
                cl.setGreen(col.getGreen());
                cl.setBlue(col.getBlue());
                cl.setTipoFondo(1);
                colorNuevo = cl;
                agregarColor = true;
                llenarDatosColores();
            }
        }else{
            System.out.println("No no no");
        }
    }//GEN-LAST:event_botonColoresActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        listaLienzoEditores.get(indice).agregarListaColores(listaLienzoEditores.get(indice).p);
        ventanaEditorGrafico.ventanaPrincipal.setVisible(true);
        ventanaEditorGrafico.setVisible(true);
        
    }//GEN-LAST:event_botonFinalizarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonColores;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBlue;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelGreen;
    private javax.swing.JLabel labelLienzo;
    private javax.swing.JLabel labelNombreColor;
    private javax.swing.JLabel labelRed;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
