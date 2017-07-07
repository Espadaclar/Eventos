import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @version (06 / 07 / 2017)
 */
public class MarcoFoco extends JFrame
{
    /**
     * Constructor for objects of class MarcoFoco
     */
    public MarcoFoco()
    {
        setBounds(150, 50, 1200, 650);
        setTitle("Marco para evento foco. ");
        setVisible(true);
        //instanciamos es objeto LaminaEventoFoco
        LaminaEventoFoco lamina = new LaminaEventoFoco();
        add(lamina); //anade la lamina al marco

        //Para que aparecca mi icono en el marco de la ventana.
        Toolkit marco = Toolkit.getDefaultToolkit();
        Image imagen = marco.getImage("../icono2.gif");
        setIconImage(imagen);
    }

    //CLASE INTERNA PARA CREAR UNA LAMINA DENTRO DEL MARCO.
    private class  LaminaEventoFoco extends JPanel
    {
        //variables objeto de tipo JTextField. igual que si fueran String
        JTextField cuadro1;
        JTextField cuadro2;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //agregamos componentes, 'cuadros de texto a la lamina'
            //1º tenemos que invalidar el Layout --(disposición que tienen los elementos dentro de una ventana)
            //java por defecto da una colocación a los elementos que creamos dentro de un marco, los centra,.
            //¡¡¡ INVALIDAMOS ESTA COLOCACIÓN !!! con el mt 'setLayout(null)'
            setLayout(null);//-------- invalidada colocacion por defecto de java.
            //2º agregamos cuadros de texto para lo que utilzamos la clase JTextField
            //para ello instanciamos las dos variables objeto de tipo JTextField
            cuadro1 = new JTextField();
            cuadro2 = new JTextField();
            //al haber anulado el 'layout()' tenemos que dar posición y tamano al los cuadros de texto.
            cuadro1.setBounds(100, 100, 400, 30);
            cuadro2.setBounds(100, 160, 400, 30);
            //tenemos que anadirlos a la laminaaaaa.
            add(cuadro1);
            add(cuadro2);
            //en este punto, si ejecutamos el programa, aparecen los dos cuadros de texto.
            //EL FOCO ESTARA SOBRE EL QUE PONGAMOS EL CURSOR,
            //SI PINCHAMOS EN EL OTRO CUADRO_DE_TEXTO EL FOCO PASA PARA EL, -----SE HAN PRODUCIDO DOS EVENTOS:
            // CUADRO1 pierde el FOCO Y CUADRO2 gana el FOCO,
            //TRATAMOS DE DESENCADENAR ACCIONES CUANDO OCURRAN ESTA COSAS.
            //-------- CON QUE OBJETO??????
            // -----pues por ej; si ponemos la dirección de correo en uno de los cuadros incorrectamente, al cambiar el 
            // -----foco a otro lugar, que aparecca un mensaje de error. Para ello tenemos que programar dentro del mt el
            // -----codigo necesario para comprobar la direccion de correo.

            //DESPUES DE HABER CREADO LA class LanzaFocos implements FocusListener, determinamos que cuadro de texto estara
            // a la escucha.
            LanzaFocos foco1 = new LanzaFocos();// ---instancia de la claseOyente
            cuadro1.addFocusListener(foco1);// -------pone a la escucha al cuadro1

            //AHORA PASAMOS A CODIFICAR LOS MT DE LA CLASE OYENTE para indicar lo que hara cuando este foco tenga el FOCO
            // y lo que hara cuando lo pierda.
        }

        //CLASE OYENTE Y CL INTERNA PARA QUE PUEDA ACCEDER A LOS ATRIBUTOS.
        private class LanzaFocos implements FocusListener{
            //cuando ocurre un evento de tipo 'focus' se construye un objeto de tipo FocusEvent, el cual se almacena
            //en el parametro de uno de los siguientes mts,
            public void focusGained(FocusEvent e){
                
            }

            public void focusLost(FocusEvent e){
                //CAPTURAMOS EL TEXTO QUE SE ESCRIBE EN EL cuadro1
                String email = cuadro1.getText();//almacena el texto escrito en el cuadro de texto.
                boolean conArroba = false;
                int contArrobas = 0;// --------- cuenta el nº de @ puestas en la direccion.
                for(int i = 0; i < email.length(); i++){
                    if(email.charAt(i) == '@'){
                        conArroba = true;
                        contArrobas ++;
                    }
                }
                if(conArroba == true && contArrobas == 1){
                    System.out.println("cuadro1 Has perdido el foco.");
                }
                else{
                    System.out.println("Herror en la direccion de correo.");
                }
            }
        }
    }
}






