package ar.com.mmansilla.challenge.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="punto_retiro")
public class PuntoDeRetiro extends Nodo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long capacidad;

    public PuntoDeRetiro() {
        super();
        this.capacidad = 0;
    }

    public PuntoDeRetiro(long capacidad) {
        super();
        this.capacidad = capacidad;
    }
    
    public PuntoDeRetiro(double latitud, double longitud, long capacidad) {
        super(latitud, longitud);
        this.capacidad = capacidad;
    }

    public PuntoDeRetiro(double latitud, double longitud) {
        super(latitud, longitud);
        this.capacidad = 0;
    }
}
