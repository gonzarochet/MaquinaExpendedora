package model;

import model.Boleto;

public class Cliente {

    private int id;
    private static int cantClientes = 0;
    private String nombre;
    private int dni;
    private Boleto[] historialCompra;

    public Cliente(String nombre,int dni){
        id = cantClientes +1;
        cantClientes = cantClientes + 1;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Cliente() {

    }

    public String getNombre() {
        return nombre;
    }
    public int getDni() {
        return dni;
    }
    public Boleto[] getHistorialCompra() {
        return historialCompra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setHistorialCompra(Boleto[] historialCompra) {
        this.historialCompra = historialCompra;
    }
}
