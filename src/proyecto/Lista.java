/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author afern
 */
import javax.swing.*;
import java.util.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Lista {
    private List<Contacto> contactos = new ArrayList<>();

    
     public void agregarContacto() {
        String nombre=JOptionPane.showInputDialog("Nombre:");
        String telefono = JOptionPane.showInputDialog("Telefono:");
        String email = JOptionPane.showInputDialog("Email:");
        String direccion = JOptionPane.showInputDialog("Direccion:");

        Contacto nuevo = new Contacto(nombre, telefono, email, direccion);
        contactos.add(nuevo);
        JOptionPane.showMessageDialog(null, "Contacto agregado exitosamente!");
    }

     public void editarContacto() {
    String clave = JOptionPane.showInputDialog("Nombre del contacto:");
    for (int i=0;i<contactos.size();i++){
        Contacto actual=contactos.get(i);
        if (actual.getNombre().equalsIgnoreCase(clave)){
            String nuevoTel = JOptionPane.showInputDialog("Nuevo telefono:", actual.getTelefono());
            String nuevoE = JOptionPane.showInputDialog("Nuevo email:", actual.getEmail());
            String nuevaD = JOptionPane.showInputDialog("Nueva direccion:", actual.getDireccion());
            actual.setTelefono(nuevoTel);
            actual.setEmail(nuevoE);
            actual.setDireccion(nuevaD);
            JOptionPane.showMessageDialog(null, "Contacto actualizado");
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Contacto no encontrado");
}

  
}
