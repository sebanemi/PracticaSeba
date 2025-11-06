package parcial2;

import java.io.*;

public class GenerarArchivo01 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("DATOS01.dat"))) {

            dos.writeByte(5); // cantidad de productos

            // 1) Yogur - Lácteos - 350 - D
            dos.writeByte(5); dos.writeBytes("Yogur");
            dos.writeByte(7); dos.writeBytes("Lácteos");
            dos.writeInt(350);
            dos.writeByte('D');

            // 2) Televisor - Electrónica - 250000 - D
            dos.writeByte(9); dos.writeBytes("Televisor");
            dos.writeByte(11); dos.writeBytes("Electrónica");
            dos.writeInt(250000);
            dos.writeByte('D');

            // 3) Mouse - Electrónica - 15000 - N
            dos.writeByte(5); dos.writeBytes("Mouse");
            dos.writeByte(11); dos.writeBytes("Electrónica");
            dos.writeInt(15000);
            dos.writeByte('N');

            // 4) Leche - Lácteos - 290 - D
            dos.writeByte(5); dos.writeBytes("Leche");
            dos.writeByte(7); dos.writeBytes("Lácteos");
            dos.writeInt(290);
            dos.writeByte('D');

            // 5) Queso - Lácteos - 1200 - D
            dos.writeByte(5); dos.writeBytes("Queso");
            dos.writeByte(7); dos.writeBytes("Lácteos");
            dos.writeInt(1200);
            dos.writeByte('D');

            System.out.println("Archivo DATOS.dat generado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

