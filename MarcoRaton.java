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
        this.addMouseListener(raton);
        
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imagen = icono.getImage("../icono2.gif");
        setIconImage(imagen);
    }
    
    //CLASE INTERNA Y OYENTE PARA CREAR EL OBJETO OYENTE, EN VEZ DE IMPLEMENTAR LA INTERFACE UTILIZAMOS LA CLASE ADAPTADORA.
    private class RatonEvento extends MouseAdapter
    {
        // SE EJECUTA DESPUES DE PRESIONAR Y SOLTAR EL BOTON DEL RATON.
        public void mouseClicked(MouseEvent e){ 
            System.out.println("Posicion del ejeX." +e.getX()+ " pixeles. \nPosicion del ejeY." +e.getY()+ " pixeles.");
            System.out.println("Has realizado. " + e.getClickCount()+ " clikcs seguidos sobre el marco.");
             System.out.println("____________________________________________");
        }        
        
    }
}


















