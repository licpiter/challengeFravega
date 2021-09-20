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
@Table(name="sucursal")
public class Sucursal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double latitud;
    private double longitud;
    private String direccion;
    private String horario_atencion;

    public Sucursal() {
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.direccion = "SIN DATOS";
        this.horario_atencion = "SIN DATOS";
    }
    
    public Sucursal(String direccion, String horario_atencion) {
        this.latitud = 0.0;
        this.longitud = 0.0;
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }
    
    public Sucursal(double latitud, double longitud, String direccion, String horario_atencion) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = direccion;
        this.horario_atencion = horario_atencion;
    }

    public Sucursal(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.direccion = "SIN DATOS";
        this.horario_atencion = "SIN DATOS";
    }
    
}
