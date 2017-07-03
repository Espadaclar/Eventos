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
        // PASAMOS ESTOS DATOS A LA APLICACION.
        //         setBounds(150, 50, 600, 400);
        //         setVisible(true);
        //         setTitle("Evento de ventana. ");

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
    private class M_marco implements WindowListener{

        /*
         * EN CADA UNO DE LOS MT SE PUEDE PROGRAMAR MILES DE LINEAS
         */
        public void	windowActivated(WindowEvent e){ 
            System.out.println("Ventana ACTIVADA. ");
            //Invoked when the Window is set to be the active Window.
        }

        public void windowClosed(WindowEvent e){
            //Invoked when a window has been closed as the result of calling dispose on the window.
            // Se invoca cuando la ventana está configurada para ser la ventana activa.
        }

        public void windowClosing(WindowEvent e){
            System.out.println("Ventana CERRADA. ");
            //Invoked when the user attempts to close the window from the window's system menu.
            // Se invoca cuando el usuario intenta cerrar la ventana desde el menú del sistema de Windows.
        }

        public void windowDeactivated(WindowEvent e){
            //System.out.println("Ventana DESACTIVADA. ");
            //Invoked when a Window is no longer the active Window.
            // Se invoca cuando una ventana ya no es la ventana activa.
        }

        public void windowDeiconified(WindowEvent e){
            System.out.println("Ventana RESTAURADA. ");
            //Invoked when a window is changed from a minimized to a normal state.
            // Se invoca cuando se cambia una ventana de un estado minimizado a un estado normal.
        }

        public void windowIconified(WindowEvent e){
            System.out.println("Ventana minimizada. ");
            //Invoked when a window is changed from a normal to a minimized state.
            // Se invoca cuando se cambia una ventana de un estado normal a un estado minimizado.
        }

        public void windowOpened(WindowEvent e){
            System.out.println("Ventana ABIERTA. ");
            //Invoked the first time a window is made visible.
            // Se invoca la primera vez que se hace visible una ventana.
        }
    }
}

