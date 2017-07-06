import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version (05 / 07 / 2017)
 */
public class MarcoRaton extends JFrame
{

    public MarcoRaton()
    {
        setBounds(150, 100, 700, 400);
        setTitle("Marco de raton.");
        setVisible(true);

        //instanciamos al objeto oyente
        RatonEvento raton = new RatonEvento();
        //PONEMOS AL OYENTE A LA ESCUCHA.
        this.addMouseMotionListener(raton);

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imagen = icono.getImage("../icono2.gif");
        setIconImage(imagen);
    }

    //CLASE INTERNA Y OYENTE PARA CREAR EL OBJETO OYENTE, EN VEZ DE IMPLEMENTAR LA INTERFACE UTILIZAMOS LA CLASE ADAPTADORA.
    private class RatonEvento implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e){
                System.out.println("Has pulsado el boton izquierdo y estas seleccionando.");
        }
        public void mouseMoved(MouseEvent e){
            System.out.println("Estas moviendo el raton.");
        }
    }
}

