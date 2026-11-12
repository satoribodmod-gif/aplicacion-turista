package ui;

import data.GestorDatos;
import model.Tour;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Path ruta = Path.of("src", "main", "resources", "tours.txt");
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

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }

}
