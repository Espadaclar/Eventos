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
        setBounds(700, 300, 500, 300);
        LaminaBotones lamina = new LaminaBotones();
        add(lamina);
        
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("icono2.gif");
        setIconImage(icono);
    }

}
