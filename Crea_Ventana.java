import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *franciscoJavier
 *CREA NUEVAS VENTANAS CADA VEZ QUE ES INSTANCIADA DESDE LA CL. INTERNA 'Lamina' DE LA CLASE 'Apli_MultiplesOyentes9'
 * LA ACCION LA DESENCADENA EL BOTON PASADO EN EL PARAMETRO DEL CONSTRUCTOR
 * Y LA ACCION, EL CODIGO DEL MT actionPerformed(ActionEvent e).
 */
public class Crea_Ventana extends JFrame{
    public static int cont = 0;//acumuladores para variar las coordenadas.
    public static int contVentanas = 1;//acumuladores para numerar a las ventanas.
    /**
     * Constructor for objects of class Crea_Ventana
     */
    public Crea_Ventana(JButton boton)    {
        setBounds(40 +cont, 40 +cont, 250, 100);
        setTitle( "Ventana.- " +contVentanas); 
        setVisible(true);

        //quita el icono de java y pone miIcono en la ventana.
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imagen = icono.getImage("../icono2.gif");
        setIconImage(imagen);
        //acumuladores para variar las coordenadas.
        cont += 40;
        contVentanas ++;//--------------acumuladores para numerar a las ventanas.
        //llamada al objetoOyente para que ejecute su mt cuando sea pulsado el boton
        CierraTodo elimina = new CierraTodo();
        boton.addActionListener(elimina);
    }

    //CLASE INTERNA PARA CREAR UN OBJETO OYENTE
    private class CierraTodo implements ActionListener{
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }
}
