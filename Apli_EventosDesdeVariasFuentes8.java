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
   

    /**
     * CLASE INTERNA PARA CREAR UNA LAMINA SOBRE EL FRAME.
     */
    private class Lamina extends JPanel{

        public Lamina(){

            //INSTANCIAMOS LA CLASE QUE RECIBE EL OYENTE
            ColorDeFondo accionAmarillo = new ColorDeFondo("Amarillo", new ImageIcon("../icono2.gif"), Color.YELLOW);
            ColorDeFondo accionAZUL = new ColorDeFondo("Azul", new ImageIcon("../icono2.gif"), Color.BLUE);
            ColorDeFondo accionRojo = new ColorDeFondo("Rojo", new ImageIcon("../icono2.gif"), Color.RED);
            
            //             //anula la posicion por defecto que java da a todos los objetos dentro de la lamina.
            //             setLayout(null);
            //             //coordenadas y tamano para los botones.
            //             boton1.setBounds(50, 50, 90, 20);
            //             boton2.setBounds(50, 90, 90, 20);
            //             boton3.setBounds(50, 130, 90, 20);
            //             //anadimos los botones a la lamina.
            //             add(boton1);
            //             add(boton2);
            //             add(boton3);

            //RECORDEMOS¡¡¡ el objeto que recibe la accion es el que implemeta la interface ActionListener,
            //y en este caso es: Apli_EventosDesdeVariasFuentes8, la cual pide un color por parametro
            //instamciamos tres objetos de esta clase
            //             ColorDeFondo azul = new  ColorDeFondo(Color.blue);
            //             ColorDeFondo rojo = new ColorDeFondo(Color.red);
            //             ColorDeFondo amarillo = new ColorDeFondo(Color.yellow);
            // 
            //             boton1.addActionListener(azul);
            //             boton2.addActionListener(rojo);
            //             boton3.addActionListener(amarillo);
        }
        //CLASE INTERNA PARA REPRESENTAR AL OBJETO OYENTE, este objeto está a la escucha constantemente....¡¡¡¡¡¡¡¡¡
        //AL UTILIZAR VARIOS objetosFuente PARA REALIZAR UNA MISMA ACCION TENEMOS QUE UTILIZAR LA INTERFACE 'Action' o
        //HEREDAR DE LA CLASE 'AbastractAction'

        private class ColorDeFondo extends AbstractAction{
            private Color colorFondo;
            
            public ColorDeFondo(String nombre, Icon icono, Color color_boton){
                //SE UTILIZA EL MT putValue(), y para almacenar el nombre, el icono y la descripcion se utiliza una constante
                //estatica perteneciente a la interface Action, esta será la clave del mt putValue() y el valor sera el valor
                // que demos al parametro en el constructor.
                putValue(Action.NAME, nombre);
                //PARA EL IONO OCURRE LO MISMO, TENEMOS OTRO CAMPO STATICO QUE SE UTILIZA PARA ALMACENAR ICONOS
                putValue(Action.SMALL_ICON, icono);
                //LA DESCRIPCION SERA DIFERENTE PARA CADA BOTON
                putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " +nombre);
                //PARA LA ACCION DEL BOTON (la clave no el una cons statica, me la invento)
                putValue("color_de_fondo", color_boton);
            }

            public void actionPerformed(ActionEvent e){
                setBackground(colorFondo);
            }  
        }
    }
}

/**
             * Para empezar a programar, 1º pensar en la información que nos interesa guardar del objetoFuente cuando
             * se cree el evento, en este caso guardamos, el nombre, un icono que represente al botón, una descripción
             * y la acción que realiza. Para qué? Para que cuando quiera poner el nombre del botón, lo ponga el programa. 
             * Igualmente con el icono, la descripcion saldrá cuando posemos el ratón sobre el botón. Y la accion
             * pasamos al constructor todos estos datos.
             */