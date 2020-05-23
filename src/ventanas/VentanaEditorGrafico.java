/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import archivos.GeneradorTextoArchivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import objetos.ArchivoExt;
import objetos.LienzoEditor;


public class VentanaEditorGrafico extends javax.swing.JFrame {

    VentanaPrincipal ventanaPrincipal;
    int indiceTabbed;
    boolean correcto;
    ArrayList<LienzoEditor> listaLienzoEditores;
    GeneradorTextoArchivo generadorTextoArchivo = new GeneradorTextoArchivo();
    
    public VentanaEditorGrafico(VentanaPrincipal ventanaPrincipal){
        initComponents();
        this.setLocationRelativeTo(null);
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    public void setListas(ArrayList<LienzoEditor> listaLienzoEditors){
        this.listaLienzoEditores = listaLienzoEditors;
        for (int i = 0; i < listaLienzoEditores.size(); i++) {
            listaLienzoEditores.get(i).generarPaneles(tabbedEditor);
        }
        
        this.setVisible(true);
    }
    
    public boolean verificarDatoTipo(String numero){
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void verificadorActualizacion(){
        correcto = true;
        String inicio, fin;
        
        for (int i = 0; i < listaLienzoEditores.size(); i++) {
            inicio = listaLienzoEditores.get(i).textoInicio.getText();
            fin = listaLienzoEditores.get(i).textoFin.getText();
            if(!listaLienzoEditores.get(i).verificarImagenes(inicio, fin)){
                JOptionPane.showMessageDialog(null, "El inicio o el fin son incorrectos del lienzo: "+listaLienzoEditores.get(i).lienzo.getNombre());
                correcto = false;
                break;
            }
        }
        
        if (correcto) {
            generadorTextoArchivo.generar(listaLienzoEditores);
            ventanaPrincipal.actualizarDatos(generadorTextoArchivo.textoLnz, generadorTextoArchivo.textoClrs, generadorTextoArchivo.textoTmp, generadorTextoArchivo.textoPnt);
            JOptionPane.showMessageDialog(null, "SE GUARDARON LOS CAMBIO EXITOSAMENTE");
        }else{
            JOptionPane.showMessageDialog(null, "NO SE GUARDARON LOS CAMBIO");
        }
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        tabbedEditor = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuColor = new javax.swing.JMenu();
        menuItemEditarColores = new javax.swing.JMenuItem();
        menuGenerar = new javax.swing.JMenu();
        menuItemGenerarImagen = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedEditor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedEditorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1158, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        tabbedEditor.addTab("", jPanel1);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedEditor)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedEditor)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        menuItemGuardar.setText("Guardar Cambios");
        menuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardar);

        jMenuBar1.add(menuArchivo);

        menuColor.setText("Color");

        menuItemEditarColores.setText("Editar Colores");
        menuItemEditarColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditarColoresActionPerformed(evt);
            }
        });
        menuColor.add(menuItemEditarColores);

        jMenuBar1.add(menuColor);

        menuGenerar.setText("Generar");

        menuItemGenerarImagen.setText("Generar Imagen");
        menuItemGenerarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGenerarImagenActionPerformed(evt);
            }
        });
        menuGenerar.add(menuItemGenerarImagen);

        jMenuBar1.add(menuGenerar);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarActionPerformed
        verificadorActualizacion();
        
        
    }//GEN-LAST:event_menuItemGuardarActionPerformed

    private void tabbedEditorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedEditorMouseClicked
        indiceTabbed = tabbedEditor.getSelectedIndex();
    }//GEN-LAST:event_tabbedEditorMouseClicked

    private void menuItemEditarColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditarColoresActionPerformed
        
    }//GEN-LAST:event_menuItemEditarColoresActionPerformed

    private void menuItemGenerarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGenerarImagenActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file!=null){
            String ruta = file.getPath()+"/";
            for (int i = 0; i < listaLienzoEditores.size(); i++) {
            listaLienzoEditores.get(i).generarArchivoImagen(ruta);
        }
        }
        
        
        
        
    }//GEN-LAST:event_menuItemGenerarImagenActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuColor;
    private javax.swing.JMenu menuGenerar;
    private javax.swing.JMenuItem menuItemEditarColores;
    private javax.swing.JMenuItem menuItemGenerarImagen;
    private javax.swing.JMenuItem menuItemGuardar;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane tabbedEditor;
    // End of variables declaration//GEN-END:variables
}
