import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version 03 / 07 / 2017
 */
public class Apli_Evento2
{
    public static void main(String[] args){
        MarcoVentana ventana = new MarcoVentana();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CREAMOS UN NUEVO MARCO PARA TENER DOS VENTANAS.
        //DATOS¡¡¡¡ 
        // EL PARAMETRO 'DISPOSE_ON_CLOSE' ES PARA QUE NO FINALICE EL PROGRAMA AL CEERAR ESTE MARCO
        MarcoVentana ventana2 = new MarcoVentana();
        ventana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //para que no se sobreponga una ventana sobre la otra, damos coordenadas a cada una de ellas.
        ventana.setBounds(50, 50, 600, 400);
        ventana.setVisible(true);
        ventana.setTitle("Evento de ventana_1. ");
        ventana2.setBounds(730, 50, 600, 400);
        ventana2.setVisible(true);
        ventana2.setTitle("Evento de ventana_2. ");
    }
}
