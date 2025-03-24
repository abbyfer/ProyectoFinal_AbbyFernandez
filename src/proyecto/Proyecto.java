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
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarPortada();
    }
    public static void mostrarPortada() {
        JFrame frame=new JFrame("Agenda de Contactos");
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(new Color(173, 216, 230)); 
        // Logo
        JLabel logoLabel=new JLabel();
        ImageIcon icon=new ImageIcon(Proyecto.class.getResource("/logo/logo.png"));
        Image img=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(img));
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        // Titulo
        JLabel titulo = new JLabel("Agenda De Contactos", SwingConstants.CENTER);
        titulo.setFont(new Font("Monospaced", Font.BOLD, 32));
        titulo.setForeground(Color.DARK_GRAY);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        // Boton
        JButton iniciar = new JButton("Iniciar");
        iniciar.setFont(new Font("Monospaced", Font.BOLD, 24));
        iniciar.setBackground(new Color(0, 51, 102));
        iniciar.setForeground(Color.WHITE);
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Proyecto();
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(173, 216, 230));
        panelBoton.add(iniciar);
        panelPrincipal.add(logoLabel, BorderLayout.NORTH);
        panelPrincipal.add(titulo, BorderLayout.CENTER);
        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);
        frame.add(panelPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Proyecto() {
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
            System.out.println("7) Salir");
            System.out.print("Ingrese su opcion: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    listaContactos.agregarContacto();
                    break;
                case 2:
                    listaContactos.editarContacto();
                    break;
                case 3:
                    listaContactos.buscarContacto();
                    break;
                case 4:
                    listaContactos.eliminarContacto();
                    break;
                case 5:
                    listaContactos.mostrarContactos();   
                    break;
                case 6:
                    listaContactos.elegirEmergencia();
                    break;
                default:
                    listaContactos.contarRegresivo(5);
                    System.out.println("Gracias por usar la agenda de contactos virtual");
                    break;
            }
        } while (op != 7);
    }
}
