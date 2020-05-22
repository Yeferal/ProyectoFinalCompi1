
package objetos;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LienzoEditor {
    
    public Lienzo lienzo;
    public String nombreL;
    public ArrayList<Imagen> listaImagenes;
    public ArrayList<Color> listaColores;
    public JPanel panelGeneral = new JPanel();
    public JPanel panelCuadors = new JPanel();
    public JPanel panelColores = new JPanel();
    public JPanel panelScroll = new JPanel();
    public JScrollPane scrool = new JScrollPane();
    public JComboBox comboImagenes;
    public JButton botonColores;
    public  JCheckBox borrar;
    public JTextField  textoDuracion;
    JLabel labelCantidad = new JLabel("Cantidad:");
    JLabel labelInicio = new JLabel("Inicio:");
    JLabel labelFin = new JLabel("Fin:");
    JLabel labelImagen = new JLabel("Imagen");
    JLabel labelDuracion = new JLabel("Duracion");
    JLabel labelColores = new JLabel("Colores:");
    JLabel labelColoresSeleccionado = new JLabel("Color Seleccionado:");
    public JTextField  textoCantidad = new JTextField();
    public JTextField  textoInicio = new JTextField();
    public JTextField  textoFin = new JTextField();
    int bandera, idImagenN;
    
    public void agregarColor(Color c){
        listaColores.add(c);
    }
    
    public void agregarImagens(Imagen i){
        listaImagenes.add(i);
    }
    
    public LienzoEditor(Lienzo lienzo, String nombreL) {
        this.lienzo = lienzo;
        this.nombreL = nombreL;
        listaImagenes = new ArrayList<>();
        listaColores = new ArrayList<>();
    }
    
    public void generarPaneles(JTabbedPane tabbed){
        int anchoColores = (int) (tabbed.getWidth()*0.30) ;
        int anchoCuadros = (int) (tabbed.getWidth()*0.70) ;
        panelColores.setBounds(0, 0, anchoColores , tabbed.getHeight()-30);
        panelCuadors.setBounds(anchoColores, 10, anchoCuadros, tabbed.getHeight()-50);
        
        panelColores.setLayout(null);

        panelGeneral.setLayout(null);

        scrool.setBounds(30, 225, 280, 250);
        
        
        botonColores = new JButton();
        botonColores.setBounds(180, 500, 20, 20);
        botonColores.setBackground(java.awt.Color.WHITE);
        
        JPanel p =  new JPanel();
        

        agregarListaColores(p);

        scrool.setViewportView(p);
        
        agregarColores();
        llenarDatos();
        llenarCuadros(panelCuadors,0);
        panelColores.add(botonColores);
        panelColores.add(scrool);
        panelGeneral.add(panelColores);
        panelGeneral.add(panelCuadors);
        
        tabbed.addTab(lienzo.getNombre(), panelGeneral);
    }
    
    public void agregarColores(){
        
        textoDuracion = new JTextField();
        borrar = new JCheckBox("Borrar");
        comboImagenes = new JComboBox();
        
        borrar.setHorizontalTextPosition(SwingConstants.LEFT);
        borrar.setBounds(26, 550, 90, 25);
        borrar.setFont(new Font("Dialog", 1, 14));
        
        comboImagenes.setBounds(200, 40, 110, 25);
        labelImagen.setBounds(227, 20, 55, 15);

        textoCantidad.setBounds(90, 25, 70, 20);
        textoCantidad.setText(listaImagenes.size()+"");
        //textoCantidad.setEditable(false);
        labelCantidad.setBounds(30, 30, 55, 15);
        textoInicio.setBounds(90, 65, 70, 20);
        textoInicio.setText(lienzo.getInicio());
       //textoInicio.setEditable(false);
        
        labelInicio.setBounds(30, 70, 55, 15);
        textoFin.setBounds(90, 105, 70, 20);
        textoFin.setText(lienzo.getFin());
        //textoFin.setEditable(false);
        labelFin.setBounds(30, 110, 55, 15);
        labelDuracion.setBounds(227, 80, 55, 15);
        textoDuracion.setBounds(200, 100, 110, 20);

        labelColores.setBounds(30, 200, 55, 15);
        labelColoresSeleccionado.setFont(new Font("Dialog", 1, 14));
        
        labelColoresSeleccionado.setBounds(30, 500, 145, 20);

        panelColores.add(comboImagenes);
        panelColores.add(labelCantidad);
        panelColores.add(labelInicio);
        panelColores.add(labelFin);
        panelColores.add(labelImagen);
        panelColores.add(labelDuracion);
        panelColores.add(labelColores);
        panelColores.add(labelColoresSeleccionado);
        panelColores.add(borrar);
        panelColores.add(textoCantidad);
        panelColores.add(textoInicio);
        panelColores.add(textoFin);
        panelColores.add(textoDuracion);
        
    }
    
    public void agregarListaColores(JPanel p){
        p.removeAll();
        p.setLayout(new GridLayout(listaColores.size(), 1));
        for (int i = 0; i <listaColores.size(); i++) {
            JLabel tex = new JLabel(listaColores.get(i).getNombre());
            tex.setBounds(10, 35*i+10, 100, 20);
            tex.setFont(new Font("Dialog", 1, 14));
            JButton boton = new JButton();
            boton.setBounds(120, 35*i+10, 20, 20);
            if(listaColores.get(i).getTipoFondo()==1){
                boton.setBackground(new  java.awt.Color(listaColores.get(i).getRed(), listaColores.get(i).getGreen(), listaColores.get(i).getBlue()));
            }else{
                boton.setBackground(java.awt.Color.decode(listaColores.get(i).fondoHEX));
            }
            boton.addActionListener(new AccionColorBoton(boton, botonColores));
            p.add(tex);
            p.add(boton);
        }

    }
    
    public void llenarDatos(){
        
        for (int i = 0; i < listaImagenes.size(); i++) {
            listaImagenes.get(i).tablero = generarTablero();
            comboImagenes.addItem(listaImagenes.get(i).getId()+"");
        }
        bandera = 0;
        textoDuracion.setText(listaImagenes.get(0).getDuracion()+"");
        comboImagenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTiempo(bandera,textoDuracion.getText());
                int indice = comboImagenes.getSelectedIndex();
                textoDuracion.setText(listaImagenes.get(indice).getDuracion()+"");
                bandera = indice;
                
                llenarCuadros(panelCuadors, indice);
            }
        });

    }
    public void guardarTiempo(int b,String texto){
        if(!texto.isEmpty() && verificarDatoTipo(texto)){
            listaImagenes.get(bandera).setDuracion(Integer.parseInt(texto));
        }else{
            JOptionPane.showMessageDialog(null, "No se cambio la duracion ya que no es correcta");
        }
    }
    
    public boolean verificarDatoTipo(String numero){
        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public JButton[][] generarTablero(){
        JButton[][] t = new JButton[lienzo.getDimensionX()][lienzo.getDimensionY()];
        
        for (int i = 0; i < lienzo.getDimensionY(); i++) {
            for (int j = 0; j < lienzo.getDimensionX(); j++) {
//                JButton boton = new JButton("x:"+j+", y:"+i);
                JButton boton = new JButton();
                if(lienzo.getTipoFondo()==1){
                    boton.setBackground(new  java.awt.Color(lienzo.getRed(), lienzo.getGreen(), lienzo.getBlue()));
                }else{
                    boton.setBackground(java.awt.Color.decode(lienzo.fondoHEX));
                }
                boton.addActionListener(new AccionBoton(borrar, boton,botonColores));
                boton.setBorder(null);
                t[j][i] = boton;
            }
        }
        
        return t;
    }

    private void llenarCuadros(JPanel panelCuadors, int index) {
        JButton[][] t =listaImagenes.get(index).tablero;
        panelCuadors.removeAll();
        
        panelCuadors.setLayout(new GridLayout(lienzo.getDimensionY(), lienzo.getDimensionX()));
        
        for (int i = 0; i < lienzo.getDimensionY(); i++) {
            for (int j = 0; j < lienzo.getDimensionX(); j++) {
                panelCuadors.add(t[j][i]);
            }
        }
        panelCuadors.validate();
        panelCuadors.repaint();
        panelCuadors.updateUI();
    }
    
    public boolean verificarImagenes(String inicio, String fin){
        boolean correcto = false;
        boolean correcto1 = false;
        for (int i = 0; i < listaImagenes.size(); i++) {
            if(listaImagenes.get(i).getId().equals(inicio)){
                correcto=true;
                lienzo.setInicio(inicio);
            }
            if(listaImagenes.get(i).getId().equals(fin)){
                correcto1=true;
                lienzo.setFin(fin);
            }
        }
        
        if(correcto && correcto1){
            return true;
        }
        return false;
    }
    
    
    public void generarArchivoImagen(String ruta){
        if (lienzo.getTipo().equals("gif")) {
            generaGif(ruta);
            JOptionPane.showMessageDialog(null, "Se guardo la imagne");
        }else{
            try {
                generaJPG(ruta);
                JOptionPane.showMessageDialog(null, "Se guardaron las imagenes");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void generaGif(String ruta){
        AnimatedGifEncoder e = new AnimatedGifEncoder();
        e.start(ruta+"\\"+lienzo.getNombre()+".gif");
        //Inico
        Imagen inicio = buscarImagen(lienzo.getInicio());
        e.setDelay(inicio.getDuracion());
        BufferedImage imagenP = new BufferedImage(lienzo.getDimensionX()*lienzo.getCuadro(), lienzo.getDimensionY()*lienzo.getCuadro(), BufferedImage.TYPE_INT_ARGB);
        llenarCuadros(panelCuadors, idImagenN);
        panelCuadors.paint(imagenP.getGraphics());
        e.addFrame(imagenP);
        for (int i = 0; i < listaImagenes.size(); i++) {
            e.setDelay(listaImagenes.get(i).getDuracion());
            BufferedImage imagen1 = new BufferedImage(lienzo.getDimensionX()*lienzo.getCuadro(), lienzo.getDimensionY()*lienzo.getCuadro(), BufferedImage.TYPE_INT_ARGB);
            llenarCuadros(panelCuadors, i);
            panelCuadors.paint(imagen1.getGraphics());
            e.addFrame(imagen1);
        }
        //fin
        Imagen fin = buscarImagen(lienzo.getFin());
        e.setDelay(fin.getDuracion());
        BufferedImage imagenF = new BufferedImage(lienzo.getDimensionX()*lienzo.getCuadro(), lienzo.getDimensionY()*lienzo.getCuadro(), BufferedImage.TYPE_INT_ARGB);
        llenarCuadros(panelCuadors, idImagenN);
        panelCuadors.paint(imagenF.getGraphics());
        e.addFrame(imagenF);
        e.finish();
    }
    
    public void generaJPG(String ruta) throws IOException{
        for (int i = 0; i < listaImagenes.size(); i++) {
            BufferedImage imagen = new BufferedImage(panelCuadors.getWidth(), panelCuadors.getHeight(), BufferedImage.TYPE_INT_RGB);
            llenarCuadros(panelCuadors, i);
            panelCuadors.paint(imagen.getGraphics());
            ImageIO.write(imagen, "jpg", new File(ruta+"\\"+lienzo.getNombre()+"-"+listaImagenes.get(i).getId()+".jpg"));
        }
        
        
    }
    
    public Imagen buscarImagen(String nombre){
        Imagen im = null;
        for (int i = 0; i < listaImagenes.size(); i++) {
            if(listaImagenes.get(i).getId().equals(nombre)){
                idImagenN = i;
                im = listaImagenes.get(i);
                return im;
            }
        }
        return im;
    }
}
