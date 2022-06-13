

package coo.ee3.Servicios;

import coo.ee3.Entidades.Libro;
import java.util.HashSet;
import java.util.Scanner;

public class ServicioLibro {

    Scanner teclado = new Scanner(System.in).useDelimiter("\n");

    public Libro agregarLibro(int i) {
        Libro l1 = new Libro();
        System.out.print("Ingrese el titulo del libro " + i + " > ");
        l1.setTitulo(teclado.next());
        System.out.print("Ingrese el autor del libro " + i + " > ");
        l1.setAutor(teclado.next());
        System.out.print("Ingrese la cantidad de ejemeplares disponibles del libro " + i + " > ");
        l1.setNumeroDeEjemplares(teclado.nextInt());
        System.out.print("Ingrese la cantidad de ejemplares prestados del libro " + i + " > ");
        l1.setNumeroDeEjemplaresPrestados(teclado.nextInt());
        return l1;
    }

    public HashSet prestamo(HashSet<Libro> biblioteca){
        System.out.print("Indique el nombre del libro del que desea pedir > ");
        String libroPrestamo = teclado.next();
        for (Libro aux : biblioteca) {
            if (libroPrestamo.equals(aux.getTitulo())) {
                System.out.println("El libro se encuentra en la biblioteca.");
                System.out.print("Por favor, indique la cantidad de ejemplares que desea retirar > ");
                int cantidad = teclado.nextInt();
                if (cantidad <=aux.getNumeroDeEjemplares()) {
                    System.out.println("Ud. ha retirado " + cantidad + " ejemplare/s del libro " + aux.getTitulo());
                    aux.setNumeroDeEjemplares(aux.getNumeroDeEjemplares()-cantidad);
                    aux.setNumeroDeEjemplaresPrestados(aux.getNumeroDeEjemplaresPrestados()+cantidad);
                } else {
                    System.out.println("No es posible realizar dicha operacion ya que solo hay " + aux.getNumeroDeEjemplares() + " libro/s de dicho titulo disponible/s.");
                }                
            }
        }
        return biblioteca;
    }

    public HashSet devolucion(HashSet<Libro> biblioteca) {
        System.out.print("Indique el nombre del libro del que desea devolver > ");
        String libroDevolucion = teclado.next();
        for (Libro aux : biblioteca) {
            if (libroDevolucion.equals(aux.getTitulo())) {
                System.out.println("El libro se encuentra en la biblioteca.");
                System.out.print("Por favor, indique la cantidad de ejemplares que desea devolver > ");
                int cantidad = teclado.nextInt();
                if (cantidad >= aux.getNumeroDeEjemplaresPrestados()) {
                    System.out.println("Ud. ha devuelto " + cantidad + " ejemplare/s del libro " + aux.getTitulo());
                    aux.setNumeroDeEjemplares(aux.getNumeroDeEjemplares() + cantidad);
                    aux.setNumeroDeEjemplaresPrestados(aux.getNumeroDeEjemplaresPrestados() - cantidad);
                } else {
                    System.out.println("No es posible realizar dicha operacion ya que esta tratando de devolver mas ejemplares de los que se han prestado.");
                }
            }
        }
        return biblioteca;
    }

}
