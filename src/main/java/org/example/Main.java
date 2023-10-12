package org.example;

import java.io.File;

import static org.example.CombinarCorrespondencia.combinarCorrespondencia;


/**
 * Esta clase representa la clase principal.
 * Combina los datos de un archivo CSV con una plantilla y genera archivos de salida en la carpeta que hemos llamado
 * "Salida".
 */

public class Main {

    /**
     * @param args Argumentos de línea de comandos (no se esperan argumentos en este caso).
     */

    public static void main(String[] args) {

        String salidaFolderPath = "Salida";

        File salidaFolder = new File(salidaFolderPath);

        if (!salidaFolder.exists()) {

            boolean created = salidaFolder.mkdir();
            if (created) {
                System.out.println("Carpeta 'Salida' creada correctamente.");
            } else {
                System.out.println("Error al crear la carpeta 'Salida'.");
            }
        } else {
            File[] files = salidaFolder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            System.out.println("Carpeta 'Salida' vaciada con exito.");
        }


        combinarCorrespondencia("data.csv", "template.txt");

    }
}