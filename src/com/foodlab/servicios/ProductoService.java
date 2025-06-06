package com.foodlab.servicios;

import com.foodlab.modelo.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProductoService {
    public static ArrayList<Producto> productos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ProductoService() {
        inicializarCatalogo();
    }

    private void inicializarCatalogo() {
        productos.addAll(Arrays.asList(
                new Producto("Hamburguesa completa", 6000, 120),
                new Producto("Cono de papas fritas", 2000, 600),
                new Producto("Ensalada Caesar", 3000, 50),
                new Producto("Cono de aros de cebolla", 2500, 50),
                new Producto("Wrap de verduras", 4000, 100)
        ));
    }

    public void agregarProducto(){
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine().trim();

        double precio;
        while (true) {
            System.out.println("Ingrese el precio del producto:");
            String input = scanner.nextLine().trim();
            try {
                precio = Double.parseDouble(input);
                if (precio < 0) {
                    System.out.println("⚠️ El precio no puede ser negativo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número decimal válido.");
            }
        }

        int stock;
        while (true) {
            System.out.println("Ingrese el stock del producto:");
            String input = scanner.nextLine().trim();
            try {
                stock = Integer.parseInt(input);
                if (stock < 0) {
                    System.out.println("⚠️ El stock no puede ser negativo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número entero válido.");
            }
        }

        productos.add(new Producto(nombre, precio, stock));
        System.out.println("✅ Producto agregado con éxito.");
    }

    public void listarProductos(){
        if (productos.isEmpty()){
            System.out.println("No hay productos para mostrar");
        } else {
            for(Producto p: productos){
                p.mostrarDetalles();
            }
        }
    }

    public void buscarProducto(){
        System.out.println("Ingrese el nombre o id del producto que desea buscar:");
        String busqueda = scanner.nextLine().trim();
        boolean esNumero = busqueda.matches("\\d+");
        Producto productoEncontrado = null;

        for(Producto p: productos){
            if (esNumero && p.getId() == Integer.parseInt(busqueda)) {
                productoEncontrado = p;
                break;
            } else if (!esNumero && p.getNombre().toLowerCase().contains(busqueda.toLowerCase())) {
                productoEncontrado = p;
                break;
            }
        }

        if (productoEncontrado != null) {
            productoEncontrado.mostrarDetalles();
            System.out.println("¿Desea actualizar el producto? SI/NO");
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("SI")) {
                actualizarProducto(productoEncontrado);
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void actualizarProducto(Producto p){
        System.out.println("Ingrese el nuevo precio o presione ENTER para mantener el actual:");
        String nuevoPrecio = scanner.nextLine().trim();

        if (!nuevoPrecio.isEmpty()) {
            try {
                double precio = Double.parseDouble(nuevoPrecio);
                p.setPrecio(precio);
                System.out.println("✅ Precio actualizado con éxito.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Precio inválido. No se actualizó.");
            }
        }

        System.out.println("Ingrese el nuevo stock o presione ENTER para mantener el actual:");
        String nuevoStock = scanner.nextLine().trim();

        if (!nuevoStock.isEmpty()) {
            try {
                int stock = Integer.parseInt(nuevoStock);
                p.setStock(stock);
                System.out.println("✅ Stock actualizado con éxito.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Stock inválido. No se actualizó.");
            }
        }
    }

    public void eliminarProducto(){
        listarProductos();
        System.out.println("Indique el ID del producto que desea eliminar:");

        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠️ ID inválido. Operación cancelada.");
            return;
        }

        Producto productoAEliminar = null;
        for (Producto p : productos) {
            if (p.getId() == id) {
                productoAEliminar = p;
                break;
            }
        }

        if (productoAEliminar == null) {
            System.out.println("⚠️ No se encontró un producto con ese ID.");
            return;
        }

        System.out.println("¿Está seguro que desea eliminar el producto \"" + productoAEliminar.getNombre() + "\"? (SI/NO)");
        String respuesta = scanner.nextLine().trim();

        if (respuesta.equalsIgnoreCase("SI")) {
            productos.remove(productoAEliminar);
            System.out.println("✅ Producto eliminado.");
        } else {
            System.out.println("⚠️ Operación cancelada.");
        }
    }

    public int stockById(int id){
        int stock = -1;
        for (Producto p: productos){
            if (id == p.getId()){
                stock = p.getStock();
            }
        }
        return stock;
    }
}
