package parcial2;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerarArchivo04 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("DATOS04.dat"))) {
            byte t = 3; // cantidad de personas
            dos.writeByte(t);

            // Persona 1: Juan
            String nombre1 = "Juan";
            dos.writeByte(nombre1.length());
            dos.writeBytes(nombre1);
            byte amigos1 = 2;
            dos.writeByte(amigos1);
            String[] amigosJuan = {"María", "Pedro"};
            for (String amigo : amigosJuan) {
                dos.writeByte(amigo.length());
                dos.writeBytes(amigo);
            }

            // Persona 2: María
            String nombre2 = "María";
            dos.writeByte(nombre2.length());
            dos.writeBytes(nombre2);
            byte amigos2 = 1;
            dos.writeByte(amigos2);
            String[] amigosMaria = {"Juan"};
            for (String amigo : amigosMaria) {
                dos.writeByte(amigo.length());
                dos.writeBytes(amigo);
            }

            // Persona 3: Pedro
            String nombre3 = "Pedro";
            dos.writeByte(nombre3.length());
            dos.writeBytes(nombre3);
            byte amigos3 = 0;
            dos.writeByte(amigos3);

            System.out.println("Archivo RED.dat generado correctamente ✅");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

