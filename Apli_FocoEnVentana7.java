import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Crea dos ventanas. La ventana que tenga el foco, aparecera con el titulo de: Ventana con foco.
 * Utilizando una sola clase.
 * @version (San Fermin 2017)
 */
public class Apli_FocoEnVentana7 extends JFrame implements WindowFocusListener
{
    //almacena los datos de dos objetos que utilizaremos en toda la clase.
    private Apli_FocoEnVentana7 marco1;
    private Apli_FocoEnVentana7 marco2;
    /**
     * mt para que java inicialice el programa
     */
    public static void main(String[] args){
         Apli_FocoEnVentana7 miv = new Apli_FocoEnVentana7();
        miv.iniciar();
    }

    /**
     * Constructor for objects of class Apli_FocoEnVentana7
     */
    public Apli_FocoEnVentana7()
    {
       
    }
    
    /**
     * crea varias ventanas
     */
    public void iniciar(){
        marco1 = new Apli_FocoEnVentana7();
        marco1.setBounds(100, 100, 500, 300);
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ponemos al oyente a la escucha.
        marco1.addWindowFocusListener(this);
        
        marco2 = new Apli_FocoEnVentana7();
        marco2.setBounds(700, 100, 500, 300);
        marco2.setVisible(true);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //ponemos al oyente a la escucha.
        marco2.addWindowFocusListener(this);
    }
    
    /**
     * Este evento se produce en la ventana que tiene el foco.
     */
    public void windowGainedFocus(WindowEvent e){
        if(e.getSource() ==  marco1){
             marco1.setTitle("Ventana con foco");
        }else if(e.getSource() ==  marco2){
             marco2.setTitle("Ventana con foco");
        }
    }

    /**
     * Este evento se produce en la ventana que pierde el foco.
     */
    public void windowLostFocus(WindowEvent e){
        if(e.getSource() ==  marco1){
             marco1.setTitle(" ");
        }else if(e.getSource() ==  marco2){
             marco2.setTitle(" ");
        }
    }
}
