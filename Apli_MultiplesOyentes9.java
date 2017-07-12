import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Un objetoFuente pasa un evento a varios objetosOyentes.
 * un objetoFuente, 'Nuevo' crea una ventana cada vez que es pulsado.
 * otro objetoFuente, 'CerrarTodo' cierra todas las ventanas creada.
 * franciscoJavier
 */
public class Apli_MultiplesOyentes9 extends JFrame
{
    // JButton cerrar = new JButton("Cerrar todo");
    //PARA QUE JAVA EJECUTE EL PROGRAMA.
    
    public static void main(String[] args){
        Apli_MultiplesOyentes9 marco = new Apli_MultiplesOyentes9();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Constructor for objects of class Apli_MultiplesOyentes
     */
    public Apli_MultiplesOyentes9()
    {
        Lamina lamina = new Lamina();
        add(lamina);
        
        setBounds(800, 30, 500, 200);
        setVisible(true);
        setTitle("Dos botones");
        //instanciamos la Lamina
        
        Toolkit icono = Toolkit.getDefaultToolkit();
        Image imagen = icono.getImage("../icono2.gif");
        setIconImage(imagen);
    }

    //CLASE INTERNA PARA PONER UNA LAMINA SOBRE EL MARCO Y DIBUJAR DOS BOTONES.
    private class Lamina extends JPanel
    {
        JButton nuevo = new JButton("Nueva");
        JButton cerrar = new JButton("Cerrar todo");
        public Lamina(){
            add(nuevo);
            add(cerrar);
            setLayout(null);
            nuevo.setBounds(350, 10, 105, 25);
            cerrar.setBounds(350, 40, 105, 25);
            //realiza el evento codificado en actionPerformed(ActionEvent e) cuando es pulsado el boton 'Nueva'
            Oyente oyente = new Oyente();
            nuevo.addActionListener(oyente);
        }

        //CLASE INTERNA PARA CREAR UN OBJETO OYENTE
        private class Oyente implements ActionListener{

            public void actionPerformed(ActionEvent e){
                Crea_Ventana ventana = new Crea_Ventana(cerrar);
            }
        }
    }
}




