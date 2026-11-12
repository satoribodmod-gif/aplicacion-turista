package data;

import model.Tour;
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

}
