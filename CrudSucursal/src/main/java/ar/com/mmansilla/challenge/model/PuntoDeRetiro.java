package ar.com.mmansilla.challenge.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="punto_retiro")
public class PuntoDeRetiro extends Nodo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private long capacidad;

    public PuntoDeRetiro() {
        super(TipoNodo.PUNTO_RETIRO);
        this.capacidad = 0;
    }

    public PuntoDeRetiro(long capacidad) {
        super(TipoNodo.PUNTO_RETIRO);
        this.capacidad = capacidad;
    }
    
    public PuntoDeRetiro(long capacidad, double latitud, double longitud) {
        super(TipoNodo.PUNTO_RETIRO, latitud, longitud);
        this.capacidad = capacidad;
    }

}
