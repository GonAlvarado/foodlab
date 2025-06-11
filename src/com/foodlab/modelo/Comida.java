package com.foodlab.modelo;

public class Comida extends Producto {
    private String fechaDeVencimiento;

    public Comida(String nombre, double precio, int stock, String fechaDeVencimiento) {
        super(nombre, precio, stock);
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    @Override
    public void mostrarDetalles(){
        System.out.println(">>>>>>>>>> Detalle del producto <<<<<<<<<<");
        System.out.println("Id del producto: " + this.id);
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("Cantidad de producto en stock: " + this.stock);
        System.out.println("Fecha de vencimiento: " + this.fechaDeVencimiento);
    }
}
