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
import java.util.Random; 

public class Lista {
    static Random ra=new Random();
    private List<Contacto> contactos=new ArrayList<>();

    //agrega contacto
    public void agregarContacto(){
        String nombre=JOptionPane.showInputDialog("Nombre:");
        String telefono=JOptionPane.showInputDialog("Telefono:");
        String email=JOptionPane.showInputDialog("Email:");
        String direccion =JOptionPane.showInputDialog("Direccion:");

        Contacto nuevo = new Contacto(nombre, telefono, email, direccion);
        contactos.add(nuevo);
        JOptionPane.showMessageDialog(null, "Contacto agregado!");
    }
    //edita los datos del contacto, muestra cada uno de los datos y permite editarlsos
    public void editarContacto() {
    String clave = JOptionPane.showInputDialog("Nombre del contacto:");
    for (int i=0;i<contactos.size();i++){
        Contacto actual=contactos.get(i);
        if (actual.getNombre().equalsIgnoreCase(clave)){
            String nuevoTel=JOptionPane.showInputDialog("Nuevo telefono:", actual.getTelefono());
            String nuevoE=JOptionPane.showInputDialog("Nuevo email:", actual.getEmail());
            String nuevaD=JOptionPane.showInputDialog("Nueva direccion:", actual.getDireccion());
            actual.setTelefono(nuevoTel);
            actual.setEmail(nuevoE);
            actual.setDireccion(nuevaD);
            JOptionPane.showMessageDialog(null, "Contacto actualizado");
            return;
        }
        
    }
    JOptionPane.showMessageDialog(null, "Contacto no encontrado");
    }
    //busca el contacto solicitado por el usuario y lo muestra
    public void buscarContacto(){
        String clave=JOptionPane.showInputDialog("Buscar por nombre o teléfono:");
        for (Contacto c:contactos) {
            if (c.getNombre().equalsIgnoreCase(clave) || c.getTelefono().equals(clave)) {
                JOptionPane.showMessageDialog(null, c.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contacto no encontrado");
    }
    //solicita el contacto deseado a borrar y lo elimina
    public void eliminarContacto() {
        String clave = JOptionPane.showInputDialog("Nombre del contacto a eliminar:");
        for (int i =0;i<contactos.size();i++) {
            if (contactos.get(i).getNombre().equalsIgnoreCase(clave)) {
                contactos.remove(i);
                JOptionPane.showMessageDialog(null, "Contacto eliminado");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Contacto no encontrado");
    }
    //muestra todos los contactos agregados
    public void mostrarContactos() {
         if (contactos.size() ==0) {
            JOptionPane.showMessageDialog(null, "No hay contactos registrados.");
            return;
        }
        String[][] matriz=new String[contactos.size()][4];
        for (int i=0; i < contactos.size();i++){
            Contacto contactoActual=contactos.get(i);
            matriz[i][0]=contactoActual.getNombre();
            matriz[i][1]=contactoActual.getTelefono();
            matriz[i][2]=contactoActual.getEmail();
            matriz[i][3]=contactoActual.getDireccion();
        }
        String[] etiquetas = {"Nombre", "Telefono", "Email", "Direccion"};
        String resultado = "Lista de contactos en matriz:\n\n";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado = resultado + etiquetas[j] + ": " + matriz[i][j] + "\n";
            }
            resultado = resultado + "------------------------\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    //aleatoriamente de los contactoos agregados elige uno como contacto de emergencia
    public void elegirEmergencia() {
        if (contactos.size()==0) {
            JOptionPane.showMessageDialog(null, "No hay contactos registrados");
            return;
        }
        String lista="Contactos registrados: ";
        for (int i=0;i<contactos.size(); i++) {
            Contacto c=contactos.get(i);
            lista +=(i+1) + ") " + c.getNombre() + "\n";
    }
        int indice=ra.nextInt(contactos.size());
        Contacto emergencia=contactos.get(indice);
        JOptionPane.showMessageDialog(null, lista + "Contacto de emergencia:" + emergencia.toString());
    }
    //metodo recursivo de conteo para salir del programa
     public void contarRegresivo(int n) {
        if (n==0) {
            return;
        }
        System.out.println("Contando: "+n);
        contarRegresivo(n-1);
    }
}
