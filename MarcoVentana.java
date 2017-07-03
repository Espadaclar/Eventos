import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * CLASE QUE RESPONDE A EVENTOS DE VENTANA, cuando se maximiza, se cierra, se activ etc.
 * @version 03 / 07 / 2017
 */
public class MarcoVentana extends JFrame
{
    public MarcoVentana()
    {
        //LE DECIMOS A LA CLASE MarcoVentana QUE ESTE PREPARADO PARA RECIBIR EVENTOS DE VENTANA
        //1º creamos la instancia de la clase oyente.
        M_marco marco = new M_marco();
        this.addWindowListener(marco);
        //pone miIcono en la ventana.
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imag = icono.getImage("../icono2.gif");
        setIconImage(imag);
    }

    /**
     * clase interna y clase oyente que implementa interface WindowListener para eventos de ventana.
     * AL SER UNA INTERFACE TENEMOS QUE SOBREESCRIBIR  TODOS SUS MT.
     */
    private class M_marco extends WindowAdapter{
        public void windowIconified(WindowEvent e){
            System.out.println("Ventana minimizada. ");
            //Invoked when a window is changed from a normal to a minimized state.
            // Se invoca cuando se cambia una ventana de un estado normal a un estado minimizado.
        }
    }
}

