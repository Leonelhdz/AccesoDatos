package org.example;

import java.io.*;

/**
 * Esta clase tiene como principal funcionalidad combinar correspondencia a partir de dos archivos adjuntados en el
 * proyecto un archivo.csv y un template.txt
 */
public class CombinarCorrespondencia {
    /**
     * Este metodo se encarga de combinar la correspondencia utilizando los datos de los archivos csv y txt.
     *
     * @param data Esta es la ruta al archivo que contiene detalladamente los datos de los clientes. (data.csv)
     * @param template  Esta es la ruta al archivo que contiene la correspondencia a modificar. (template.txt)
     */
    public static void combinarCorrespondencia(String data, String template) {
        String linea = "";
        String separador = ",";
        File archivodata = new File(data);

        try (BufferedReader br = new BufferedReader(new FileReader(archivodata))) {

            while ((linea = br.readLine()) != null) {
                String[] datosCliente = linea.split(separador);

                if (datosCliente.length >= 5) {
                    String codigoCliente = datosCliente[0];
                    String empresa = datosCliente[1];
                    String localidad = datosCliente[2];
                    String correo = datosCliente[3];
                    String responsable = datosCliente[4];

                    String datosTemplate = "";
                    try (BufferedReader templateReader = new BufferedReader(new FileReader(template))) {
                        String templateLine;
                        while ((templateLine = templateReader.readLine()) != null) {
                            datosTemplate += templateLine + "\n";
                        }
                    }

                    datosTemplate = datosTemplate.replace("%%2%%", localidad);
                    datosTemplate = datosTemplate.replace("%%3%%", correo);
                    datosTemplate = datosTemplate.replace("%%4%%", empresa);
                    datosTemplate = datosTemplate.replace("%%5%%", responsable);


                    String outputFileName = "Salida" + File.separator + "Plantilla-" + codigoCliente + ".txt";
                    try (FileWriter fileWriter = new FileWriter(outputFileName)) {
                        fileWriter.write(datosTemplate);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Proceso Completado, Se han creado los archivos para cada cliente en la carpeta SALIDA");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}