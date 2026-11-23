package data;

import model.Direccion;
import model.Empleado;
import model.Tour;
import exception.RutInvalidoException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.nio.file.Files;

public class GestorDatos {

    public ArrayList<Tour> leerTours(Path ruta) throws IOException {
        ArrayList<Tour> tours = new ArrayList<>();

        try (BufferedReader lector = Files.newBufferedReader(ruta)) {
            String linea;

            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null){

                numeroLinea++;

                if (linea.isBlank()) {
                    System.out.println("Línea " + numeroLinea + " vacía; se omite.");
                    continue;
                }

                String[] datos = linea.split(";", -1);

                if (datos.length != 4) {
                    System.out.println("Línea " + numeroLinea + " inválida: se esperaban 4 campos; se omite.");
                    continue;
                }

                try {

                    int precio = Integer.parseInt(datos[3].trim().replace(".", ""));

                    Tour tour = new Tour(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            precio
                    );
                    tours.add(tour);

                } catch (NumberFormatException e) {
                    System.out.println("Línea " + numeroLinea + " tiene un precio inválido; se omite.");
                }

            }
        }
        return tours;
    }

    public ArrayList<Empleado> leerEmpleados(Path ruta) throws IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (BufferedReader lector = Files.newBufferedReader(ruta)) {
            String linea;

            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {

                numeroLinea++;

                if (linea.isBlank()) {
                    System.out.println("Línea " + numeroLinea + " vacía; se omite.");
                    continue;
                }



                String[] datos = linea.split(";", -1);

                if (datos.length != 9) {
                    System.out.println("Línea " + numeroLinea + " inválida: se esperaban 9 campos; se omite.");
                    continue;
                }

                boolean tieneCampoVacio = false;

                for (String dato : datos) {
                    if (dato.isBlank()) {
                        tieneCampoVacio = true;
                        break;
                    }
                }

                if (tieneCampoVacio) {
                    System.out.println("Línea " + numeroLinea + " contiene campos vacíos; se omite.");
                    continue;
                }


                try {
                    Direccion direccion = new Direccion(
                            datos[3].trim(),
                            datos[4].trim(),
                            datos[5].trim(),
                            datos[6].trim()
                    );

                    Empleado empleado = new Empleado(
                            datos[0].trim(),
                            datos[1].trim(),
                            datos[2].trim(),
                            direccion,
                            datos[7].trim(),
                            datos[8].trim()
                    );
                    empleados.add(empleado);
                } catch (RutInvalidoException e) {
                    System.out.println("Línea " + numeroLinea + " omitida por RUT inválido: " + e.getMessage());
                }

            }

        }
        return empleados;
    }

}
