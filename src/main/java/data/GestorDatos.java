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

            while ((linea = lector.readLine()) != null){
                String[] datos = linea.split(";");

                Tour tour = new Tour(
                        datos[0].trim(),
                        datos[1].trim(),
                        datos[2].trim(),
                        Integer.parseInt(datos[3].trim())
                );
                tours.add(tour);

            }
        }
        return tours;
    }

    public ArrayList<Empleado> leerEmpleados(Path ruta) throws IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();

        try (BufferedReader lector = Files.newBufferedReader(ruta)) {
            String linea;

            while ((linea = lector.readLine()) != null) {

                if (linea.isBlank()) {
                    continue;
                }

                String[] datos = linea.split(";", -1);

                if (datos.length != 9) {
                    System.out.println("Registro ignorado: se esperaban 9 campos.");
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
                    System.out.println("Registro omitido por RUT inválido: " + e.getMessage());
                }

            }

        }
        return empleados;
    }

}
