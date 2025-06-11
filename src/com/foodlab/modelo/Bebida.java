package com.foodlab.modelo;

public class Bebida extends Producto {
    private double volumenEnLitros;

    public Bebida(String nombre, double precio, int stock, double volumenEnLitros) {
        super(nombre, precio, stock);
        this.volumenEnLitros = volumenEnLitros;
    }

    @Override
    public void mostrarDetalles(){
        System.out.println(">>>>>>>>>> Detalle del producto <<<<<<<<<<");
        System.out.println("Id del producto: " + this.id);
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Tamaño: " + this.volumenEnLitros + " litros");
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("Cantidad de producto en stock: " + this.stock);
    }
}
