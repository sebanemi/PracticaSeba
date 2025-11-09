package parcial2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gpt05_Cliente {
    private String nombre;
    private int cantPedidos;
    private List<Gpt05_Pedido> pedidosList;
    private float gastoTotal;

    public Gpt05_Cliente() {
        this.nombre = "";
        this.cantPedidos = 0;
        this.pedidosList = new ArrayList<>();
        this.gastoTotal = 0;
    }

    public Gpt05_Cliente(FileInputStream fis) throws IOException {
        int n = fis.read();
        if (n == -1) {
            throw new IOException("Error nombre cliente");
        }
        byte[] nombreBytes = new byte[n];
        fis.read(nombreBytes);

        cantPedidos = fis.read();

        if (cantPedidos == -1) {
            throw new IOException("Error cantidad pedidos");
        }

        nombre = new String(nombreBytes, StandardCharsets.UTF_8);
        gastoTotal = 0;
        pedidosList = new ArrayList<Gpt05_Pedido>();
        for (int i = 0; i < cantPedidos; i++) {
            Gpt05_Pedido pedido = new Gpt05_Pedido(fis);
            pedidosList.add(pedido);
            gastoTotal += pedido.getCantPedido()*pedido.getPrecio();
        }
        pedidosList.sort(Comparator.comparingDouble(Gpt05_Pedido::getPrecio));
        Collections.reverse(pedidosList);
    }

    public String getNombre() {
        return nombre;
    }
    public int getCantPedidos() {
        return cantPedidos;
    }
    public List<Gpt05_Pedido> getPedidosList() {
        return pedidosList;
    }
    public float getGastoTotal() {
        return gastoTotal;
    }
}
