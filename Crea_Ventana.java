import javax.swing.*;
import java.awt.*;
/**
 *franciscoJavier
 */
public class Crea_Ventana extends JFrame
{
    public static int cont = 1;
    public static int coorX = 40;
    public static int contVentanas = 1;
    /**
     * Constructor for objects of class Crea_Ventana
     */
    public Crea_Ventana()
    {
        setBounds(40 *cont, 40 *cont, 250, 100);
        setTitle( "Ventana.- " +contVentanas); 
        setVisible(true);
        
        cont ++;
        contVentanas ++;
    }


}
