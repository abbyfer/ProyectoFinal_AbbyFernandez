/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
/**
 *
 * @author afern
 */
public class Proyecto {
    private Lista listaContactos;
    static Scanner sc=new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mostrarPortada();

        
    }

    public static void mostrarPortada() {
    JFrame frame = new JFrame("Agenda Personal");
    frame.setSize(800, 600);
    frame.setLayout(new BorderLayout());

    JLabel titulo = new JLabel("Agenda De Contactos", SwingConstants.CENTER);
    titulo.setFont(new Font("Monospaced", Font.BOLD, 32));
    frame.add(titulo, BorderLayout.CENTER);

    JButton iniciar = new JButton("Entrar a la Agenda");
    iniciar.setFont(new Font("Monospaced", Font.BOLD, 24)); // 👈 Fuente Monospaced
    iniciar.setBackground(new Color(40, 180, 99));
    iniciar.setForeground(Color.WHITE);
    iniciar.addActionListener(e -> {
        frame.dispose();
        new Proyecto();
    });
    
    JPanel panelBoton = new JPanel();
    panelBoton.add(iniciar);
    frame.add(panelBoton, BorderLayout.SOUTH);

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}
    public Proyecto(){
        listaContactos = new Lista();
        iniciarAgenda();
    }
    private void iniciarAgenda() {
        int op;
        do {
            System.out.println("-------Menu--------");
            System.out.println("1) Agregar contacto");
            System.out.println("2) Editar contacto");
            System.out.println("3) Buscar contacto");
            System.out.println("4) Eliminar contacto");
            System.out.println("5) Mostrar mis contactos");
            System.out.println("6) Elegir contacto de emergencia");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();

            switch (op){
                case 1:
                   listaContactos.agregarContacto();

                    break;
                case 2:
                    listaContactos.editarContacto();

                    break;
                case 3:

                    break;
                case 4:


                    break;
                case 5: 

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Gracias por usar la agenda virtual");
            }

        } while (op!=7);
    }    
}
