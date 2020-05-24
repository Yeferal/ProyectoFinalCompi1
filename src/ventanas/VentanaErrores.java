/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import objetos.ErrorG;

/**
 *
 * @author LENOVO-PC
 */
public class VentanaErrores extends javax.swing.JFrame {

    public ArrayList<ErrorG> listaErroresLexicoLnz = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoClrs = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoTmp = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLexicoPnt = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresLnz = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresClrs = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresTmp = new  ArrayList<>();
    public ArrayList<ErrorG> listaErroresPnt = new  ArrayList<>();
    String textolnz;
    String textoClrs; 
    String textoTmp; 
    String textoPnt;
    
    public VentanaErrores() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public void llenarErroresLexicos(ArrayList<ErrorG> erroresLnz, ArrayList<ErrorG> erroresClrs, ArrayList<ErrorG> erroresTmp, ArrayList<ErrorG> erroresPnt){
        listaErroresLexicoLnz = erroresLnz;
        listaErroresLexicoClrs = erroresClrs;
        listaErroresLexicoTmp = erroresTmp;
        listaErroresLexicoPnt = erroresPnt;
        textolnz = "LEXICO\n";
        textoClrs = "LEXICO\n";
        textoTmp = "LEXICO\n";
        textoPnt = "LEXICO\n";
        
        
        
        for (int i = 0; i < listaErroresLexicoLnz.size(); i++) {
            textolnz += listaErroresLexicoLnz.get(i).getDescripcion() + "\n";
        }
        
        for (int i = 0; i < listaErroresLexicoClrs.size(); i++) {
            textoClrs += listaErroresLexicoClrs.get(i).getDescripcion() + "\n";
        }
        
        for (int i = 0; i < listaErroresLexicoTmp.size(); i++) {
            textoTmp += listaErroresLexicoTmp.get(i).getDescripcion() + "\n";
        }
        
        for (int i = 0; i < listaErroresLexicoPnt.size(); i++) {
            textoPnt += listaErroresLexicoPnt.get(i).getDescripcion() + "\n";
        }
        
        textolnz += "\n";
        textoClrs += "\n";
        textoTmp += "\n";
        textoPnt += "\n";
    }
    
    public void llenarListasErrores(ArrayList<ErrorG> erroresLnz, ArrayList<ErrorG> erroresClrs, ArrayList<ErrorG> erroresTmp, ArrayList<ErrorG> erroresPnt){
        this.listaErroresLnz = erroresLnz;
        this.listaErroresClrs = erroresClrs;
        this.listaErroresTmp = erroresTmp;
        this.listaErroresPnt = erroresPnt;
        textolnz += "\nSINTACTICO-SEMANTICO\n";
        textoClrs += "\nSINTACTICO-SEMANTICO\n";
        textoTmp += "\nSINTACTICO-SEMANTICO\n";
        textoPnt += "\nSINTACTICO-SEMANTICO\n";
        
        for (int i = 0; i < listaErroresLnz.size(); i++) {
            if(listaErroresLnz.get(i).getTipo().equals("Semantico")){
                textolnz += listaErroresLnz.get(i).getTipo()+": "+listaErroresLnz.get(i).getDescripcion() + "     Linea: "+listaErroresLnz.get(i).getLinea()+", Columna: "+listaErroresLnz.get(i).getColumna()+"\n";
            }else{
                textolnz += listaErroresLnz.get(i).getDescripcion() + "\n";
            }
            
        }
        
        for (int i = 0; i < listaErroresClrs.size(); i++) {
            if(listaErroresClrs.get(i).getTipo().equals("Semantico")){
                textoClrs += listaErroresClrs.get(i).getTipo()+": "+listaErroresClrs.get(i).getDescripcion() + "     Linea: "+listaErroresClrs.get(i).getLinea()+", Columna: "+listaErroresClrs.get(i).getColumna()+"\n";
            }else{
                textoClrs += listaErroresClrs.get(i).getDescripcion() + "\n";
            }
        }
        
        for (int i = 0; i < listaErroresTmp.size(); i++) {
            if(listaErroresTmp.get(i).getTipo().equals("Semantico")){
                textoTmp += listaErroresTmp.get(i).getTipo()+": "+listaErroresTmp.get(i).getDescripcion() + "     Linea: "+listaErroresTmp.get(i).getLinea()+", Columna: "+listaErroresTmp.get(i).getColumna()+"\n";
            }else{
                textoTmp += listaErroresTmp.get(i).getDescripcion() + "\n";
            }
        }
        
        for (int i = 0; i < listaErroresPnt.size(); i++) {
            if(listaErroresPnt.get(i).getTipo().equals("Semantico")){
                textoPnt += listaErroresPnt.get(i).getTipo()+": "+listaErroresPnt.get(i).getDescripcion() + "     Linea: "+listaErroresPnt.get(i).getLinea()+", Columna: "+listaErroresPnt.get(i).getColumna()+"\n";
            }else{
                textoPnt += listaErroresPnt.get(i).getDescripcion() + "\n";
            }
        }
        textAreaLnz.setText(textolnz);
        textAreaClrs.setText(textoClrs);
        textAreaTmp.setText(textoTmp);
        textAreaPnt.setText(textoPnt);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaLnz = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaTmp = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaPnt = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaClrs = new javax.swing.JTextArea();
        labelLnz = new javax.swing.JLabel();
        labelTmp = new javax.swing.JLabel();
        labelClrs = new javax.swing.JLabel();
        labelPnt = new javax.swing.JLabel();
        labelErrores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textAreaLnz.setColumns(20);
        textAreaLnz.setRows(5);
        jScrollPane1.setViewportView(textAreaLnz);

        textAreaTmp.setColumns(20);
        textAreaTmp.setRows(5);
        jScrollPane2.setViewportView(textAreaTmp);

        textAreaPnt.setColumns(20);
        textAreaPnt.setRows(5);
        jScrollPane3.setViewportView(textAreaPnt);

        textAreaClrs.setColumns(20);
        textAreaClrs.setRows(5);
        jScrollPane4.setViewportView(textAreaClrs);

        labelLnz.setText(".lnz");

        labelTmp.setText(".tmp");

        labelClrs.setText(".clrs");

        labelPnt.setText(".pnt");

        labelErrores.setText("ERRORES");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(labelLnz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelClrs)
                .addGap(226, 226, 226))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(labelTmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPnt)
                .addGap(232, 232, 232))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelErrores)
                .addGap(462, 462, 462))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(labelErrores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLnz)
                    .addComponent(labelClrs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(labelPnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labelClrs;
    private javax.swing.JLabel labelErrores;
    private javax.swing.JLabel labelLnz;
    private javax.swing.JLabel labelPnt;
    private javax.swing.JLabel labelTmp;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea textAreaClrs;
    private javax.swing.JTextArea textAreaLnz;
    private javax.swing.JTextArea textAreaPnt;
    private javax.swing.JTextArea textAreaTmp;
    // End of variables declaration//GEN-END:variables
}
