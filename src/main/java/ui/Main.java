package ui;

import data.GestorDatos;
import model.Tour;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import model.Empleado;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Path ruta = Path.of("src", "main", "resources", "tours.txt");
        Path rutaPersonal = Path.of("src", "main", "resources", "personal.txt");
        GestorDatos gestor = new GestorDatos();

        try {
            ArrayList<Tour> tours = gestor.leerTours(ruta);

            System.out.println("Todos los tours: ");
            for (Tour tour : tours) {
                System.out.println(tour);
            }

            System.out.println("\nTours gastronómicos: ");
            for (Tour tour : tours) {
                if (tour.getTipo().equalsIgnoreCase("Gastronómico")) {
                    System.out.println(tour);
                }
            }

            ArrayList<Empleado> empleados = gestor.leerEmpleados(rutaPersonal);

            System.out.println("\nPersonal de Llanquihue Tour:");
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }

            System.out.println("\nEmpleados con cargo de guía: ");
            for (Empleado empleado : empleados) {
                if (empleado.getCargo().equalsIgnoreCase("Guía turístico")) {
                    System.out.println(empleado);
                }
            }

            Scanner entrada = new Scanner(System.in);
            System.out.println("\nIngrese el nombre que desea buscar: ");
            String nombreBuscado = entrada.nextLine().trim();

            boolean encontrado = false;
            for (Empleado empleado : empleados) {
                if (empleado.getNombres().equalsIgnoreCase(nombreBuscado)) {
                    System.out.println(empleado);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró una persona con ese nombre.");
            }


        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

}
