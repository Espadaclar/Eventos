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
            System.out.println("Clikc sobre el marco.");
        }        
        //SE EJECUTA CUANDO EL BOTON DEL RATON ESTA PRESIONADO
        public void mousePressed(MouseEvent e){
            System.out.println("Boton del raton presionado.");
        }        
        //SE EJECUTA CUANDO EL BOTON DEL RATON DEJA DE ESTAR PRESIONADO
        public void mouseReleased(MouseEvent e){
            System.out.println("Acabas de levantar el dedo del boton del raton.");
        }        
        //SE EJECUTA CUANDO EL  RATON PASA SOBRE UN OBJETO DETERMINADO
        public void mouseEntered(MouseEvent e){
            System.out.println("Estas pasando el raton por el marco.");
        }        
        //SE EJECUTA CUANDO EL RATON DEJA DE PASAR SOBRE UN OBJETO DETERMINADO
        public void mouseExited(MouseEvent e){
            System.out.println("El raton ha salido del marco.");
        }
    }
}


















