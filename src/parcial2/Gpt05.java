package parcial2;

/*
1 byte  → t: cantidad de clientes.

Para cada cliente:
    1 byte → longitud del nombre del cliente (n)
    n bytes → caracteres del nombre
    1 byte → cantidad de pedidos (p)

    Para cada pedido:
        1 byte → longitud del producto (m)
        m bytes → caracteres del nombre del producto
        2 bytes → cantidad pedida (entero sin signo)
        4 bytes → precio unitario (float)
 */

import java.io.FileInputStream;
import java.util.*;

public class Gpt05 {
    public static void mayorGasto(List<Gpt05_Cliente> clientes){
        float mayor=0;
        String nombre = "";
        for (Gpt05_Cliente cliente : clientes) {
            if(cliente.getGastoTotal()>mayor){
                mayor=cliente.getGastoTotal();
                nombre=cliente.getNombre();
            }
        }

        System.out.println("Mayor: "+ nombre + ", " +  mayor);
    }
    public static List<Gpt05_Cliente> superados(List<Gpt05_Cliente> clientes){
        List<Gpt05_Cliente> superados = new LinkedList<>();
        for (Gpt05_Cliente cliente : clientes) {
            if(cliente.getGastoTotal()>1000){
                superados.add(cliente);
            }
        }
        superados.sort(Comparator.comparingDouble(Gpt05_Cliente::getGastoTotal));
        return superados;
    }

    public static void main(String[] args){
        String archivo = "DATOS05.dat";
        List<Gpt05_Cliente> clientes = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(archivo)){
            int t = fis.read();
            if(t == -1){
                System.out.println("Error al leer cantidad de clientes");
                return;
            }

            for(int i = 0; i < t; i++){
                Gpt05_Cliente cliente = new Gpt05_Cliente(fis);
                clientes.add(cliente);
            }

            System.out.println("Clientes:");
            System.out.println("-------------------");
            for(Gpt05_Cliente cliente : clientes){
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("  Pedidos: ");
                for(Gpt05_Pedido pedido : cliente.getPedidosList()){
                    System.out.println("    Producto: " + pedido.getNombrePedido());
                    System.out.println("      Cantidad: " + pedido.getCantPedido());
                    System.out.println("      Precio: " + pedido.getPrecio());
                }
            }
            System.out.println("\n-------------------");
            mayorGasto(clientes);
            System.out.println("-------------------\n");

            System.out.println("Clientes más gastadores: ");
            List<Gpt05_Cliente> superados = superados(clientes);
            for(Gpt05_Cliente cliente : superados){
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("  Gasto total: " + cliente.getGastoTotal());
                System.out.println("  Pedidos: ");
                for(Gpt05_Pedido pedido : cliente.getPedidosList()){
                    System.out.println("    Producto: " + pedido.getNombrePedido());
                    System.out.println("      Cantidad: " + pedido.getCantPedido());
                    System.out.println("      Precio: " + pedido.getPrecio());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
