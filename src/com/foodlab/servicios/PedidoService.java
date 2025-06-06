package com.foodlab.servicios;

import com.foodlab.excepciones.StockInsuficienteException;
import com.foodlab.modelo.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoService {
    ArrayList<Pedido> pedidos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ProductoService prods;

    public PedidoService(ProductoService prods) {
        this.prods = prods;
    }

    public void crearPedido() throws StockInsuficienteException {
        Pedido pedido = new Pedido();

        boolean continuar = true;
        while (continuar) {
            agregarProductoAlCarrito(pedido);

            System.out.println("¿Desea añadir más productos al carrito? (SI/NO)");
            String respuesta = scanner.nextLine().trim();
            if (!respuesta.equalsIgnoreCase("SI")) {
                continuar = false;
            }
        }

        pedidos.add(pedido);
        pedido.actualizarStock(ProductoService.productos);

        System.out.println("✅ Pedido creado con éxito.");
    }

    private void agregarProductoAlCarrito(Pedido pedido) throws StockInsuficienteException {
        prods.listarProductos();
        System.out.println("Ingrese el ID del producto que desea agregar al carrito:");
        int idProducto = pedirEntero();
        System.out.println("Ingrese la cantidad que desea adquirir:");
        int cantidad = pedirEntero();
        int stock = prods.stockById(idProducto);

        if (stock == -1) {
            System.out.println("⚠️ No se encontró un producto con ese ID.");
            return;
        }

        if (cantidad > stock) {
            System.out.println();
            throw new StockInsuficienteException("❌ No hay stock suficiente. Stock disponible: " + stock);
        } else {
            pedido.agregarAlCarrito(idProducto, cantidad);
            System.out.println("✅ Producto agregado al carrito.");
        }
    }

    private int pedirEntero() {
        while (true) {
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Por favor, ingrese un número entero.");
            }
        }
    }

    public void listarPedidos(){
        if (pedidos.isEmpty()){
            System.out.println("No hay pedidos para mostrar");
        } else {
            for(Pedido p: pedidos){
                p.mostrarDetalles(ProductoService.productos);
                System.out.println("Total del pedido: $" + p.calcularTotal(ProductoService.productos));
            }

        }
    }
}
