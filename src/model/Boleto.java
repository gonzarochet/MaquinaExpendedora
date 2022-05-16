package model;
import java.util.Date;

public class Boleto {

    private Date fechaEmision;
    private static int cantBoletos;
    private int id;
    private float precio;

    public Boleto(float precio) {
        this.precio = precio;
        Date dia = new Date();
        fechaEmision = dia;
        id = cantBoletos + 1;
        cantBoletos = cantBoletos + 1;
    }

    public float getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public static int getCantBoletos() {
        return cantBoletos;
    }

    public static void setCantBoletos(int cantBoletos) {
        Boleto.cantBoletos = cantBoletos;
    }
}
