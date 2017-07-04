import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
/** 
 * Cada vez que cambiemos el estado de la ventana, se nos informa por pantalla del cambio que ha 
 * realizado la ventana para ello implementamos la interface WindowStateListener en una clase interna.
 * @version (04 / 07 / 2017)
 */
public class MarcoEstado extends JFrame
{
    /**
     * Constructor for objects of class MarcoEstado
     */
    public MarcoEstado()
    {
        setBounds(150, 150, 900, 450);
        setVisible(true);
        setTitle("Evento de estado.");
        
        //instancia del objetoOyente, del objeto que estara a la escucha.
        CambiaEstado marco = new CambiaEstado();
        this.addWindowStateListener(marco);

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imagen = icono.getImage("../icono2.gif");
        setIconImage(imagen);
    }

    private class CambiaEstado implements WindowStateListener
    {
        public void windowStateChanged(WindowEvent e){
            //System.out.println("La ventana ha cambiado de estado.");
            //getNewState() devuelve un nº entero que indica el estado de la ventana, Ver apuntes o api.
            //-------------------------------------------------------System.out.println(e.getNewState());
            //teniendo encuenta el valor que devolvera podemos ...poner alguna condicion.
            if(e.getNewState() == MAXIMIZED_BOTH) {
                System.out.println("Ha sido maximizada.");
            }else if(e.getNewState() == NORMAL) {
                System.out.println("Estado normal de la ventana.");
            }
            
        }
    }
}








