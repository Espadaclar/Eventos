import javax.swing.*;
import java.awt.*;
import java.awt.Image;
/**
 * @version (01 / 07 / 2017)
 */
public class MarcoBotones extends JFrame
{

    public MarcoBotones()
    {
        setBounds(700, 300, 500, 100);
        LaminaBotones lamina = new LaminaBotones();
        add(lamina);
        setTitle("Ventana de Eventos");
        
        //Asigna mi icono en la ventana.
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("icono2.gif");
        setIconImage(icono);
    }

}
