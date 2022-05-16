package model;

import java.util.ArrayList;
import java.util.Objects;

public class MaquinaExpendedora {

    private static int cantMaquinas;
    private int id;
    private int cantidadBoletosEmitidos;
    private int stock;
    private float recaudacion;
    private float precio;
    private String tipoBoleto;

    // 1. Constructores
    public MaquinaExpendedora(int stock,float precio) {
        this.stock = stock;
        this.precio = precio;
        cantidadBoletosEmitidos = 0;
        recaudacion = 0;
        id = cantMaquinas + 1;
        cantMaquinas = cantMaquinas + 1;
    }


    public MaquinaExpendedora(int stock,float precio, String tipoBoleto){
        this.stock = stock;
        this.precio = precio;
        cantidadBoletosEmitidos = 0;
        recaudacion = 0;
        id = cantMaquinas + 1;
        cantMaquinas = cantMaquinas +1;
        this.tipoBoleto = tipoBoleto;

    }

    public MaquinaExpendedora() {

    }

    // 2. Getters and Setters


    public int getId() {
        return id;
    }

    public int getCantidadBoletosEmitidos(){
        return cantidadBoletosEmitidos;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getTipoBoleto() {
        return tipoBoleto;
    }

    public boolean isStock(){
        boolean key = false;
        if(stock>0){
            key = true;
        }
        return key;
    }
    public boolean isStock(int cantidad){
        boolean key = false;
        if(stock>=cantidad){
            key = true;
        }
        return key;
    }

    public boolean setPrecio(float precio){
        boolean key = false;
        if(precio>0) {
            this.precio = precio;
            key = true;
        }
        return key;
    }

    public void setTipoBoleto(String tipoBoleto) {
        this.tipoBoleto = tipoBoleto;
    }

    // 3. Métodos

    public Boleto imprimirBoleto(){
        Boleto ticket = null;

        if(isStock()) {
            cantidadBoletosEmitidos++;
            recaudacion = recaudacion + precio;
            ticket = new Boleto(precio);
            stock--;
        }
        return ticket;
    }
    public Boleto[] imprimirBoleto(int cantBoletos){
        boolean key = isStock(cantBoletos);
        Boleto[] arrayBoletos = null;

        if(key){
            arrayBoletos =  new Boleto[cantBoletos];;
            cantidadBoletosEmitidos = cantidadBoletosEmitidos + cantBoletos;
            recaudacion = recaudacion + (precio * cantBoletos);
            for(int i = 0; i<cantBoletos;i++){
                arrayBoletos[i] = new Boleto(precio);
                stock--;
            }
        }
        return arrayBoletos;
    }


    /**
    * Este método agrega y acumula al stock ya existente.
    */
    public boolean addStock(int newStock){
        boolean key = false;
        if(newStock >=0){
            stock = stock + newStock;
            key = true;
        }
        return key;
    }

    public float vaciarRecaudacion(){
        float key = 0;
        if(recaudacion>0){
            key = recaudacion;
            recaudacion = 0;
        }
        return key;
    }

    @Override
    public boolean equals(Object o) {
        MaquinaExpendedora otraMaquina = (MaquinaExpendedora)o;
        if (this.id == otraMaquina.getId())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, tipoBoleto);
    }
}
