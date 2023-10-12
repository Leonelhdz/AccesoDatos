package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinarCorrespondenciaTest {
    @Test
    void pruebaFaltaDeCamposEnArchivoCSV() {
        String archivoDatos = "dataIncompleto.csv";
        String plantilla = "template.txt";

        assertDoesNotThrow(() -> CombinarCorrespondencia.combinarCorrespondencia(archivoDatos, plantilla));
    }

    @Test
    void pruebaArchivoCSVVacio() {
        String archivoDatos = "dataVacio.csv";
        String plantilla = "template.txt";

        assertDoesNotThrow(() -> CombinarCorrespondencia.combinarCorrespondencia(archivoDatos, plantilla));
    }

    @Test
    void pruebaMarcadoresInvalidosEnPlantilla() {
        String archivoDatos = "data.csv";
        String plantilla = "templateMarcadorInvalido.txt";

        assertDoesNotThrow(() -> CombinarCorrespondencia.combinarCorrespondencia(archivoDatos, plantilla));
    }
}