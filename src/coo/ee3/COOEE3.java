
package coo.ee3;

import coo.ee3.Entidades.Libro;
import coo.ee3.Servicios.ServicioLibro;
import java.util.HashSet;
import java.util.Scanner;

public class COOEE3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Bienvenido a su Libreria virtual. Por favor, lea las indicaciones con cuidado.");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Si desea ingresar un libro, indique si. De lo contrario, indique no > ");
        String opc = teclado.next();

        ServicioLibro sl = new ServicioLibro();
        HashSet<Libro> biblioteca = new HashSet();

        int i = 1;
        while (opc.equalsIgnoreCase("si")) {
            biblioteca.add(sl.agregarLibro(i));
            i++;
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("Si desea agregar otro libro, indique si. De lo contrario indique no > ");
            opc = teclado.next();
        }

        if (!biblioteca.isEmpty()) {
            System.out.println("--------------------------------PRESTAMOS---------------------------------------");
            System.out.print("Si desea retirar un libro, indique SI > ");
            String opc2 = teclado.next();
            while (opc2.equalsIgnoreCase("si")) {
                sl.prestamo(biblioteca);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.print("Si desea relizar otro prestamo, indique SI > ");
                opc2 = teclado.next();
            }
            System.out.println("-------------------------------DEVOLUCIONES--------------------------------------");
            System.out.print("Si desea devolver un libro, indique SI > ");
            String opc3 = teclado.next();
            while (opc3.equalsIgnoreCase("si")) {
                sl.devolucion(biblioteca);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.print("Si desea relizar otro prestamo, indique SI > ");
                opc3 = teclado.next();
            }

        } else {
            System.out.println("No es posible realizar operaciones de devolucion y prestamo ya que no hay libros cargados en el sistema.");
        }

        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }

    }

}
