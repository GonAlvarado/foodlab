package com.foodlab.excepciones;

public class StockInsuficienteException extends Exception{
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
