package com.foodlab.modelo;

public class Producto {
    private static int contadorProductos = 0;

    protected int id;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String nombre, double precio, int stock){
        contadorProductos++;
        this.id = contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0){
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0){
            this.stock = stock;
        }
    }

    public void mostrarDetalles(){
        System.out.println(">>>>>>>>>> Detalle del producto <<<<<<<<<<");
        System.out.println("Id del producto: " + this.id);
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("Cantidad de producto en stock: " + this.stock);
    }
}
