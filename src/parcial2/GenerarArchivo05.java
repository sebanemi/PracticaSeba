package parcial2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GenerarArchivo05 {
    public static void main(String[] args) {
        String archivo = "DATOS05.dat";

        try (FileOutputStream fos = new FileOutputStream(archivo)) {

            // Cantidad de clientes
            fos.write(3); // t = 3 clientes

            // === Cliente 1: Juan ===
            escribirString(fos, "Juan"); // nombre
            fos.write(2); // cantidad de pedidos = 2

            // Pedido 1
            escribirString(fos, "Teclado");
            escribirShort(fos, 1); // cantidad = 1
            escribirFloat(fos, 250.0f); // precio = 250.0

            // Pedido 2
            escribirString(fos, "Mouse");
            escribirShort(fos, 2); // cantidad = 2
            escribirFloat(fos, 150.0f); // precio = 150.0

            // === Cliente 2: Ana ===
            escribirString(fos, "Ana");
            fos.write(1); // cantidad de pedidos = 1

            // Pedido 1
            escribirString(fos, "Monitor");
            escribirShort(fos, 1);
            escribirFloat(fos, 1200.0f);

            // === Cliente 3: Pedro ===
            escribirString(fos, "Pedro");
            fos.write(2); // cantidad de pedidos = 2

            // Pedido 1
            escribirString(fos, "Cable HDMI");
            escribirShort(fos, 3);
            escribirFloat(fos, 90.0f);

            // Pedido 2
            escribirString(fos, "Parlantes");
            escribirShort(fos, 1);
            escribirFloat(fos, 300.0f);

            System.out.println("Archivo " + archivo + " generado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribe una cadena en formato: [1 byte longitud][n bytes UTF-8]
    private static void escribirString(FileOutputStream fos, String texto) throws IOException {
        byte[] bytes = texto.getBytes(StandardCharsets.UTF_8);
        fos.write(bytes.length);
        fos.write(bytes);
    }

    // Escribe un short (2 bytes)
    private static void escribirShort(FileOutputStream fos, int valor) throws IOException {
        fos.write((valor >> 8) & 0xFF);
        fos.write(valor & 0xFF);
    }

    // Escribe un float (4 bytes IEEE 754)
    private static void escribirFloat(FileOutputStream fos, float valor) throws IOException {
        int bits = Float.floatToIntBits(valor);
        fos.write((bits >> 24) & 0xFF);
        fos.write((bits >> 16) & 0xFF);
        fos.write((bits >> 8) & 0xFF);
        fos.write(bits & 0xFF);
    }
}

