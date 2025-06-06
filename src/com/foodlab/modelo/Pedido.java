package com.foodlab.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private static int contadorPedidos = 0;

    private final int id;
    private final Map<Integer, Integer> carrito;

    public Pedido(){
        contadorPedidos++;
        this.id = contadorPedidos;
        this.carrito = new HashMap<>();
    }

    public void agregarAlCarrito(int idProducto, int cantidad) {
        if (carrito.containsKey(idProducto)) {
            carrito.put(idProducto, carrito.get(idProducto) + cantidad);
        } else {
            carrito.put(idProducto, cantidad);
        }
    }

    public void quitarDelCarrito(int idProducto, int cantidad) {
        if (carrito.containsKey(idProducto)) {
            int cantidadActual = carrito.get(idProducto);

            if (cantidadActual <= cantidad) {
                carrito.remove(idProducto);
            } else {
                carrito.put(idProducto, cantidadActual - cantidad);
            }
        }
    }

    public double calcularTotal(ArrayList<Producto> productos) {
        double total = 0;

        for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
            int idProducto = entry.getKey();
            int cantidad = entry.getValue();

            for (Producto p : productos) {
                if (p.getId() == idProducto) {
                    total += p.getPrecio() * cantidad;
                    break;
                }
            }
        }

        return total;
    }

    public void mostrarDetalles(ArrayList<Producto> productos){
        System.out.println(">>>>>>>>>> Detalle del pedido <<<<<<<<<<");
        System.out.println("Id del pedido: " + this.id);
        System.out.println("Productos en el carrito: ");
        for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
            int idProducto = entry.getKey();
            int cantidad = entry.getValue();

            for (Producto p : productos) {
                if (p.getId() == idProducto) {
                    System.out.println(p.getNombre() + " - cantidad: " + cantidad);
                    break;
                }
            }
        }
    }

    public void actualizarStock(ArrayList<Producto> productos){
        for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
            int idProducto = entry.getKey();
            int cantidad = entry.getValue();

            for (Producto p : productos) {
                if (p.getId() == idProducto) {
                    p.setStock(p.getStock() - cantidad);
                    break;
                }
            }
        }
    }
}
