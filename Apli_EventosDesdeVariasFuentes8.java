import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/** 
 * Realiza un evento desde varios objetosFuente, un boton y una tecla, para ello utilizamos la
 * interface 'Action' o tambien podemos heredar de la clase 'AbstracAction'.
 * @version (08 / 07 / 2017)
 */
public class Apli_EventosDesdeVariasFuentes8 extends JFrame 

{

    private Apli_EventosDesdeVariasFuentes8 vent1;

    private JButton boton1 = new JButton("Boton1");
    private JButton boton2 = new JButton("Boton2");
    private JButton boton3 = new JButton("Boton3");

    private static Color colorFondo;
    public static void main(String[] args){
        Apli_EventosDesdeVariasFuentes8 miv = new Apli_EventosDesdeVariasFuentes8();
        miv.inicioDeFrame();
    } 

    public Apli_EventosDesdeVariasFuentes8(){
        
    }

    public void inicioDeFrame(){
        vent1 = new Apli_EventosDesdeVariasFuentes8();
        vent1.setBounds(150, 150, 750, 400);
        vent1.setVisible(true);
        vent1.setTitle("Con Varios ObjetosFuente");
        vent1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //instancia el objetoLamina
        Lamina lamina = new Lamina();
        //anadimos la lamina.
        vent1.add(lamina);

        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imag = icono.getImage("../icono2.gif");
        vent1.setIconImage(imag);

    }
    //     public void actionPerformed(ActionEvent e){
    //         setBackground(colorFondo);
    //     }

    /**
     * CLASE INTERNA PARA CREAR UNA LAMINA SOBRE EL FRAME.
     */
    private class Lamina extends JPanel{

        public Lamina(){

            //anula la posicion por defecto que java da a todos los objetos dentro de la lamina.
            setLayout(null);
            //coordenadas y tamano para los botones.
            boton1.setBounds(50, 50, 90, 20);
            boton2.setBounds(50, 90, 90, 20);
            boton3.setBounds(50, 130, 90, 20);
            //anadimos los botones a la lamina.
            add(boton1);
            add(boton2);
            add(boton3);

            //RECORDEMOS¡¡¡ el objeto que recibe la accion es el que implemeta la interface ActionListener,
            //y en este caso es: Apli_EventosDesdeVariasFuentes8, la cual pide un color por parametro
            //instamciamos tres objetos de esta clase
            ColorDeFondo azul = new  ColorDeFondo(Color.blue);
            ColorDeFondo rojo = new ColorDeFondo(Color.red);
            ColorDeFondo amarillo = new ColorDeFondo(Color.yellow);

            boton1.addActionListener(azul);
            boton2.addActionListener(rojo);
            boton3.addActionListener(amarillo);
        }
        //CLASE INTERNA PARA REPRESENTAR AL OBJETO OYENTE, este objeto está a la escucha constantemente....¡¡¡¡¡¡¡¡¡
        //AL UTILIZAR VARIOS objetosFuente PARA REALIZAR UNA MISMA ACCION TENEMOS QUE UTILIZAR LA INTERFACE 'Action' o
        //HEREDAR DE LA CLASE 'AbastractAction'
        private class ColorDeFondo extends AbstractAction{
            private Color colorFondo;

            public ColorDeFondo(Color color){
                colorFondo = color;
            }

            public void actionPerformed(ActionEvent e){
                setBackground(colorFondo);
            }  
        }
    }
}



