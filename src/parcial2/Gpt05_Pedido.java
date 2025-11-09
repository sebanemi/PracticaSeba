package parcial2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class Gpt05_Pedido {
    private String nombrePedido;
    private int cantPedido;
    private float precio;

    public Gpt05_Pedido(FileInputStream fis)throws IOException {
        int m = fis.read();
        if (m == -1) {
            throw new IOException("Error nombre pedido");
        }
        byte[] nombreBytes = new byte[m];
        fis.read(nombreBytes);

        byte[] cantBytes = new byte[2];
        fis.read(cantBytes);
        cantPedido = ((cantBytes[0] & 0xFF) << 8) | (cantBytes[1] & 0xFF);

        byte[] precioBytes = new byte[4];
        precio = fis.read(precioBytes);
        precio = ByteBuffer.wrap(precioBytes).getFloat();

        this.nombrePedido = new String(nombreBytes, StandardCharsets.UTF_8);
    }

    public String getNombrePedido() {
        return nombrePedido;
    }
    public int getCantPedido() {
        return cantPedido;
    }
    public float getPrecio() {
        return precio;
    }
}
