package ar.com.mmansilla.challenge.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Nodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double latitud;
    private double longitud;
    
    public Nodo() {
        this.latitud = 0.0;
        this.longitud = 0.0;
    }
    
    public Nodo(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    public Nodo(int id, double latitud, double longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    

}
