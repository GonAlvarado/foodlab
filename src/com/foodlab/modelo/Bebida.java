package com.foodlab.modelo;

public class Bebida extends Producto {
    private double volumenEnLitros;

    public Bebida(int id, String nombre, double precio, int stock, double volumenEnLitros) {
        super(nombre, precio, stock);
        this.volumenEnLitros = volumenEnLitros;
    }
}
