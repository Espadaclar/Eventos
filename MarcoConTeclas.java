import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**

 * @version (04 / 07 / 2017)
 */
public class MarcoConTeclas extends JFrame
{

    public MarcoConTeclas()
    {
       setBounds(150, 100, 700, 400);
       setTitle("Eveno teclado ");
       setVisible(true);
       //INSTANCIAMOS AL OBJETO_OYENTE
       EnvetoDeTeclado tecla = new EnvetoDeTeclado();
       //indicamos quien es el objetoOyente:
       this.addKeyListener(tecla);
       
       Toolkit icono = Toolkit.getDefaultToolkit();
       Image imagen = icono.getImage("../icono2.gif");
       setIconImage(imagen);
    }

    //CLASE INTERNA PARA CREAR EL OBJETO OYENTE.
    private class EnvetoDeTeclado implements KeyListener
    {
        //EN ESTA CLASE DE EVENTOS TENEMOS QUE DECIDIR CUANDO QUEREMOS QUE SE DESENCADENE LA ACCION
        //CUANDO PRESIONO LA TECLA, CUANDO LA SUELTO O, DESPUES DE ESAS DOS ACCIONES.
        /**
         * devuelve el codigo de la tecla pulsada.
         */
        public void keyPressed(KeyEvent e){ 
            int valor = e.getKeyCode();
            System.out.println(valor);
        }
        public void keyReleased(KeyEvent e){
        
        }
        /**
         * devuelve la letra o nº de la tecla pulsada.
         */
        public void keyTyped(KeyEvent e){
            char letra = e.getKeyChar();
            System.out.println(letra);
        }
    }
}
