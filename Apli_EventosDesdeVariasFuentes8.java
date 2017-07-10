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
    private Color colorFondo;

    public Apli_EventosDesdeVariasFuentes8(){

    }

    public static void main(String[] args){
        Apli_EventosDesdeVariasFuentes8 miv = new Apli_EventosDesdeVariasFuentes8();
        miv.inicioDeFrame();
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
            //INSTANCIAMOS LA CLASE QUE RECIBE EL OYENTE 'BOTON'
            ColorDeFondo accionAmarillo = new ColorDeFondo("Amarillo", new ImageIcon("../am.png"), Color.YELLOW);
            ColorDeFondo accionAzul = new ColorDeFondo("Azul", new ImageIcon("../a.png"), Color.BLUE);
            ColorDeFondo accionRojo = new ColorDeFondo("Rojo", new ImageIcon("../r.png"), Color.RED);

            //ANADIMOS TRES OBJETOS BOTON A LA LAMINA UTILIZANDO EL CONSTRUCTOR 'JButton(Action a)' EL CUAL PIDE UN
            //PARAMETRO DE TIPO 'Action' ---
            JButton boton1 = new JButton(accionAmarillo);
            JButton boton2 = new JButton(accionAzul);
            JButton boton3 = new JButton(accionRojo);
            //anula la posicion por defecto que java da a todos los objetos dentro de la lamina.
            setLayout(null);
            //coordenadas y tamano para los botones.
            boton1.setBounds(50, 50, 150, 30);
            boton2.setBounds(50, 90, 150, 30);
            boton3.setBounds(50, 130, 150, 30);
            //anadimos los botones a la lamina.
            add(boton1);
            add(boton2);
            add(boton3);
            //PASOSO A SEGUIR PARA QUE FUNCIONE LA COMBINACIÓN DE TECLAS ---- OYENTE SERA LA TECLA
            //1, crear mapa de entrada, 
            InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//
            // 2, crear combinación de teclas, le damos un nombre a la combincion.
            //---KeyStroke teclaAmarilla = KeyStroke.getKeyStroke("ctrl A");
            // El objeto KeyStroke teclaAmarilla lo creamos directamente en el parametro de 
            // //mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
            mapaEntrada.put(KeyStroke.getKeyStroke("ctrl A"), "fondo_amarillo");
            mapaEntrada.put(KeyStroke.getKeyStroke("ctrl B"), "fondo_azul");
            mapaEntrada.put(KeyStroke.getKeyStroke("ctrl R"), "fondo_rojo");
            //4, asigar objeto a acción.
            //creamos una instancia de la clase ActionMap (es un mapa de accion) y aplicamos el mt put(_key_, _action_) 
            ActionMap mapaAction = getActionMap();
            
            mapaAction.put("fondo_amarillo", accionAmarillo);
            mapaAction.put("fondo_azul", accionAzul);
            mapaAction.put("fondo_rojo", accionRojo);
        }
        //CLASE INTERNA PARA REPRESENTAR AL OBJETO OYENTE, este objeto está a la escucha constantemente....¡¡¡¡¡¡¡¡¡
        //AL UTILIZAR VARIOS objetosFuente PARA REALIZAR UNA MISMA ACCION TENEMOS QUE UTILIZAR LA INTERFACE 'Action' o
        //HEREDAR DE LA CLASE 'AbastractAction'
        private class ColorDeFondo extends AbstractAction{
            /**
             * Para empezar a programar, 1º pensar en la información que nos interesa guardar del objetoFuente cuando
             * se cree el evento, en este caso guardamos, el nombre, un icono que represente al botón, una descripción
             * y la acción que realiza. Para qué? Para que cuando quiera poner el nombre del botón, lo ponga el programa. 
             * Igualmente con el icono, la descripcion saldrá cuando posemos el ratón sobre el botón. Y la accion
             * pasamos al constructor todos estos datos.
             */
            public ColorDeFondo(String nombre, Icon icono, Color color_boton){  
                colorFondo = color_boton;
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

            /**
             * decimos al programa lo que tiene que hacer cuando seam pulsados los botones. DATO¡¡¡
             * cuano pulsamos un boton se construye un objeto, EN ESE OBJETO HEMOS GUARDADO CUATRO PARES 
             * DE CLAVES CON UN VALOR 'putValue(.., ..)'  utilizando el mt 'getValue("clave")' nos devuelve el valor 
             * de la clave
             */
            public void actionPerformed(ActionEvent e){
                //ALMACENA EL VALOR DE LA CLAVE EN UNA VARIABLE DE TIPO COLOR
                Color color = (Color)getValue("color_de_fondo");
                setBackground(color);
                //obtiene mas datos de los objetos.
                //System.out.println("Nombre: " +getValue(Action.NAME)+ "\nDescripcion: " +getValue(Action.SHORT_DESCRIPTION));
            }  

        }
    }
}







