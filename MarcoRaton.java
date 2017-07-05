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
        /*public void mouseClicked(MouseEvent e){ 
        //Imprime la posicion del raton en los dos ejes.
        System.out.println("Posicion del ejeX." +e.getX()+ " pixeles. \nPosicion del ejeY." +e.getY()+ " pixeles.");
        //Imprime el nº de clikcs seguidos realizados sobre el marco.
        System.out.println("Has realizado. " + e.getClickCount()+ " clikcs seguidos sobre el marco.");
        System.out.println("____________________________________________");
        e.getModifiersEx()
        }  */      
        /**
         * PARA SABER SI HEMOS UTILIZADO EL BOTON DERECHO O EL IZQUIERDO O LA RUEDA DEL RATON tenemos el mt 
         * e.getModifiersEx() , que utiliza campos de clase.
         * UTILIZAMOS OTRO DE LOS METODOS DE LA INFERFACE MouseListener
         */
        public void mousePressed(MouseEvent e){
            //e.getModifiersEx() DEVUELVE EL VALOR DE LOS CAMPOS DE CLASE 1024 -clickIzquierdo, 4096 -clikDerecho 
            //2048 pulsando la rueda del raton
            //System.out.println(e.getModifiersEx());
            int valor = e.getModifiersEx();
            if(valor == 1024){
                System.out.println("Has pulsado el boton izquierdo.");
            }else if(valor == MouseEvent.BUTTON3_DOWN_MASK){
                System.out.println("Has pulsado el boton derecho.");
            }else{
                System.out.println("Has pulsado la rueda.");
            }
        }
    }
}

