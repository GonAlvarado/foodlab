package com.foodlab.modelo;

public class Comida extends Producto {
    private String fechaDeVencimiento;

    public Comida(String nombre, double precio, int stock, String fechaDeVencimiento) {
        super(nombre, precio, stock);
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
}
