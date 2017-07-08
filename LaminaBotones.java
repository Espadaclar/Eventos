import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version (01 / 07 / 2017)
 */
public class LaminaBotones extends JPanel 
{
    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");
    
    public LaminaBotones(){
        //LOs AGREGAmos A LA LAMINA.
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);   
        
        //SE INSTANCIAN TRES OBJETOS DE LA CLASE INTERNA ColorDeFondo
        ColorDeFondo azul = new ColorDeFondo(Color.blue);
        ColorDeFondo rojo = new ColorDeFondo(Color.red);
        ColorDeFondo amarillo = new ColorDeFondo(Color.yellow);
        // creamos tres objetos fuente  como atributos botonAzul, botonAmarillo y botonRojo
        // les decimos que van a desencadenar el evento addActionListener. es decir hacer click con el raton.
        // siendo el objetoOyente cada una de las instancias del objeto ColorDeFondo.
        //CADA VEZ QUE CLIQUEAMOS, SE CREA UN OBJETO EVENTO QUE VIAJA AUTOMATICAMENTE AL PARAMETRO DEL MT
        // actionPerformed(ActionEvent e)
        botonAzul.addActionListener(azul);
        botonRojo.addActionListener(rojo);
        botonAmarillo.addActionListener(amarillo);
    }
    
    //CLASE INTERNA PARA REPRESENTAR AL OBJETO OYENTE
    private class ColorDeFondo implements ActionListener{
        private Color colorFondo;

        public ColorDeFondo(Color color){
            colorFondo = color;
        }

        public void actionPerformed(ActionEvent e){
            setBackground(colorFondo);
        }  
    }
}

