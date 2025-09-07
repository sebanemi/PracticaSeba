package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.*;

public class GuardarAgenda {
    public static void guardarAgenda(List<Persona> personas, String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            // Posicionarse al final para no pisar lo que ya existe
            raf.seek(raf.length());

            raf.writeBytes("########### AGENDA ###########\n\n");

            int contador = 1;
            for (Persona persona : personas) {
                raf.writeBytes("Persona " + contador + ":\n");
                Map<String, String> mapa = persona.getMapa();
                for (Map.Entry<String, String> entry : mapa.entrySet()) {
                    raf.writeBytes("  " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
                raf.writeBytes("---------------------------\n");
                contador++;
            }

            raf.writeBytes("######### FIN #########\n");
            raf.writeBytes("\n"); // salto extra para separar sesiones de guardado

            System.out.println("Agenda guardada en " + nombreArchivo + " con RandomAccessFile.");
        } catch (IOException e) {
            System.out.println("Error al guardar agenda: " + e.getMessage());
        }
    }
}

