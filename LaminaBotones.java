import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version (01 / 07 / 2017)
 */
//EL OBJETO QUE RECIBE EL EVENTO IMPLEMENTA LA INTERFACE ActionListener
public class LaminaBotones extends JPanel implements ActionListener
{
    public LaminaBotones(){
        //CREAMOS EL BOTON
        JButton botonAzul = new JButton("Azul");
        //LO AGREGA A LA LAMINA.
        add(botonAzul);
        //A partir de aquí, tenemos que plantearnos los tres factores
        //1º que produce o desencadena la accion, ---hacer clikc en el boton
        //2º quien la produce, -----el boton
        //3º quien recibe la accion, ---la lamina que cambia de color
        
        //PARA QUE EL OBJETO FUENTE PUEDA REALIZAR UNA ACCION TENEMOS QUE UTILIZA EL MT 'addActionListener(_l_)'
        //Y EN SU PARAMETRO TENEMOS QUE ESPECIFICAR QUIEN SERA EL OYENTE, en este caso es la propia clase.
        //este parametro es de tipo ActionListener, y nos obliga a implementar la interface ActionListener.
        botonAzul.addActionListener(this);//--decimos al boton que va ha desencadenar un evento de
                                            // de tipo ActionListener y en el parametro quien lo va ha recibir
    }

    //al implementar la interface tenemos que sobreescribir sus mt, (solo tiene 1)
    //el parametro nos pide un objeto de tipo Evento, ¿que evento tien lugar en este programa? 
    // pues un evento de tipo ActionEvent, para el clikc del raton
    public void actionPerformed(ActionEvent e){
        //que tiene que hacer este mt, que tiene que hacer el clikc del raton?
        //poner la lamina en azul, luego
        setBackground(Color.BLUE);
    
    }
    
}




