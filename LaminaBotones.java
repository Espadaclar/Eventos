import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version (01 / 07 / 2017)
 */
//EL OBJETO QUE RECIBE EL EVENTO IMPLEMENTA LA INTERFACE ActionListener
public class LaminaBotones extends JPanel implements ActionListener
{
    //CREAMOS dos botones más
    JButton botonAzul = new JButton("Azul");
    JButton botonAmarillo = new JButton("Amarillo");
    JButton botonRojo = new JButton("Rojo");
    public LaminaBotones(){
        //LOs AGREGAmos A LA LAMINA.
        add(botonAzul);
        add(botonAmarillo);
        add(botonRojo);        
        // creamos tres objetos fuente botonAzul, botonAmarillo y botonRojo
        // les decimos que van a desencadenar el evento addActionListener. es decir hacer click co el raton.
        // siendo el objetoOyente 'this' es decir la lamina
        //CADA VEZ QUE CLIQUEAMOS, SE CREA UN OBJETO EVENTO QUE VIAJA AUTOMATICAMENTE AL PARAMETRO DEL MT
        // actionPerformed(ActionEvent e)
        botonAzul.addActionListener(this);
        botonAmarillo.addActionListener(this);
        botonRojo.addActionListener(this);
    }//para que el funcionamiento de los botones funcione hay que aplicar el mt 'getSource()' para que nos devuelva la fuente,
    //el origen del evento, que boton es el que estamos clicando.
    public void actionPerformed(ActionEvent e){
        //variable para almacenar el boton que se cliquea.
        Object botonPulsado = e.getSource();
        if(botonPulsado == botonAzul){
            setBackground(Color.BLUE);
        }else if(botonPulsado == botonAmarillo){
            setBackground(Color.YELLOW);
        }else{
            setBackground(Color.RED);
        }
    }    
}

