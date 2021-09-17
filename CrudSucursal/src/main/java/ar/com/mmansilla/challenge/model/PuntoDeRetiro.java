package ar.com.mmansilla.challenge.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="punto_retiro")
public class PuntoDeRetiro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Id
    private double latitud;
    private double longitud;
    private long capacidad;

    public PuntoDeRetiro() {
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.capacidad = 0;
    }

    public PuntoDeRetiro(long capacidad) {
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.capacidad = capacidad;
    }
    
    public PuntoDeRetiro(long capacidad, double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.capacidad = capacidad;
    }

    public PuntoDeRetiro(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.capacidad = 0;
    }
}
