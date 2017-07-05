import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *SE REALIZA UNA FUNCIÓN CONCRETA, DEPENDIENDO DE LA TECLA QUE SU PULSE.
 *Para esto tenemos que implementar La interface KeyListener, QUE implementa tres mt que reciben un parametro d tipo KeyEvent que
 *tienen un moton de mt y constantes. El mt keyPressed(KeyEvent e) es llamado cuando la tecla es presionada,  
 *keyReleased(KeyEvent e),  es llamado cuando se levanta el dedo de la tecla y keyTyped(KeyEvent e), es llamado 
 *despues de que la tecla ha sido presionada y dejado de ser presionada, cuando ya han ocurrido los dos sucesos anteriores.

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
