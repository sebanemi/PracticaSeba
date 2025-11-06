package parcial2;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerarArchivo02 {
    public static void main(String[] args){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("DATOS02.dat"))) {
            dos.writeByte(4);

            dos.writeByte(4); dos.writeBytes("Juan");
            dos.writeByte(3); dos.writeBytes("Ana");
            dos.writeByte(5); dos.writeBytes("Hola!");
            dos.writeInt(12);

            // 2) Ana → Juan : "Todo bien?" (15)
            dos.writeByte(3); dos.writeBytes("Ana");
            dos.writeByte(4); dos.writeBytes("Juan");
            dos.writeByte(10); dos.writeBytes("Todo bien?");
            dos.writeInt(15);

            // 3) Juan → Ana : "Sí, vos?" (18)
            dos.writeByte(4); dos.writeBytes("Juan");
            dos.writeByte(3); dos.writeBytes("Ana");
            dos.writeByte(8); dos.writeBytes("Sí, vos?");
            dos.writeInt(18);

            // 4) Pedro → Lucía : "¿Estás?" (5)
            dos.writeByte(5); dos.writeBytes("Pedro");
            dos.writeByte(5); dos.writeBytes("Lucía");
            dos.writeByte(7); dos.writeBytes("¿Estás?");
            dos.writeInt(5);

            System.out.println("Archivo DATOS.dat generado correctamente (Modelo 2).");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
