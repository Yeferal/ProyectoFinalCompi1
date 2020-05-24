package ventanas;

import analizadores.clrs.AnalizadorLexicoClrs;
import analizadores.clrs.*;
import analizadores.inz.*;
import analizadores.pnt.*;
import analizadores.tmp.*;
import archivos.Archivo;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import objetos.ArchivoExt;
import objetos.ErrorG;
import objetos.GenradorLienzos;
import tablas.TablaSimbolos;


public class VentanaPrincipal extends javax.swing.JFrame {

    
    int indexTabbd;
    NumeroLinea numeroLinea;
    Archivo archivo = new  Archivo();
    ArrayList<ArchivoExt> listaArchivos = new ArrayList<>();
    AnalizadorSintacticoLnz analizadorSintacticoLnz;
    AnalizadorSintacticoClrs analizadorSintacticoClrs;
    AnalizadorSintacticoTmp analizadorSintacticoTmp;
    AnalizadorSintacticoPnt analizadorSintacticoPnt;
    public ArrayList<ErrorG> listaErroresLnz = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresClrs = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresTmp = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresPnt = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoLnz = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoClrs = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoTmp = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoPnt = new  ArrayList<>();
    
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        menuGenerar.setEnabled(false);
        menuErrores.setEnabled(false);
        //menuErrores.setEnabled(true);
    }
    
    public void crearArchivo(String nombre,String tipo){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file!=null){
            String ruta = file.getPath()+"/"+nombre;
            System.out.println(ruta);
            archivo.crearArchivo(ruta, " ");
            ArchivoExt ar = new ArchivoExt(tipo, ruta);
            verificarArchivo(ar, nombre);
        }
        
    }
    
    private void verificarArchivo(ArchivoExt ar, String nombre){
        boolean estado = false;
        int index = 0;
        for (int i = 0; i < listaArchivos.size(); i++) {
            if(listaArchivos.get(i).getTipo().equals(ar.getTipo())){
                estado = true;
                index = i;
                break;
            }
        }
        
        if(estado){
            tabbedPanel.remove(index);
            listaArchivos.remove(index);
            listaArchivos.add(ar);
            JScrollPane j = new JScrollPane();
            JTextArea jArea = new JTextArea();
            NumeroLinea nL = new NumeroLinea(jArea);
            jArea.setText(archivo.leerArchivo(ar.getPath()));
            j.setRowHeaderView(nL);
            j.setViewportView(jArea);
            tabbedPanel.addTab(nombre, j);
        }else{
            listaArchivos.add(ar);
            JScrollPane j = new JScrollPane();
            JTextArea jArea = new JTextArea();
            NumeroLinea nL = new NumeroLinea(jArea);
            jArea.setText(archivo.leerArchivo(ar.getPath()));
            j.setRowHeaderView(nL);
            j.setViewportView(jArea);
            tabbedPanel.addTab(nombre, j);
        }
    }
    
    public int buscarArchivo(String tipo){
        int index = 0;
        for (int i = 0; i < listaArchivos.size(); i++) {
            if(listaArchivos.get(i).getTipo().equals(tipo)){
                index = i;
                return index;
            }
        }
        return 0;
    }
    
    public void verificarErrores(ArrayList<ErrorG> erroresLnz, ArrayList<ErrorG> erroresClrs, ArrayList<ErrorG> erroresTmp, ArrayList<ErrorG> erroresPnt){
        if(erroresLnz.size()>0 || erroresClrs.size()>0 || erroresTmp.size()>0 || erroresPnt.size()>0){
            JOptionPane.showMessageDialog(null, "Existen errores en el Archivo\nPuede verlos en la pestaña de Errores");
            menuGenerar.setEnabled(false);
            menuErrores.setEnabled(true);
            listaErroresLnz = erroresLnz;
            listaErroresClrs = erroresClrs;
            listaErroresTmp = erroresTmp;
            listaErroresPnt = erroresPnt;
            
        }else if(listaErroresLexicoLnz.size()>0 || listaErroresLexicoClrs.size()>0 || listaErroresLexicoTmp.size()>0 || listaErroresLexicoPnt.size()>0){
            JOptionPane.showMessageDialog(null, "Existen errores en el Archivo\nPuede verlos en la pestaña de Errores");
            menuGenerar.setEnabled(false);
            menuErrores.setEnabled(true);
            listaErroresLnz = erroresLnz;
            listaErroresClrs = erroresClrs;
            listaErroresTmp = erroresTmp;
            listaErroresPnt = erroresPnt;
        
        }else{
            JOptionPane.showMessageDialog(null, "Analisis Existoso");
            menuGenerar.setEnabled(true);
            menuErrores.setEnabled(false);
        }
    }
    
    
    public void actualizarDatos(String textoLnz, String textoClrs, String textoTmp, String textoPnt){
        if(listaArchivos.size()>0){
            for (int i = 0; i < listaArchivos.size(); i++) {
                System.out.println("Tipo: "+listaArchivos.get(i).getTipo());
                JScrollPane jAux = (JScrollPane) tabbedPanel.getComponent(i);
                JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
                switch(listaArchivos.get(i).getTipo()){
                    case "lnz":
                        areaAux.setText(textoLnz);
                        break;
                    case "clrs":
                        areaAux.setText(textoClrs);
                        break;
                    case "tmp":
                        areaAux.setText(textoTmp);
                        break;
                    case "pnt":
                        
                        break;
                }
                archivo.escribir(areaAux.getText(), listaArchivos.get(i).getPath());
            }

            if(listaArchivos.size()>0){
                JOptionPane.showMessageDialog(null, "Se Guardaron los cambio Correctamente");
            }
        }
    }
    
    public void leer(){
        try {
            boolean estado = false;
            int index = buscarArchivo("lnz");
            JScrollPane jAux = (JScrollPane) tabbedPanel.getComponent(index);
            JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            String texto = areaAux.getText();
            AnalizadorLexicoLnz analizadorLexicoLnz = new AnalizadorLexicoLnz(new StringReader(texto));
            analizadorSintacticoLnz = new AnalizadorSintacticoLnz(analizadorLexicoLnz);
            analizadorSintacticoLnz.parse();
            
            index = buscarArchivo("clrs");
            jAux = (JScrollPane) tabbedPanel.getComponent(index);
            areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            texto = areaAux.getText();
            AnalizadorLexicoClrs analizadorLexicoClrs = new AnalizadorLexicoClrs(new StringReader(texto));
            analizadorSintacticoClrs = new AnalizadorSintacticoClrs(analizadorLexicoClrs);
            analizadorSintacticoClrs.setTabla(analizadorSintacticoLnz.getTabla());
            analizadorSintacticoClrs.parse();
            
            index = buscarArchivo("tmp");
            jAux = (JScrollPane) tabbedPanel.getComponent(index);
            areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            texto = areaAux.getText();
            AnalizadorLexicoTmp analizadorLexicoTmp = new AnalizadorLexicoTmp(new StringReader(texto));
            analizadorSintacticoTmp = new AnalizadorSintacticoTmp(analizadorLexicoTmp);
            analizadorSintacticoTmp.setTabla(analizadorSintacticoLnz.getTabla());
            analizadorSintacticoTmp.parse();
            
            index = buscarArchivo("pnt");
            jAux = (JScrollPane) tabbedPanel.getComponent(index);
            areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            texto = areaAux.getText();
            
            AnalizadorLexicoPnt analizadorLexicoPnt = new AnalizadorLexicoPnt(new StringReader(texto));
            analizadorSintacticoPnt = new AnalizadorSintacticoPnt(analizadorLexicoPnt);
            analizadorSintacticoPnt.setTabla(analizadorSintacticoLnz.getTabla());
            analizadorSintacticoPnt.setTablaColores(analizadorSintacticoClrs.getTablaColor());
            analizadorSintacticoPnt.setTablaImagenes(analizadorSintacticoTmp.getTablaTiempos());
            analizadorSintacticoPnt.parse();
            
            TablaSimbolos tablaSimbolos = analizadorSintacticoLnz.getTabla();
            tablaSimbolos.pintar();
            System.out.println("");
            tablaSimbolos = analizadorSintacticoClrs.getTablaColor();
            tablaSimbolos.pintar();
            System.out.println("");
            tablaSimbolos = analizadorSintacticoTmp.getTablaTiempos();
            tablaSimbolos.pintar();

            System.out.println("");
            tablaSimbolos = analizadorSintacticoPnt.getTablaVariables();
            tablaSimbolos.pintar();
            System.out.println("");
            tablaSimbolos = analizadorSintacticoPnt.getTablaPintar();
            tablaSimbolos.pintar();
            
            listaErroresLexicoLnz = analizadorLexicoLnz.listaErrores;
            listaErroresLexicoClrs = analizadorLexicoClrs.listaErrores;
            listaErroresLexicoTmp = analizadorLexicoTmp.listaErrores;
            listaErroresLexicoPnt = analizadorLexicoPnt.listaErrores;
            
            verificarErrores(analizadorSintacticoLnz.listaErrores, analizadorSintacticoClrs.listaErrores, analizadorSintacticoTmp.listaErrores, analizadorSintacticoPnt.listaErrores);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        tabbedPanel = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuSubArchivo = new javax.swing.JMenu();
        menuItemLienzoz = new javax.swing.JMenuItem();
        menuItemColores = new javax.swing.JMenuItem();
        menuItemTiempo = new javax.swing.JMenuItem();
        menuItemPintar = new javax.swing.JMenuItem();
        menuItemAbrir = new javax.swing.JMenuItem();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuAnalisis = new javax.swing.JMenu();
        menuItemAnalisis = new javax.swing.JMenuItem();
        menuErrores = new javax.swing.JMenu();
        menuItemErrores = new javax.swing.JMenuItem();
        menuGenerar = new javax.swing.JMenu();
        menuItemEditorGrafico = new javax.swing.JMenuItem();
        menuItemGenerar = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuItemManualUsuario = new javax.swing.JMenuItem();
        menuItemManualTecnico = new javax.swing.JMenuItem();
        menuItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        menuBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        menuArchivo.setText("Archivo");

        menuSubArchivo.setText("Archivo");

        menuItemLienzoz.setText("Lienzos (.lnz)");
        menuItemLienzoz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLienzozActionPerformed(evt);
            }
        });
        menuSubArchivo.add(menuItemLienzoz);

        menuItemColores.setText("Colores (.clrs)");
        menuItemColores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemColoresActionPerformed(evt);
            }
        });
        menuSubArchivo.add(menuItemColores);

        menuItemTiempo.setText("Tiempo (.tmp)");
        menuItemTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTiempoActionPerformed(evt);
            }
        });
        menuSubArchivo.add(menuItemTiempo);

        menuItemPintar.setText("Pintar (.pnt)");
        menuItemPintar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPintarActionPerformed(evt);
            }
        });
        menuSubArchivo.add(menuItemPintar);

        menuArchivo.add(menuSubArchivo);

        menuItemAbrir.setText("Abrir");
        menuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemAbrir);

        menuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGuardar.setText("Guardad");
        menuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardar);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemSalir);

        menuBar.add(menuArchivo);

        menuAnalisis.setText("Analisis");

        menuItemAnalisis.setText("Analizar Archivos");
        menuItemAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAnalisisActionPerformed(evt);
            }
        });
        menuAnalisis.add(menuItemAnalisis);

        menuBar.add(menuAnalisis);

        menuErrores.setText("Errores");

        menuItemErrores.setText("Ver Errores");
        menuItemErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemErroresActionPerformed(evt);
            }
        });
        menuErrores.add(menuItemErrores);

        menuBar.add(menuErrores);

        menuGenerar.setText("Generar");

        menuItemEditorGrafico.setText("Editor Grafico");
        menuItemEditorGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEditorGraficoActionPerformed(evt);
            }
        });
        menuGenerar.add(menuItemEditorGrafico);

        menuItemGenerar.setText("Generar");
        menuItemGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGenerarActionPerformed(evt);
            }
        });
        menuGenerar.add(menuItemGenerar);

        menuBar.add(menuGenerar);

        menuAyuda.setText("Ayuda");

        menuItemManualUsuario.setText("Manual de Usuario");
        menuItemManualUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManualUsuarioActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemManualUsuario);

        menuItemManualTecnico.setText("Manual Tecnico");
        menuItemManualTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManualTecnicoActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemManualTecnico);

        menuItemAcercaDe.setText("Acerca de");
        menuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAcercaDeActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemAcercaDe);

        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos", "lnz", "clrs", "tmp", "pnt");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file!=null){
            String ruta = file.getPath();
            String nombreA = file.getName();
            String extencion = ruta.substring(ruta.length()-4, ruta.length());
            switch (extencion) {
                case ".lnz":
                    verificarArchivo(new ArchivoExt("lnz", ruta), nombreA);
                    break;
                case "clrs":
                    verificarArchivo(new ArchivoExt("clrs", ruta), nombreA);
                    break;
                case ".tmp":
                    verificarArchivo(new ArchivoExt("tmp", ruta), nombreA);
                    break;
                case ".pnt":
                    verificarArchivo(new ArchivoExt("pnt", ruta), nombreA);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El archivo seleccionado no \ntiene la extencon correcta");
                    break;
            }
            
            
            
        }
        
    }//GEN-LAST:event_menuItemAbrirActionPerformed

    private void tabbedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPanelMouseClicked
        //System.out.println("Tab #: "+tabbedPanel.getSelectedIndex());
        indexTabbd = tabbedPanel.getSelectedIndex();
    }//GEN-LAST:event_tabbedPanelMouseClicked

    private void menuItemLienzozActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLienzozActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre del archivo (.lnz)");
        if(nombre!=null){
            crearArchivo(nombre+".lnz","lnz");
        }else{
            System.out.println("es vacio");
        }
    }//GEN-LAST:event_menuItemLienzozActionPerformed

    private void menuItemTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTiempoActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre del archivo (.tmp)");
        if(nombre!=null){
            crearArchivo(nombre+".tmp","tmp");
        }else{
            System.out.println("es vacio");
        }
    }//GEN-LAST:event_menuItemTiempoActionPerformed

    private void menuItemColoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemColoresActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre del archivo (.clrs)");
        if(nombre!=null){
            crearArchivo(nombre+".clrs","clrs");
        }else{
            System.out.println("es vacio");
        }
    }//GEN-LAST:event_menuItemColoresActionPerformed

    private void menuItemPintarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPintarActionPerformed
        String nombre = JOptionPane.showInputDialog("Nombre del archivo (.pnt)");
        if(nombre!=null){
            crearArchivo(nombre+".pnt","pnt");
        }else{
            System.out.println("es vacio");
        }
    }//GEN-LAST:event_menuItemPintarActionPerformed

    private void menuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarActionPerformed
        
        if(listaArchivos.size()>0){
            for (int i = 0; i < listaArchivos.size(); i++) {
                JScrollPane jAux = (JScrollPane) tabbedPanel.getComponent(i);
                JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
                archivo.escribir(areaAux.getText(), listaArchivos.get(i).getPath());
            }

            if(listaArchivos.size()>0){
                JOptionPane.showMessageDialog(null, "Se Guardaron los cambio Correctamente");
            }
        }
        
        
    }//GEN-LAST:event_menuItemGuardarActionPerformed

    private void menuItemManualUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManualUsuarioActionPerformed
        try {
            File path = new File ("Manual_Usuario_IDE.pdf");
            Desktop.getDesktop().open(path);
       }catch (IOException ex) {
            ex.printStackTrace();
       }
    }//GEN-LAST:event_menuItemManualUsuarioActionPerformed

    private void menuItemAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAnalisisActionPerformed
        if(listaArchivos.size()>=4){
            leer();
        }else{
            System.out.println("No se puede");
        }
        
    }//GEN-LAST:event_menuItemAnalisisActionPerformed

    private void menuItemErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemErroresActionPerformed
        VentanaErrores ventanaErrores = new VentanaErrores();
        ventanaErrores.llenarErroresLexicos(listaErroresLexicoLnz, listaErroresLexicoClrs, listaErroresLexicoTmp, listaErroresLexicoPnt);
        ventanaErrores.llenarListasErrores(listaErroresLnz, listaErroresClrs, listaErroresTmp, listaErroresPnt);
        ventanaErrores.setVisible(true);
        
    }//GEN-LAST:event_menuItemErroresActionPerformed

    private void menuItemEditorGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEditorGraficoActionPerformed
        GenradorLienzos genradorLienzos = new GenradorLienzos();
        genradorLienzos.setTablas(analizadorSintacticoClrs.getTabla(), analizadorSintacticoClrs.getTablaColor(), analizadorSintacticoTmp.getTablaTiempos(),analizadorSintacticoPnt.getTablaPintar());
        
        VentanaEditorGrafico ventanaEditorGrafico = new VentanaEditorGrafico(this);
        ventanaEditorGrafico.setListas(genradorLienzos.listaLienzoEditors);
        ventanaEditorGrafico.setVisible(true);
    }//GEN-LAST:event_menuItemEditorGraficoActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed

    private void menuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAcercaDeActionPerformed
        String texto = "Yefer Alvarado, Estudiante de Ingenieria en Ciencia y Sistemas\n";
        texto += "Del curso de Compiladores 1\n\n";
        texto += "El programa es un Editor Grafico de imagenes sobre un tablero.\nEste tablero antes de poder ser visualizado tiene \nque ser exportado por un archivo de entrada ";
        texto += "que contiene \ninformacion de los datos sobre cada imagen inicial\n";
        texto += "Ademas de que se integra una analizador lexico y sintactico \npara la lectura correcta de los archivos.";
        JOptionPane.showMessageDialog(null, texto);
    }//GEN-LAST:event_menuItemAcercaDeActionPerformed

    private void menuItemGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGenerarActionPerformed
        GenradorLienzos genradorLienzos = new GenradorLienzos();
        genradorLienzos.setTablas(analizadorSintacticoClrs.getTabla(), analizadorSintacticoClrs.getTablaColor(), analizadorSintacticoTmp.getTablaTiempos(),analizadorSintacticoPnt.getTablaPintar());
        
        VentanaEditorGrafico ventanaEditorGrafico = new VentanaEditorGrafico(this);
        ventanaEditorGrafico.setListas(genradorLienzos.listaLienzoEditors);
        ventanaEditorGrafico.generarImagenes();
    }//GEN-LAST:event_menuItemGenerarActionPerformed

    private void menuItemManualTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManualTecnicoActionPerformed
        try {
            File path = new File ("Manual_Tecnico_IDE.pdf");
            Desktop.getDesktop().open(path);
       }catch (IOException ex) {
            ex.printStackTrace();
       }
    }//GEN-LAST:event_menuItemManualTecnicoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu menuAnalisis;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuErrores;
    private javax.swing.JMenu menuGenerar;
    private javax.swing.JMenuItem menuItemAbrir;
    private javax.swing.JMenuItem menuItemAcercaDe;
    private javax.swing.JMenuItem menuItemAnalisis;
    private javax.swing.JMenuItem menuItemColores;
    private javax.swing.JMenuItem menuItemEditorGrafico;
    private javax.swing.JMenuItem menuItemErrores;
    private javax.swing.JMenuItem menuItemGenerar;
    private javax.swing.JMenuItem menuItemGuardar;
    private javax.swing.JMenuItem menuItemLienzoz;
    private javax.swing.JMenuItem menuItemManualTecnico;
    private javax.swing.JMenuItem menuItemManualUsuario;
    private javax.swing.JMenuItem menuItemPintar;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemTiempo;
    private javax.swing.JMenu menuSubArchivo;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables
}
