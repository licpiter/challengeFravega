package ar.com.mmansilla.challenge.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
public class Nodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    private TipoNodo tipo;
    private double latitud;
    private double longitud;
    
    public Nodo(TipoNodo tipo, double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Nodo(TipoNodo tipo) {
        this.tipo = tipo;
        this.latitud = LAT_OBELISCO;
        this.longitud = LON_OBELISCO;
    }
    
    public static final double LAT_OBELISCO = 0.0;
    public static final double LON_OBELISCO = 0.0;
}

enum TipoNodo {
    SUCURSAL, PUNTO_RETIRO;
}

